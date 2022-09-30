package dao;

import java.util.List;

public abstract class DAO<T> {
    
    public abstract void create(T t);
    public abstract T findBy(String id);
    public abstract void update(T t);
    public abstract List<T> filter(String filtro);
    public abstract List<T> getList();
}
