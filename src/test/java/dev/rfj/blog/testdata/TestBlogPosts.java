package dev.rfj.blog.testdata;

import dev.rfj.blog.model.BlogPost;
import dev.rfj.blog.util.TestUtil;

import java.io.IOException;
import java.util.*;

import static java.util.Arrays.asList;
import static java.util.Calendar.*;

/**
 * Java representation of the blog posts stored as files in
 * <code>{PROJECT_ROOT}/pages/blog-posts/</code>
 */
public class TestBlogPosts {

    public static final List<BlogPost> FILE_SYSTEM_BLOG_POSTS = new ArrayList<>();
    public static final List<BlogPost> SIMPLE_REDUCED_BLOG_POSTS = new ArrayList<>();

    static {
        initFileSystemBlogPosts();
        initSimpleBlogPosts();
    }

    private static void initFileSystemBlogPosts() {
        FILE_SYSTEM_BLOG_POSTS.add(
                BlogPost.builder()
                        .name("test-blog-post-one")
                        .description("It works!!")
                        .text("<p>It works!!</p>\n")
                        .creationDate(new Date())
                        .build()
        );
        FILE_SYSTEM_BLOG_POSTS.add(
                BlogPost.builder()
                        .name("test-blog-post-two")
                        .description("Hello world!")
                        .text("<p>Hello world!</p>\n")
                        .creationDate(new GregorianCalendar(2020, FEBRUARY, 5).getTime())
                        .build()
        );
        FILE_SYSTEM_BLOG_POSTS.add(
                BlogPost.builder()
                        .name("This is my third blog post")
                        .description("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.")
                        .text("<p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.</p>\n")
                        .creationDate(new GregorianCalendar(2019, MARCH, 3, 12, 23).getTime())
                        .build()
        );
        FILE_SYSTEM_BLOG_POSTS.add(
                BlogPost.builder()
                        .name("This is my 4th blog post")
                        .description("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.")
                        .text("<p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.</p>\n")
                        .creationDate(new GregorianCalendar(2018, OCTOBER, 30, 14, 59).getTime())
                        .build()
        );
        try {
            FILE_SYSTEM_BLOG_POSTS.add(
                    BlogPost.builder()
                            .name("markdown-syntax-reference")
                            .text(TestUtil.getTestResourceAsString("data/markdown-spec.html"))
                            .build()
            );
        } catch (IOException e) {
            // tests will fail righteously
        }
    }

    private static void initSimpleBlogPosts() {
        SIMPLE_REDUCED_BLOG_POSTS.addAll(
                asList(
                        BlogPost.builder()
                                .name("This is my first blog post")
                                .description("Really really the first blog post ever")
                                .build(),
                        BlogPost.builder()
                                .name("This is my second blog post")
                                .description("This is an incredibly meaningful description")
                                .build(),
                        BlogPost.builder()
                                .name("This is my third blog post")
                                .description("Really really really the first blog post ever")
                                .build()
                )
        );
    }
}
