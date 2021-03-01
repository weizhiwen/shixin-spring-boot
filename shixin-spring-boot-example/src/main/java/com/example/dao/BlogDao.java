package com.example.dao;

import com.example.entity.Blog;
import com.example.repository.BlogRepository;
import com.shixin.dal.dao.BaseMongoDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * @author shixin
 * @date 2021/2/27
 */
@Repository
public class BlogDao extends BaseMongoDaoImpl<BlogRepository, Blog> {

}
