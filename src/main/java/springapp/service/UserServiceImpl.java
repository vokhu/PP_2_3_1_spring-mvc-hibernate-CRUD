package springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springapp.DAO.UserDAO;
import springapp.entity.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional//(readOnly = true)
public class UserServiceImpl implements springapp.service.UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    public void saveUser(User user) {
        userDAO.save(user);
    }

    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }
}
