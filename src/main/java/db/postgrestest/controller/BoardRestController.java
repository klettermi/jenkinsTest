package db.postgrestest.controller;

import db.postgrestest.dto.ResultResponseDto;
import db.postgrestest.entity.Board;
import db.postgrestest.repository.BoardRepository;
import db.postgrestest.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardRestController {
    private final BoardService boardService;

    @GetMapping
    public ResultResponseDto retrieveBoardList(){
        ResultResponseDto result = boardService.retrieveBoardList();
        return result;
    }

    @GetMapping("/{boardNo}")
    public ResultResponseDto retrieveBoard(@PathVariable Integer boardNo){
        ResultResponseDto result = boardService.retrieveBoard(boardNo);
        return result;
    }

    @PostMapping
    public ResultResponseDto createBoard(@ModelAttribute Board board){
        ResultResponseDto result = boardService.createBoard(board);
        return result;
    }

    @PutMapping
    public ResultResponseDto updateBoard(@ModelAttribute Board board){
        ResultResponseDto result = boardService.updateBoard(board);
        return result;
    }

    @DeleteMapping
    public ResultResponseDto deleteBoard(@RequestParam int boardNo){
        ResultResponseDto result = boardService.deleteBoard(boardNo);
        return result;
    }
}
