package dev.rfj.blog.service;

import dev.rfj.blog.model.BlogPost;

import java.util.List;

public interface AvailableBlogPostService {

    List<BlogPost> getAvailableBlogPosts();
}
