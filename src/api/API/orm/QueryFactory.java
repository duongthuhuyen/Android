package api.API.orm;



import api.API.orm.impl.QuerryImpl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class QueryFactory {
    private QueryFactory(){}

    public static <T> Querry<T> eq(String column,Object value){
        return new QuerryImpl<>(column,Expression::eq,value);
    }

    public static <T> Querry<T> notEqual(String column, Object value) {
        return new QuerryImpl<>(column, Expression::notEqual, value);
    }

    public static <T> Querry<T> gt(String columnName, Object value) {
        return new QuerryImpl<>(columnName, Expression::gt, value);
    }

    public static <T> Querry<T> gte(String column, Object value) {
        return new QuerryImpl<>(column, Expression::gte, value);
    }

    public static <T> Querry<T> lt(String column, Object value) {
        return new QuerryImpl<>(column, Expression::lt, value);
    }

    public static <T> Querry<T> lte(String column, Object value) {
        return new QuerryImpl<>(column, Expression::lte, value);
    }

    public static <T> Querry<T> like(String column, Object value) {
        return new QuerryImpl<>(column, Expression::like, "%" + value + "%");
    }

    public static <T> Querry<T> isNull(String column) {
        return new QuerryImpl<>(column, Expression::isNULL);
    }

    public static <T> Querry<T> isNotNull(String column) {
        return new QuerryImpl<>(column, Expression::isNotNull);
    }

    public static <T> Querry<T> and(Querry<T> query, Querry<T> query1) {
        String conditionBuilder = query.condition() + Expression.and() + query1.condition();
        var objects = List.of(query.value(), query1.value());

        return new QuerryImpl<>(conditionBuilder, objects);
    }

    public static <T> Querry<T> or(Querry<T> query1, Querry<T> query2) {

        String conditionBuilder = query1.condition() + Expression.or() + query2.condition();
        var objects = List.of(query1.value(), query2.value());

        return new QuerryImpl<>(conditionBuilder, objects);
    }

    public static <T> Querry<T> and(List<Querry<T>> queries) {
        var rs = queries.stream().filter(Objects::nonNull).toList();
        if (rs.size() == 1) {
            return new QuerryImpl<>(rs.get(0).condition(), rs.get(0).value());
        }
        var condition = rs.stream().map(Querry::condition).collect(Collectors.joining(Expression.and()));
        var objects = rs.stream().map(Querry::value).collect(Collectors.toList());

        return new QuerryImpl<>(condition, objects);
    }

    public static <T> Querry<T> or(List<Querry<T>> queries) {
        var rs = queries.stream().filter(Objects::nonNull).toList();
        if (rs.size() == 1) {
            return new QuerryImpl<>(rs.get(0).condition(), rs.get(0).value());
        }
        var condition = rs.stream().map(Querry::condition).collect(Collectors.joining(Expression.or()));
        var objects = rs.stream().map(Querry::value).collect(Collectors.toList());

        return new QuerryImpl<>(condition, objects);
    }
}
