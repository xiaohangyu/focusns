package org.focusns.console.impl;

import org.focusns.dao.console.UserDao;
import org.focusns.model.console.User;
import org.focusns.service.console.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getUser(long userId) {
        return userDao.select(userId);
    }

    public void createUser(User user) {
        userDao.insert(user);
    }

    public void modifyUser(User user) {
        userDao.update(user);
    }

    public void removeUser(User user) {
        userDao.delete(user.getId());
    }

    public void assignRole(long userId, long roleId) {
        userDao.assign(userId, roleId);
    }

    public void unassignRole(long userId, long roleId) {
        userDao.unassign(userId, roleId);
    }

}
