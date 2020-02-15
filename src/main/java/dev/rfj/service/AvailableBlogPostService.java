package dev.rfj.service;

import dev.rfj.model.BlogPost;

import java.util.List;

public interface AvailableBlogPostService {

    List<BlogPost> getAvailableBlogPosts();
}
