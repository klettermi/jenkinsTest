package db.postgrestest.service;

import db.postgrestest.dto.ResultResponseDto;
import db.postgrestest.entity.Board;

public interface BoardService {
    public ResultResponseDto createBoard(Board board);
    public ResultResponseDto retrieveBoardList();
    public ResultResponseDto retrieveBoard(int boardNo);
    public ResultResponseDto updateBoard(Board board);
    public ResultResponseDto deleteBoard(int boardNo);
}
