package com.turing.api.user;


import com.turing.api.common.AbstractService;
import com.turing.api.enums.Messenger;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class UserServiceImple/* extends AbstractService<User>*/ implements UserService {

    private final UserRepository repository;



//    @Override
//    public Map<String, ?> findAll() throws SQLException {
//        return null;
//    }
//
//    @Override
//    public Map<String, ?> findById(Long id) {
//        return null;
//    }
//
//    @Override
//    public Map<String, ?> count() {
//        return null;
//    }
//
//    @Override
//    public Map<String, ?> getOne(String id) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public Map<String, ?> delete(User user) {
//        return null;
//    }
//
//    @Override
//    public Map<String, ?> existsById(Long id) {
//        return null;
//    }
//
//    @Override
//    public Map<String, ?> login(Map<String, ?> map) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public Map<String, ?> addUsers() {
//        return null;
//    }
//
//    @Override
//    public Map<String, ?> updatePassword(Map<String, ?> map) {
//        return null;
//    }
//
//    @Override
//    public Map<String, ?> findUserByName(Map<String, ?> map) {
//        return null;
//    }
//
//    @Override
//    public Map<String, ?> findUserByJob(Map<String, ?> map) {
//        return null;
//    }
//
//    @Override
//    public Map<String, ?> findUsers() throws SQLException {
//        return null;
//    }
//
//    @Override
//    public Map<String, ?> getUser(Map<String, ?> map) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public Map<String, ?> touchTable() throws SQLException {
//        return null;
//    }
//
//    @Override
//    public Map<String, ?> removeTable() throws SQLException {
//        return null;
//    }
}
