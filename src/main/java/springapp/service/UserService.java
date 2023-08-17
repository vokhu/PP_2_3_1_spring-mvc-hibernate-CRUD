package springapp.service;

import springapp.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(int id);

    void saveUser(User user);

    public void deleteUser(int id);
}
