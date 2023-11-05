package com.pkk.boardback.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pkk.boardback.dto.request.auth.SignInRequestDto;
import com.pkk.boardback.dto.request.auth.SignUpRequestDto;
import com.pkk.boardback.dto.response.ResponseDto;
import com.pkk.boardback.dto.response.auth.SignInResponseDto;
import com.pkk.boardback.dto.response.auth.SignUpResponseDto;
import com.pkk.boardback.entity.UserEntity;
import com.pkk.boardback.provider.JwtProvider;
import com.pkk.boardback.repository.UserRepository;
import com.pkk.boardback.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplements implements AuthService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {

        try {
            String email = dto.getEmail();
            boolean existedEmail = userRepository.existsByEmail(email);
            if (existedEmail)
                return SignUpResponseDto.duplicateEmail();

            String nickname = dto.getNickname();
            boolean existedNickname = userRepository.existsByNickname(nickname);
            if (existedNickname)
                return SignUpResponseDto.duplicateNickname();

            String telNumber = dto.getTelNumber();
            boolean existedTelNumber = userRepository.existsByTelNumber(telNumber);
            if (existedTelNumber)
                return SignUpResponseDto.duplicateTelNumber();

            String password = dto.getPassword();
            String EncodedPassword = passwordEncoder.encode(password);
            dto.setPassword(EncodedPassword);

            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return SignUpResponseDto.success();
    }

    @Override
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {

        String token = null;

        try {
            String email = dto.getEmail();
            UserEntity userEntity = userRepository.findByEmail(email);
            if (userEntity == null)
                return SignInResponseDto.signInFail();

            String password = dto.getPassword();
            String encodedPassword = userEntity.getPassword();
            boolean isMatched = passwordEncoder.matches(password, encodedPassword);

            if (!isMatched)
                return SignInResponseDto.signInFail();

            token = jwtProvider.create(email);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return SignInResponseDto.success(token);
    }

    /*
     * 의존성 주입 1. 필드를 통한 의존성 주입
     * 
     * @Autowired
     * private UserRepository userRepository;
     * 
     * 의존성 주입 2. 생성자를 통한 의존성 주입(스프링 다큐먼트 권장)
     * 
     * @Autowired
     * public AuthServiceImplements(UserRepository userRepository) {
     * this.userRepository = userRepository;
     * }
     * ++) final로 선언하고, @RequiredArgsConstructor를 선언하면 생성자를 통한 의존성 주입
     * 
     * 의존성 주입 3. Setter메소드를 통한 주입
     * 이때는 final로 필드 생성하지 않음
     * 
     * @Autowired
     * public void setUserRepository(UserRepository userRepository) {
     * this.userRepository = userRepository;
     * }
     * 
     * 생성자를 통한 의존성 주입을 추천하는 이유
     * - 필드, Setter 주입은 비어있는 상태가 발생(userRepository가 비어있는 상태가 발생)
     * - 비어있는 경우를 만들지 않는 것이 생성자를 통한 의존성 주입
     * => 생성자 주입은 의존성이 최초 객체 생성시에 생김.
     * => 필드, Setter 주입은 인스턴스가 만들어지고, 의존성을 할당 되므로 일시적으로 완전하지 않은 상태에 있을 수 있음.
     */

}
