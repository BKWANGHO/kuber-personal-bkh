package com.turing.api.user;

import com.turing.api.board.model.BoardDto;
import com.turing.api.common.component.MessengerVo;
import com.turing.api.common.component.PageRequestVo;
import com.turing.api.user.model.User;
import com.turing.api.user.model.UserDto;
import com.turing.api.user.repository.UserRepository;
import com.turing.api.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@ApiResponses({
        @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
        @ApiResponse(responseCode = "404", description = "NOT FOUND"),
        @ApiResponse(responseCode = "200", description = "SUCCESS"),
})
@RequiredArgsConstructor
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class UserController {
    private final UserService service;

    @PostMapping("")
    public ResponseEntity<MessengerVo> save(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(MessengerVo.builder()
                .code("200")
                .message(service.save(userDto).toString())
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessengerVo> deleteById(@PathVariable long id) {
        service.deleteById(id);
        return ResponseEntity.ok(new MessengerVo());
    }

    @GetMapping("")
    public ResponseEntity<MessengerVo> findAll(PageRequestVo vo) {
        return ResponseEntity.ok(MessengerVo.builder()
                .code("200")
                .message(service.findAll(vo).toString()).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessengerVo> findById(@PathVariable long id) {
        service.findById(null);
        return ResponseEntity.ok(new MessengerVo());
    }

    @GetMapping("/count")
    public ResponseEntity<MessengerVo> count() {
        service.count();
        return ResponseEntity.ok(new MessengerVo());
    }

    @GetMapping("/exist/{id}")
    public ResponseEntity<MessengerVo> existsById(@PathVariable long id) {
        service.existsById(id);
        return ResponseEntity.ok(new MessengerVo());
    }


}
