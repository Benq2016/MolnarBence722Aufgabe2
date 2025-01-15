package src.Repository;

import java.util.List;

public interface Repository<T>{
    void add(T object);
    void remove(Integer id);
    void update(T object);
    T get(Integer id);
    List<T> getAll();
}
