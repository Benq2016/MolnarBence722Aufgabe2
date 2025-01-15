package src.Repository;

import src.Domain.HasID;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class inMemoryRepo<T extends HasID> implements Repository<T> {
    private final Map<Integer, T> data = new HashMap<>();

    @Override
    public void add(T object) {
        data.put(object.getID(), object);
    }

    @Override
    public void remove(Integer id) {
        data.remove(id);
    }

    @Override
    public void update(T object) {
        data.replace(object.getID(), object);
    }

    @Override
    public T get(Integer id) {
        return data.get(id);
    }

    @Override
    public List<T> getAll() {
        return data.values().stream().toList();
    }
}
