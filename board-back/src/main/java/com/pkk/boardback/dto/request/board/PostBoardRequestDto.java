package com.pkk.boardback.dto.request.board;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostBoardRequestDto {

    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotNull // 빈 배열이 올 수도 있지만 해당 필드는 반드시 있어야 함
    private List<String> boardImageList;
}
