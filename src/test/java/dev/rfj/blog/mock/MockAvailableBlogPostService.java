package dev.rfj.blog.mock;

import dev.rfj.blog.model.BlogPost;
import dev.rfj.blog.service.AvailableBlogPostService;
import io.quarkus.test.Mock;

import java.util.*;

import static java.util.Calendar.*;

@Mock
public class MockAvailableBlogPostService implements AvailableBlogPostService {

    public static final List<BlogPost> MOCKED_BLOG_POSTS = new ArrayList<>();

    static {
        MOCKED_BLOG_POSTS.add(
                BlogPost.builder()
                        .name("This is my first blog post")
                        .description("Really really the first blog post ever")
                        .text("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.")
                        .creationDate(new Date())
                        .build()
        );
        MOCKED_BLOG_POSTS.add(
                BlogPost.builder()
                        .name("This is my second blog post")
                        .description("This is an incredibly meaningful description")
                        .text("Elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.")
                        .creationDate(new GregorianCalendar(2020, FEBRUARY, 5).getTime())
                        .build()
        );
        MOCKED_BLOG_POSTS.add(
                BlogPost.builder()
                        .name("This is my third blog post")
                        .description("Really really really the first blog post ever")
                        .text("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.")
                        .creationDate(new GregorianCalendar(2019, MARCH, 3, 12, 23).getTime())
                        .build()
        );
        MOCKED_BLOG_POSTS.add(
                BlogPost.builder()
                        .name("This is my 4th blog post")
                        .description("Really really really really the first blog post ever")
                        .text("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.")
                        .creationDate(new GregorianCalendar(2018, OCTOBER, 30, 14, 59).getTime())
                        .build()
        );
    }

    @Override
    public List<BlogPost> getAvailableBlogPosts() {
        return MOCKED_BLOG_POSTS;
    }
}
