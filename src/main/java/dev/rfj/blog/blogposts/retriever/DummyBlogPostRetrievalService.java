package dev.rfj.blog.blogposts.retriever;

import dev.rfj.blog.model.BlogPost;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//@ApplicationScoped inactive
public class DummyBlogPostRetrievalService implements BlogPostRetrievalService {

    @Override
    public List<BlogPost> getAvailableBlogPosts() {
        return Arrays.asList(
                BlogPost.builder()
                        .creationDate(new Date())
                        .name("Blog Post 1")
                        .description("Description 1")
                        .text("Lorem Ipsum 1")
                        .build(),
                BlogPost.builder()
                        .creationDate(new Date())
                        .name("Blog Post 2")
                        .description("Description 2")
                        .text("Lorem Ipsum 2")
                        .build()
                );
    }
}
