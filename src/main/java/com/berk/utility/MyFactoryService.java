package com.berk.utility;

import java.util.List;
import java.util.Optional;

public class MyFactoryService<R extends MyFactoryRepository,T,ID> implements IService<T,ID>{


    R repository;

    public MyFactoryService(R r) {
        this.repository=repository;
    }

    @Override
    public <S extends T> S save(S entity) {
        repository.save(entity);
        return entity;
    }

    @Override
    public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
        repository.saveAll(entities);
        return entities;
    }

    @Override
    public void delete(T entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public List<T> findByEntity(T entity) {
        return repository.findByEntity(entity);
    }

    @Override
    public List<T> findAllByColumnNameAndValue(String columnName, String columnValue) {
        return repository.findAllByColumnNameAndValue(columnName,columnValue);
    }
}
