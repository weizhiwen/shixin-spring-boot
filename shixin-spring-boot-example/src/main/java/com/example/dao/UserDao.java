package com.example.dao;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.shixin.dal.dao.BaseRdsDaoImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author shixin
 * @date 2021/2/27
 */
@Repository
public class UserDao extends BaseRdsDaoImpl<UserRepository, User> {
}
