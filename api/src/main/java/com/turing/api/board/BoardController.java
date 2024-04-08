package com.turing.api.board;

import com.turing.api.board.model.BoardDto;
import com.turing.api.board.service.BoardService;
import com.turing.api.common.component.Messenger;
import com.turing.api.common.component.PageRequestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class BoardController {
private final BoardService service;

    @PostMapping("")
    public ResponseEntity<Messenger> save(@RequestBody BoardDto boardDto){
        return ResponseEntity.ok(service.save(boardDto));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Messenger> deleteById(@RequestParam long id){
        return ResponseEntity.ok(service.deleteById(id));
    }
    @GetMapping("/list")
    public ResponseEntity<List<BoardDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/detail")
    public ResponseEntity<Optional<BoardDto>> findById(@RequestParam long id){
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/count")
    public ResponseEntity<Long> count(){
        return ResponseEntity.ok(service.count());
    }
    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsById(@RequestParam long id){
        return ResponseEntity.ok(service.existsById(id));
    }

}
