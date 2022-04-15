package dev.alexgrechishnikov.pp_3_1.dao;

import dev.alexgrechishnikov.pp_3_1.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class UserDaoHibernate implements UserDao {

    private final EntityManager manager;

    public UserDaoHibernate(EntityManager manager) {
        this.manager = manager;
    }


    @Override
    public void add(User user) {
        manager.persist(user);
    }

    @Override
    public User get(long id) {
        return manager
                .createQuery("select u from User u where u.id=:id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void update(User user) {
        manager.merge(user);
    }

    @Override
    public void delete(long id) {
        manager.createQuery("delete from User u where u.id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List<User> getUsersList() {
        return manager.createQuery("select u from User u", User.class).getResultList();
    }
}
