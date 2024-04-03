package com.turing.api.user;


import com.turing.api.enums.Messenger;
import com.turing.api.proxy.TypeProxy;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private final UserService service;
    private final UserRepository repository;

    @PostMapping(path = "/api/login")
    public Map<String, ?> login(@RequestBody Map<?, ?> paramap) {
        Map<String, Messenger> response = new HashMap<>();

        String username = (String)paramap.get("username");

        User user = repository.findByUsername(username).orElse(null);

         response.put("messege" , user==null ?
                 Messenger.FAIL : user.getPassword().equals(paramap.get("password")) ?
                 Messenger.SUCCESS : Messenger.WRONG_PASSWORD);

        return response;
    }

    @PostMapping(path = "/api/users")
    public Map<String, ?> join(@RequestBody Map<String, ?> paramap) {
        System.out.println("입력받은 아이디 : " + paramap.get("username"));

        User user = repository.save(User.builder()
                .username((String) paramap.get("username"))
                .password((String) paramap.get("password"))
                .name((String) paramap.get("name"))
                .job((String) paramap.get("job"))
                .phone((String) paramap.get("phone"))
                .height(TypeProxy.doubleOf.apply((String)paramap.get("height")))
                .weight(TypeProxy.doubleOf.apply((String)paramap.get("weight")))
                .build());

        System.out.println("DB에 저장된 User 정보 : " + user);
        Map<String, Messenger> map = new HashMap<>();
        map.put("messege", Messenger.SUCCESS);

        return map;
    }

    @GetMapping("/api/all-users")
    public Map<?,?>findAll(){
        Map<String,Object> map = new HashMap<>();
        List<User> ls = repository.findAll();
        map.put("messege",Messenger.SUCCESS);
        map.put("result",ls);
        return map;
    }


    public Map<String, ?> findUserBYId(@RequestBody Map<?, ?> paramap) {
        Map<String, String> response = new HashMap<>();
        return response;
    }

    public Map<String, ?> addUsers() {
        Map<String, String> response = new HashMap<>();
        return response;
    }


    public Map<String, ?> updatePassword(@RequestBody Map<?, ?> paramap) {
        Map<String, String> response = new HashMap<>();
        return response;
    }

    public Map<String, ?> deleteUser(@RequestBody Map<?, ?> paramap) {
        Map<String, String> response = new HashMap<>();

        return response;
    }

    public Map<String, ?> getUserList() {
        Map<String, String> response = new HashMap<>();

        return response;
    }

    public Map<String, ?> findUserByName(@RequestBody Map<?, ?> paramap) {
        Map<String, String> response = new HashMap<>();
        return response;

    }


    public Map<String, ?> findUserByJob(@RequestBody Map<?, ?> paramap) {
        Map<String, String> response = new HashMap<>();
        return response;
    }

    public Map<String, ?> countUser() {
        Map<String, String> response = new HashMap<>();
        return response;
    }

    public Map<String, ?> getOne(@RequestBody Map<?, ?> paramap) throws SQLException {
        Map<String, String> response = new HashMap<>();
        return response;
    }

    public Map<String, ?> findUsers() throws SQLException {
        Map<String, String> response = new HashMap<>();

        return response;
    }

    public Map<String, ?> getUser(@RequestBody Map<?, ?> paramap) throws SQLException {
        Map<String, String> response = new HashMap<>();

        return response;
    }

    public Map<String, ?> touchTable() throws SQLException {
        Map<String, String> response = new HashMap<>();
        return response;
    }

    public Map<String, ?> removeTable() throws SQLException {
        Map<String, String> response = new HashMap<>();
        return response;
    }


}
