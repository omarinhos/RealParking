package servicio;

import java.util.List;

public interface IDAO<T> {
    
    void create(T t);
    T findBy(String user);
    void update(T t);
    List<T> find(String buscar);
    List<T> getList();
}
