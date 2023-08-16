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

    @Autowired
    private UserDAO userDAO;
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return null;
    }
}
