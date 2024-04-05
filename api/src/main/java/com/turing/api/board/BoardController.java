package com.turing.api.board;

import com.turing.api.article.model.ArticleDto;
import com.turing.api.board.model.BoardDto;
import com.turing.api.board.service.BoardService;
import com.turing.api.common.component.MessengerVo;
import com.turing.api.common.component.PageRequestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class BoardController {
private final BoardService service;

    @PostMapping("")
    public ResponseEntity<MessengerVo> save(BoardDto boardDto){
        service.save(boardDto);
        return ResponseEntity.ok(new MessengerVo());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MessengerVo> deleteById(@PathVariable long id){
        service.deleteById(id);
        return ResponseEntity.ok(new MessengerVo());
    }
    @GetMapping("")
    public ResponseEntity<MessengerVo> findAll(PageRequestVo vo){
        service.findAll(vo);
        return ResponseEntity.ok(new MessengerVo());
    }
    @GetMapping("/{id}")
    public ResponseEntity<MessengerVo> findById(@PathVariable long id){
        service.findById(null);
        return ResponseEntity.ok(new MessengerVo());
    }
    @GetMapping("/count")
    public ResponseEntity<MessengerVo> count(){
        service.count();
        return ResponseEntity.ok(new MessengerVo());
    }
    @GetMapping("/exists/{id}")
    public ResponseEntity<MessengerVo> existsById(@PathVariable long id){
        service.existsById(id);
        return ResponseEntity.ok(new MessengerVo());
    }

}
