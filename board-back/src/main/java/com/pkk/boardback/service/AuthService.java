package com.pkk.boardback.service;

import org.springframework.http.ResponseEntity;

import com.pkk.boardback.dto.request.auth.SignInRequestDto;
import com.pkk.boardback.dto.request.auth.SignUpRequestDto;
import com.pkk.boardback.dto.response.auth.SignInResponseDto;
import com.pkk.boardback.dto.response.auth.SignUpResponseDto;

public interface AuthService {

    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);

    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
}
