package com.turing.api.common;

import com.turing.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractService<T> {
    public abstract Map<String, ?> save (T t) throws SQLException;
    public abstract Map<String, ?> findAll() throws SQLException;
    public abstract Map<String, ?> findById(Long id);
    public abstract Map<String, ?> count();
    public abstract Map<String, ?> getOne(String id) throws SQLException;
    public abstract Map<String, ?> delete (T t);
    public abstract Map<String, ?> existsById(Long id);

}
