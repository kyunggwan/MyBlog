import { Board, BoardListItem } from "types/interface";
import { ResponseDto } from "..";

export default interface GetBoardResponseDto extends ResponseDto, Board {
    userBoardList: BoardListItem[];
}