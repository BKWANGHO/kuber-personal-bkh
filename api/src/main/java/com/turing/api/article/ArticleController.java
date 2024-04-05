package com.turing.api.article;

import com.turing.api.article.model.ArticleDto;
import com.turing.api.article.service.ArticleService;
import com.turing.api.common.component.MessengerVo;
import com.turing.api.common.component.PageRequestVo;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RequiredArgsConstructor
@RequestMapping("/api/articles")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ArticleController {
    private final ArticleService service;

    @PostMapping("")
    public ResponseEntity<MessengerVo> save(ArticleDto articleDto){
        service.save(articleDto);
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
    @GetMapping("/exists{id}")
    public ResponseEntity<MessengerVo> existsById(@PathVariable long id){
        service.existsById(id);
        return ResponseEntity.ok(new MessengerVo());
    }


}
