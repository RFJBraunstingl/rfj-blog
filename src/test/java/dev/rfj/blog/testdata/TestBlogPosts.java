package dev.rfj.blog.testdata;

import dev.rfj.blog.model.BlogPost;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static java.util.Calendar.*;

/**
 * Java representation of the blog posts stored as files in
 * <code>{PROJECT_ROOT}/pages/blog-posts/</code>
 */
public class TestBlogPosts {

    public static final List<BlogPost> MOCKED_BLOG_POSTS = new ArrayList<>();

    static {
        MOCKED_BLOG_POSTS.add(
                BlogPost.builder()
                        .name("test-blog-post-one")
                        .description("It works!!")
                        .text("It works!!")
                        .creationDate(new Date())
                        .build()
        );
        MOCKED_BLOG_POSTS.add(
                BlogPost.builder()
                        .name("test-blog-post-two")
                        .description("Hello world!")
                        .text("Hello world!")
                        .creationDate(new GregorianCalendar(2020, FEBRUARY, 5).getTime())
                        .build()
        );
        MOCKED_BLOG_POSTS.add(
                BlogPost.builder()
                        .name("This is my third blog post")
                        .description("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.")
                        .text("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.")
                        .creationDate(new GregorianCalendar(2019, MARCH, 3, 12, 23).getTime())
                        .build()
        );
        MOCKED_BLOG_POSTS.add(
                BlogPost.builder()
                        .name("This is my 4th blog post")
                        .description("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.")
                        .text("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.")
                        .creationDate(new GregorianCalendar(2018, OCTOBER, 30, 14, 59).getTime())
                        .build()
        );
    }
}
