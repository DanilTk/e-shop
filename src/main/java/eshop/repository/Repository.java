package eshop.repository;

public interface Repository<T> {

    T add(T domain);

    T update(T domain);

    T delete(T domain);

    T getAll(T domain);
}
