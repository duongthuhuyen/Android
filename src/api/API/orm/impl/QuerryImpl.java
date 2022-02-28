package api.API.orm.impl;



import api.API.orm.Expression;
import api.API.orm.Querry;

import java.util.List;

public class QuerryImpl<T> implements Querry<T> {
    private String condition;
    private Object value;
    private List<Object> values;

    public QuerryImpl(String condition, Expression expression, Object value) {
        this.condition = condition + expression.expression() + "?";
        this.value = value;
    }

    public QuerryImpl(String condition, Expression expression) {
        this.condition = condition + expression.expression();
    }

    public QuerryImpl(String condition, List<Object> values){
        this.condition = condition;
        this.values = values;
    }

    public QuerryImpl(String condition, Object value) {
        this.condition = condition;
        this.value = value;
    }

    @Override
    public String condition() {
        return condition;
    }

    @Override
    public Object value() {
        return value;
    }

    @Override
    public List<Object> values() {
        return this.values;
    }

}
