package dev.rfj.blog.blogposts;

import dev.rfj.blog.model.BlogPost;

import java.util.List;

public interface AvailableBlogPostService {

    List<BlogPost> getAvailableBlogPosts();
}
