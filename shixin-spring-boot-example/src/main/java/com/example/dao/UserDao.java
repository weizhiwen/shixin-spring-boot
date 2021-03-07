package com.example.dao;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.shixin.dal.dao.BaseRdsDaoImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * @author shixin
 * @date 2021/2/27
 */
@Repository
public class UserDao extends BaseRdsDaoImpl<UserRepository, User> {
    public UserDao(UserRepository repository, EntityManager entityManager) {
        super(repository, entityManager);
    }
}
