package dev.rfj.blog.service.blogpost;

import dev.rfj.blog.model.BlogPost;

import java.util.List;

public interface AvailableBlogPostService {

    List<BlogPost> getAvailableBlogPosts();
}
