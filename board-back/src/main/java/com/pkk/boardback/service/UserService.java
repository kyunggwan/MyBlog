package com.pkk.boardback.service;

import org.springframework.http.ResponseEntity;

import com.pkk.boardback.dto.request.user.PatchNicknameRequestDto;
import com.pkk.boardback.dto.request.user.PatchProfileImageRequestDto;
import com.pkk.boardback.dto.response.user.GetSignInUserResponseDto;
import com.pkk.boardback.dto.response.user.GetUserResponseDto;
import com.pkk.boardback.dto.response.user.PatchNicknameResponseDto;
import com.pkk.boardback.dto.response.user.PatchProfileImageResponseDto;

public interface UserService {

    ResponseEntity<? super GetUserResponseDto> getUser(String email);

    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email);

    ResponseEntity<? super PatchNicknameResponseDto> patchNickname(PatchNicknameRequestDto dto, String email);

    ResponseEntity<? super PatchProfileImageResponseDto> patchProfileImage(PatchProfileImageRequestDto dto,
            String email);

}
