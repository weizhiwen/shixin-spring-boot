//package com.example.service;
//
//import com.shixin.dal.dao.BaseRedisDao;
//import com.shixin.framework.service.BaseService;
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.Resource;
//
///**
// * @author shixin
// * @date 2021/2/27
// */
//@Slf4j
//@Service
//@RequiredArgsConstructor
//@Transactional(rollbackFor = Exception.class)
//public class RedisService implements BaseService {
//    final BaseRedisDao baseRedisDao;
//
//    public boolean set(String key, String value) {
//        return baseRedisDao.set(key, value);
//    }
//}
