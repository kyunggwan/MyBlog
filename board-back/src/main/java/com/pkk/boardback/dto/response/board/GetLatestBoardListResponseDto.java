package com.pkk.boardback.dto.response.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pkk.boardback.common.ResponseCode;
import com.pkk.boardback.common.ResponseMessage;
import com.pkk.boardback.dto.object.BoardListItem;
import com.pkk.boardback.dto.response.ResponseDto;
import com.pkk.boardback.entity.BoardListViewEntity;

import lombok.Getter;

@Getter
public class GetLatestBoardListResponseDto extends ResponseDto {

    private List<BoardListItem> latestList;

    private GetLatestBoardListResponseDto(List<BoardListViewEntity> BoardEnties) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.latestList = BoardListItem.getList(BoardEnties);
    }

    public static ResponseEntity<GetLatestBoardListResponseDto> success(List<BoardListViewEntity> boardEnties) {
        GetLatestBoardListResponseDto result = new GetLatestBoardListResponseDto(boardEnties);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
