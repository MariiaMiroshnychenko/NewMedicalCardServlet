package model.dao;

public interface GenericDao<T> extends AutoCloseable {
    void close();
    void create(T t);
    void update();
}
