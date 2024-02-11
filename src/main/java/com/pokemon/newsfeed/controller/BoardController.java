package com.pokemon.newsfeed.controller;

import com.pokemon.newsfeed.dto.requestDto.BoardUpdateDto;
import com.pokemon.newsfeed.dto.responseDto.BoardResponseDto;
import com.pokemon.newsfeed.entity.Board;
import com.pokemon.newsfeed.security.UserDetailsImpl;
import com.pokemon.newsfeed.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;

    @PutMapping("/{boardnum}")
    public ResponseEntity<BoardResponseDto> updateBoard(
            @PathVariable Long boardnum,
            @RequestBody BoardUpdateDto requestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Board board = boardService.updateBoard(boardnum, requestDto, userDetails.getUser());
        BoardResponseDto boardResponseDto = new BoardResponseDto(board);

        return new ResponseEntity<>(boardResponseDto, HttpStatus.OK);
    }
}
