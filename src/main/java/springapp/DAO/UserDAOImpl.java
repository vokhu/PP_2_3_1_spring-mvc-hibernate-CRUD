package springapp.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springapp.entity.User;

import javax.persistence.EntityManager;
/*import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;*/
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private final EntityManager entityManager;
    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserById (int id) {
        /*TypedQuery<User> query = entityManager.createQuery("select u from User u where id = :id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();*/
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }

    }
}
