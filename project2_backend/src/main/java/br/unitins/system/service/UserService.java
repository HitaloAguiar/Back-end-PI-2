package br.unitins.system.service;

import java.util.List;

import br.unitins.system.dto.NewPasswordDTO;
import br.unitins.system.dto.UpdateUserDataDTO;
import br.unitins.system.model.User;

public interface UserService {
    
    List<User> getAll();

    User getById(Long id);

    void insert(User user);

    void update(Long id, User user);

    void delete(Long id);

    void update(Long id, NewPasswordDTO passwordDTO);

    void update(Long id, UpdateUserDataDTO user);
}
