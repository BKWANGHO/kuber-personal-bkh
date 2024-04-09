package com.turing.api.board.service;

import com.turing.api.board.model.Board;
import com.turing.api.board.model.BoardDto;
import com.turing.api.common.service.CommandService;
import com.turing.api.common.service.QueryService;

import java.util.Optional;

public interface BoardService extends CommandService<BoardDto>, QueryService<BoardDto> {

    default Board dtoToEntity(BoardDto boardDto){
        return Board.builder()
                .boardName(boardDto.getBoardName())
                .boardType(boardDto.getBoardType())
                .build();
    }

    default BoardDto entityToDto(Board board){
        return BoardDto.builder()
                .id(board.getId())
                .boardName(board.getBoardName())
                .boardType(board.getBoardType())
                .regDate(String.valueOf(board.getRegDate()))
                .modDate(String.valueOf(board.getRegDate()))
                .build();
    }


}
