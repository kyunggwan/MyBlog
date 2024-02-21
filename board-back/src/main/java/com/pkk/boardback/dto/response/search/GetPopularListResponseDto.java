package com.pkk.boardback.dto.response.search;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pkk.boardback.common.ResponseCode;
import com.pkk.boardback.common.ResponseMessage;
import com.pkk.boardback.dto.response.ResponseDto;

import lombok.Getter;

@Getter
public class GetPopularListResponseDto extends ResponseDto {

    private List<String> popularWordList;

    private GetPopularListResponseDto() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    public static ResponseEntity<GetPopularListResponseDto> success() {
        GetPopularListResponseDto result = new GetPopularListResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
