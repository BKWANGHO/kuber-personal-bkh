package com.turing.api.user;

import com.turing.api.common.component.MessengerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class UserController {
    private final UserService service;
    private final UserRepository repository;

    @PostMapping(path = "/api/login")
    public Map<String, ?> login(@RequestBody Map<?, ?> paramap) {
        Map<String, MessengerVo> response = new HashMap<>();
        String username = (String)paramap.get("username");
        User user = repository.findByUsername(username).orElse(null);

        return response;
    }

    @PostMapping(path = "/api/users")
    public Map<String, ?> join(@RequestBody Map<String, ?> paramap) {
        System.out.println("입력받은 아이디 : " + paramap.get("username"));
        User user = repository.save(User.builder()
                .username((String)paramap.get("username"))
                .password((String)paramap.get("password"))
                .name((String)paramap.get("name"))
                .job((String)paramap.get("job"))
                .phone((String)paramap.get("phone"))
//                .height(TypeProxy.doubleOf.apply((String)paramap.get("height")))
//                .weight(TypeProxy.doubleOf.apply((String)paramap.get("weight")))
                .build());
        System.out.println("DB에 저장된 User 정보 : " + user);
        Map<String, MessengerVo> map = new HashMap<>();

        return map;
    }

    @GetMapping("/api/all-users")
    public Map<?,?>findAll(){
        Map<String,Object> map = new HashMap<>();
        List<User> ls = repository.findAll();
        map.put("result",ls);
        return map;
    }

    public Map<?,?> insertMany(){
        Map<String,Object> map = new HashMap<>();
        return map;
    }



}
