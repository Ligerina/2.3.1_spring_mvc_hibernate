package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getListUser() {
        System.out.println("СЕЙЧАС НАХОЖУСЬ В ГЕТ ЮСЕР ");
        List<User> a = entityManager.createQuery("SELECT u from User u", User.class).getResultList();
        System.out.println("Печатаю лист юзеров");
        System.out.println(a);
        return entityManager.createQuery("SELECT u from User u", User.class).getResultList();
    }

    @Override
    public void addUser(String name, String surname, String department, String location) {
        User user = new User(name, surname, department, location);
        entityManager.persist(user);
    }

    @Override
    public User getUser(int id) {
        TypedQuery<User> typedQuery = entityManager.createQuery("SELECT u from User u where u.getId = :id", User.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }

}
