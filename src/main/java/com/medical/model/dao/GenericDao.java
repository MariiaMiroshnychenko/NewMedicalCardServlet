package com.medical.model.dao;

public interface GenericDao<T> extends AutoCloseable {
    void close();
    void create(T t);
    void update(Object field, Integer id, String query);
}
