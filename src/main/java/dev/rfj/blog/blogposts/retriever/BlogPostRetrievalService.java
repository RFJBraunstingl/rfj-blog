package dev.rfj.blog.blogposts.retriever;

import dev.rfj.blog.model.BlogPost;

import java.util.List;

public interface BlogPostRetrievalService {

    List<BlogPost> getAvailableBlogPosts();
}
