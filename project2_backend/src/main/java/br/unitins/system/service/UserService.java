package br.unitins.system.service;

import java.util.List;

import br.unitins.system.model.User;

public interface UserService {
    
    List<User> getAll();

    User getById(Long id);

    void insert(User user);

    void update(Long id, User user);

    void delete(Long id);
}
