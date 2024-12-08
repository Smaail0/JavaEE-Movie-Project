package dao;

import java.util.List;

import beans.User;

public interface UserDaoImp {
    
	void add(User User);
    User getById(int id);
    List<User> getAll();
    void update(User user);
    void delete(int id);
    
}

