package com.pkk.boardback.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkk.boardback.dto.request.user.PatchNicknameRequestDto;
import com.pkk.boardback.dto.request.user.PatchProfileImageRequestDto;
import com.pkk.boardback.dto.response.user.GetSignInUserResponseDto;
import com.pkk.boardback.dto.response.user.GetUserResponseDto;
import com.pkk.boardback.dto.response.user.PatchNicknameResponseDto;
import com.pkk.boardback.dto.response.user.PatchProfileImageResponseDto;
import com.pkk.boardback.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{email}")
    public ResponseEntity<? super GetUserResponseDto> getUser(@PathVariable("email") String email) {

        ResponseEntity<? super GetUserResponseDto> response = userService.getUser(email);
        return response;
    }

    @GetMapping("")
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(@AuthenticationPrincipal String email) { // Authentication
                                                                                                                   // 토큰의
                                                                                                                   // email

        ResponseEntity<? super GetSignInUserResponseDto> response = userService.getSignInUser(email);
        return response;
    }

    @PatchMapping("/nickname")
    public ResponseEntity<? super PatchNicknameResponseDto> patchNickname(
            @RequestBody @Valid PatchNicknameRequestDto requestBody,
            @AuthenticationPrincipal String email) {
        ResponseEntity<? super PatchNicknameResponseDto> response = userService.patchNickname(requestBody, email);
        return response;
    }

    @PatchMapping("/profile-image")
    public ResponseEntity<? super PatchProfileImageResponseDto> patchNickname(
            @RequestBody @Valid PatchProfileImageRequestDto requestBody,
            @AuthenticationPrincipal String email) {
        ResponseEntity<? super PatchProfileImageResponseDto> response = userService.patchProfileImage(requestBody,
                email);
        return response;
    }
}
