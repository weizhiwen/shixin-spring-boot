//package com.example.service;
//
//import com.example.dao.BlogDao;
//import com.example.entity.Blog;
//import com.shixin.framework.service.BaseService;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
///**
// * @author shixin
// * @date 2021/2/27
// */
//@Slf4j
//@Service
//@AllArgsConstructor
//@Transactional(rollbackFor = Exception.class)
//public class BlogService implements BaseService {
//    final BlogDao blogDao;
//
//    public Blog createBlog(Blog blog) {
//        return blogDao.create(blog);
//    }
//
//    public List<Blog> listBlog() {
//        return blogDao.findAll();
//    }
//
//    public Page<Blog> pageBlog(Pageable pageable) {
//        return blogDao.pageQuery(new Blog(), pageable);
//    }
//
//    public Blog blogDetails(String id) {
//        return blogDao.findById(id);
//    }
//
//    public Blog updateBlog(String id, Blog blog) {
//        blog.setId(id);
//        return blogDao.update(blog);
//    }
//
//    public void deleteBlog(String id) {
//        blogDao.deleteById(id);
//    }
//
//    public List<Blog> batch1CreateBlog(List<Blog> blogList) {
//        List<Blog> all = blogDao.createAll(blogList);
//        System.gc();
//        return all;
//    }
//
//    public List<Blog> batch2CreateBlog(List<Blog> blogList) {
//        List<Blog> blogs = blogDao.batchCreateAll(blogList);
//        System.gc();
//        return blogs;
//    }
//
//    public Object batch3CreateBlog(List<Blog> blogList) {
//        List<Blog> blogs = blogDao.batchCreateAll(blogList, 100000);
//        System.gc();
//        return blogs;
//    }
//}
