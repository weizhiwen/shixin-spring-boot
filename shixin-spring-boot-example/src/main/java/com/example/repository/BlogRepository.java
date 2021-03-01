package com.example.repository;

import com.example.entity.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author shixin
 * @date 2021/2/27
 */
public interface BlogRepository extends MongoRepository<Blog, String> {
}
