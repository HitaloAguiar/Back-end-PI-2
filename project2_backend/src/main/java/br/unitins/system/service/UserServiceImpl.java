package br.unitins.system.service;

import java.util.List;

import br.unitins.system.model.User;
import br.unitins.system.repository.UserRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    UserRepository userRepository;

    private Sort sort = Sort.by("id").ascending();

    @Override
    public List<User> getAll() {

        return userRepository.findAll(sort).list();
    }

    @Override
    public User getById(Long id) throws NotFoundException {

        User user = userRepository.findById(id);

        if (user == null)
            throw new NotFoundException("Não encontrado");

        return user;
    }

    @Override
    @Transactional
    public void insert(User user) {

        User newUser = new User();

        newUser.setCpf(user.getCpf());

        newUser.setName(user.getName());

        newUser.setEmail(user.getEmail());

        newUser.setPassword(user.getPassword());

        newUser.setPhoneNumber(user.getPhoneNumber());

        newUser.setRole(user.getRole());

        userRepository.persist(newUser);
    }

    @Override
    @Transactional
    public void update(Long id, User user) throws NotFoundException {

        User userToBeUpdated = userRepository.findById(id);

        if (userToBeUpdated == null)
            throw new NotFoundException("Número fora das opções disponíveis");

        userToBeUpdated.setCpf(user.getCpf());

        userToBeUpdated.setName(user.getName());

        userToBeUpdated.setEmail(user.getEmail());

        userToBeUpdated.setPassword(user.getPassword());

        userToBeUpdated.setPhoneNumber(user.getPhoneNumber());

        userToBeUpdated.setRole(user.getRole());
    }

    @Override
    @Transactional
    public void delete(Long id) throws IllegalArgumentException, NotFoundException {
        
        if (id == null)
            throw new IllegalArgumentException("Número inválido");

        User userToBeDeleted = userRepository.findById(id);

        if (userRepository.isPersistent(userToBeDeleted))
            userRepository.delete(userToBeDeleted);

        else
            throw new NotFoundException("Nenhum usuário encontrado");
    }
}
