package br.unitins.repository;

import java.util.List;

import br.unitins.model.Role;
import br.unitins.model.User;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
    

    //Consulta para logar

    public User findByEmailAndPassword(String email, String password){
        if (email == null || password == null)
            return null;

        return find("email = ?1 AND password = ?2 ", email, password).firstResult();
    }

    //Consulta de Email

    public User findByEmail(String email) {
        return find("email = ?1 ", email).firstResult();
    }

    //Consulta de Nome

    public List<User> findByNome (String name) {

             if (name == null)
                 return null;
    
             return find("FROM User WHERE UNACCENT(UPPER(name)) LIKE UNACCENT(?1)", "%" + name.toUpperCase() + "%").list();
         }

    public PanacheQuery<User> findByName(String name){

        if (name == null)
            return null;

        return find("UPPER(name) LIKE ?1 ", "%"+name.toUpperCase()+"%");
    }

    // Encontrando todos os usuários com estes papeis
    // Obs: Não testei KKKKK

    public List<User> findAllClients () {

        return find("FROM User WHERE role = ?1", Role.USER_CLIENT).list();
    }

    public List<User> findAllEmployees () {

        return find("FROM User WHERE role = ?1", Role.USER_EMPLOYEE).list();
    }

    public List<User> findAllAdmins () {

        return find("FROM User WHERE role = ?1", Role.ADMIN).list();
    }


}
