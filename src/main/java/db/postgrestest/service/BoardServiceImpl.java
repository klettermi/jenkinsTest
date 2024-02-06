package db.postgrestest.service;

import db.postgrestest.dto.ErrorResponse;
import db.postgrestest.dto.ResultResponseDto;
import db.postgrestest.entity.Board;
import db.postgrestest.enums.ServiceResult;
import db.postgrestest.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;

    @Override
    public ResultResponseDto createBoard(Board board) {
        board = boardRepository.save(board);
        ResultResponseDto result = new ResultResponseDto();
        result.setPayload(board);
        return result;
    }

    @Override
    public ResultResponseDto retrieveBoardList() {
        List<Board> list = boardRepository.findAllByOrderByBoardnoDesc();
        ResultResponseDto result = new ResultResponseDto();
        result.setPayload(list);
        return result;
    }

    @Override
    public ResultResponseDto retrieveBoard(int boardNo) {
        Optional<Board> optionalBoard = boardRepository.findById(boardNo);
        ResultResponseDto result = new ResultResponseDto();
        if(optionalBoard.isPresent()){
            result.setPayload(optionalBoard.get());
        }else{
            result.setError(new ErrorResponse(ServiceResult.NOEXIST.toString()));
        }
        return result;
    }

    @Override
    public ResultResponseDto updateBoard(Board board) {
        Optional<Board> search = boardRepository.findById(board.getBoardno());
        ResultResponseDto result = new ResultResponseDto();
        if(search.isPresent()){
            board = boardRepository.save(board);
            result.setPayload(board);
        }else{
            result.setError(new ErrorResponse(ServiceResult.NOEXIST.toString()));
        }
        return result;
    }

    @Override
    public ResultResponseDto deleteBoard(int boardNo) {
        ResultResponseDto result = new ResultResponseDto();
        boolean isPresent = boardRepository.findById(boardNo).isPresent();
        if(!isPresent){
            result.setError(new ErrorResponse(ServiceResult.NOEXIST.toString()));
        }else {
            boardRepository.deleteById(boardNo);
        }
        return result;
    }
}
