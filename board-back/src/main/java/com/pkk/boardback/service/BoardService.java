package com.pkk.boardback.service;

import org.springframework.http.ResponseEntity;

import com.pkk.boardback.dto.request.board.PostBoardRequestDto;
import com.pkk.boardback.dto.request.board.PostCommentRequestDto;
import com.pkk.boardback.dto.request.board.PatchBoardRequestDto;
import com.pkk.boardback.dto.response.board.DeleteBoardResponseDto;
import com.pkk.boardback.dto.response.board.GetBoardResponseDto;
import com.pkk.boardback.dto.response.board.PostBoardResponseDto;
import com.pkk.boardback.dto.response.board.PutFavoriteResponseDto;
import com.pkk.boardback.dto.response.board.GetFavoriteListResponseDto;
import com.pkk.boardback.dto.response.board.GetLatestBoardListResponseDto;
import com.pkk.boardback.dto.response.board.IncreaseViewCountResponseDto;
import com.pkk.boardback.dto.response.board.PostCommentResponseDto;
import com.pkk.boardback.dto.response.board.GetCommentListResponseDto;
import com.pkk.boardback.dto.response.board.PatchBoardResponseDto;
import com.pkk.boardback.dto.response.board.GetTop3BoardListResponseDto;
import com.pkk.boardback.dto.response.board.GetSearchBoardListResponseDto;
import com.pkk.boardback.dto.response.board.GetUserBoardListResponseDto;

public interface BoardService {
        ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);

        ResponseEntity<? super GetFavoriteListResponseDto> getFavoriteList(Integer boardNumber);

        ResponseEntity<? super GetCommentListResponseDto> getCommentList(Integer boardNumber);

        ResponseEntity<? super GetLatestBoardListResponseDto> getLatestBoardList();

        ResponseEntity<? super GetTop3BoardListResponseDto> getTop3BoardList();

        ResponseEntity<? super GetSearchBoardListResponseDto> getSearchBoardList(String searchWord,
                        String preSearchWord);

        ResponseEntity<? super GetUserBoardListResponseDto> getUserBoardList(String email);

        ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email);

        ResponseEntity<? super PostCommentResponseDto> postComment(PostCommentRequestDto dto, Integer boardNumber,
                        String email);

        ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String email);

        ResponseEntity<? super PatchBoardResponseDto> patchBoard(PatchBoardRequestDto dto, Integer boardNumber,
                        String email);

        ResponseEntity<? super IncreaseViewCountResponseDto> increaseViewCount(Integer boardNumber);

        ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(Integer boardNumber, String email);

}