package com.pkk.boardback.service;

import org.springframework.http.ResponseEntity;

import com.pkk.boardback.dto.response.user.GetSignInUserResponseDto;

public interface UserService {

    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email);

}
