package com.example.service;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.shixin.framework.service.BaseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author shixin
 * @date 2021/2/27
 */
@Slf4j
@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class UserService implements BaseService {
    final UserDao userDao;

    public User createUser(User user) {
        return userDao.insert(user);
    }

    public List<User> batch1CreateUser(List<User> userList) {
        return userDao.multiInsert(userList);
    }

    public List<User> batch2CreateUser(List<User> userList) {
        return userDao.batchInsert(userList, 10000);
    }

    public List<User> listUser() {
        return userDao.findAll();
    }

    public Page<User> pageUser(Pageable pageable) {
        return userDao.pageQuery(new User(), pageable);
    }

    public User userDetails(Integer id) {
        return userDao.findById(id);
    }

    public User updateUser(Integer id, User user) {
        user.setId(id);
        return userDao.update(user);
    }

    public void deleteUser(Integer id) {
        userDao.deleteById(id);
    }


}
