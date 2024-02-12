package com.pokemon.newsfeed.service;

import com.pokemon.newsfeed.dto.requestDto.BoardDeleteDto;
import com.pokemon.newsfeed.dto.requestDto.BoardUpdateDto;
import com.pokemon.newsfeed.entity.Board;
import com.pokemon.newsfeed.entity.User;
import com.pokemon.newsfeed.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    @Transactional
    public Board updateBoard(Long boardNum, BoardUpdateDto requestDto, User user) { //update 로직입니다.
        Board board = findOne(boardNum);
        if (!board.getUser().equals(user)) {
            throw new IllegalArgumentException("작성자만 삭제/수정할 수 있습니다.");
        }
        board.updateBoard(requestDto);
        return board;
    }

    public void deleteBoard(Long boardnum, User user) { //delete 로직입니다.
        Board board = findOne(boardnum);

        if (!board.getUser().equals(user)) {
            throw new IllegalArgumentException("작성자만 삭제/수정할 수 있습니다.");
        }
        boardRepository.delete(board);
    }


    private Board findOne(Long boardNum) {
        return boardRepository.findById(boardNum).orElseThrow(() -> new IllegalArgumentException("없는 게시글 입니다."));
    }

}
