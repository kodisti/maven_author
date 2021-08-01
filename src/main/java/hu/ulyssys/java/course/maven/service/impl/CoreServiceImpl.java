package hu.ulyssys.java.course.maven.service.impl;

import hu.ulyssys.java.course.maven.entity.AbstractEntity;
import hu.ulyssys.java.course.maven.service.CoreService;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;

public abstract class CoreServiceImpl<T extends AbstractEntity> {
    private List<T> list = new ArrayList<>();

    public List<T> getAll(){
        return list;
    }

    public void add(T entity){
        list.add(entity);
    }

    public void remove(T entity){
        list.remove(entity);
    }
}
