package servicio;

import java.util.List;

public interface IDAO<T> {
    
    void create(T t);
    T findBy(String id);
    void update(T t);
    List<T> filter(String filtro);
    List<T> getList();
}
