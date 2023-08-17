package springapp.DAO;

import springapp.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    User getUserById(int id);

    void save(User user);

    void deleteUser(int id);
}
