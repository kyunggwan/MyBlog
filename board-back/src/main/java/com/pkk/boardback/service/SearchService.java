package com.pkk.boardback.service;

import org.springframework.http.ResponseEntity;
import com.pkk.boardback.dto.response.search.GetPopularListResponseDto;

public interface SearchService {

    ResponseEntity<? super GetPopularListResponseDto> getPopularList();
}
