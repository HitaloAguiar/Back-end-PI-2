package br.unitins.system.service;

import java.util.List;

public interface ProjectService {
    void addItemIntoProject(Long id, Object item);

    void removeItemProject(Long id);

    List<Object> getAll();

    Object getById(Long id);

    void insert(Object user);

    void update(Long id, Object user);

    void delete(Long id);
}
