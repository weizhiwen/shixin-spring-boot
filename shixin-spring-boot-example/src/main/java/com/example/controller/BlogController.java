package com.example.controller;

import cn.hutool.core.util.ObjectUtil;
import com.example.entity.Blog;
import com.example.entity.User;
import com.example.service.BlogService;
import com.example.service.UserService;
import com.shixin.framework.controller.BaseRestController;
import com.shixin.framework.vo.BaseResult;
import com.shixin.framework.vo.JsonResult;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shixin
 * @date 2021/2/27
 */
@RestController
@RequestMapping("blog")
@AllArgsConstructor
public class BlogController extends BaseRestController {
    final BlogService blogService;

    final static int COUNT = 10_000;

    final static List<Blog> BLOG_LIST = new ArrayList<>(COUNT);

    static {
        for (int i = 0; i < COUNT; i++) {
            String random = i + "";
            Blog blog = new Blog().setTitle(random).setContent(random).setAuthor(random);
            blog.setId(random);
            BLOG_LIST.add(blog);
        }
    }


    @PostMapping
    public BaseResult createBlog(@RequestBody Blog blog) {
        return JsonResult.ok(blogService.createBlog(blog));
    }

    @PostMapping("/batch1")
    public BaseResult batch1CreateBlog() {
        return JsonResult.ok(blogService.batch1CreateBlog(ObjectUtil.cloneByStream(BLOG_LIST)));
    }

    @PostMapping("/batch2")
    public BaseResult batch2CreateBlog() {
        return JsonResult.ok(blogService.batch2CreateBlog(ObjectUtil.cloneByStream(BLOG_LIST)));
    }

    @PostMapping("/batch3")
    public BaseResult batch3CreateBlog() {
        return JsonResult.ok(blogService.batch3CreateBlog(ObjectUtil.cloneByStream(BLOG_LIST)));
    }

    @GetMapping
    public BaseResult listBlog() {
        return JsonResult.ok(blogService.listBlog());
    }

    @GetMapping(params = "page")
    public BaseResult pageBlog(@PageableDefault Pageable pageable) {
        return JsonResult.ok(blogService.pageBlog(pageable));
    }

    @GetMapping("/{id}")
    public BaseResult blogDetails(@PathVariable String id) {
        return JsonResult.ok(blogService.blogDetails(id));
    }

    @PutMapping("/{id}")
    public BaseResult updateBlog(@PathVariable String id, @RequestBody Blog blog) {
        return JsonResult.ok(blogService.updateBlog(id, blog));
    }

    @DeleteMapping("/{id}")
    public BaseResult deleteBlog(@PathVariable String id) {
        blogService.deleteBlog(id);
        return OK;
    }
}
