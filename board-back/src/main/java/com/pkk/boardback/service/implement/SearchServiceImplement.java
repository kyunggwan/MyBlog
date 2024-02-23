package com.pkk.boardback.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pkk.boardback.dto.response.ResponseDto;
import com.pkk.boardback.dto.response.search.GetPopularListResponseDto;
import com.pkk.boardback.repository.SearchLogRepository;
import com.pkk.boardback.repository.resultSet.GetPopularListResultSet;
import com.pkk.boardback.service.SearchService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchServiceImplement implements SearchService {

    private final SearchLogRepository searchLogRepository;

    @Override
    public ResponseEntity<? super GetPopularListResponseDto> getPopularList() {

        List<GetPopularListResultSet> resultSets = new ArrayList<>();

        try {
            resultSets = searchLogRepository.getPopularList();
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetPopularListResponseDto.success(resultSets);
    }

}
