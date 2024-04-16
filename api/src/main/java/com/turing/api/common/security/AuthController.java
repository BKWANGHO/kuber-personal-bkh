package com.turing.api.common.security;


import com.turing.api.common.component.Messenger;
import com.turing.api.common.security.service.AuthService;
import com.turing.api.user.model.UserDto;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ApiResponses({
        @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
        @ApiResponse(responseCode = "404", description = "NOT FOUND"),
        @ApiResponse(responseCode = "200", description = "SUCCESS"),
})
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class AuthController {

    private final AuthService service;

    @PostMapping("/login")
    public ResponseEntity<Messenger> login(@RequestBody UserDto param){
        log.info("입력받은 정보 : {}",param);
        return ResponseEntity.ok(service.login(param));
    }
}
