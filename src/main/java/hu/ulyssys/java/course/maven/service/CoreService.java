package hu.ulyssys.java.course.maven.service;

import hu.ulyssys.java.course.maven.entity.AbstractEntity;

import java.util.List;

public interface CoreService<T extends AbstractEntity> {
    List<T> getAll();

    void add(T entity);

    void update(T entity);

    void remove(T entity);
}
