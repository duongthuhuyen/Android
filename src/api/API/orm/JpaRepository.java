package api.API.orm;




import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface JpaRepository<T,ID extends Serializable> {
    /* void save(T t);
     void update(ID id,T t);
     Optional<T> findById(ID id);
     T getOne(ID id);
     Page<T> findAll(PageAble pageAble);
     List<T> findAll();
     long count();
     boolean delete(ID id);
     boolean deleteAll(List<ID> id);*/
    void save(T t);

    void update(ID id, T t);

    Optional<T> findById(ID id);

    T getOne(ID id);


    List<T> findAll();

    long count();

    boolean delete(ID id);

    boolean deleteAll(List<ID> ids);

    Optional<T> find(Querry<T> query);

    long count(Querry<T> query);
}
