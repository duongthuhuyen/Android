package api.API.orm;
import java.util.List;

public interface Querry<T>{
    String condition();

    Object value();

    List<Object> values();
}
