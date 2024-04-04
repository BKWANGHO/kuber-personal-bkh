package com.turing.api.board;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class BoardController {
private final BoardService boardService;

}
