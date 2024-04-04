package com.turing.api.user;

import com.turing.api.common.command.CommandService;
import com.turing.api.common.query.QueryService;
import lombok.NoArgsConstructor;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;



public interface UserService extends CommandService, QueryService {
    //command
    String updatePassword(User user);

    //query
    List<?> findUsersByName(String name);
    List<?> findUsersByJob(String job);

}
