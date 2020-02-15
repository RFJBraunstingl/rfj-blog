package dev.rfj.blog.mock;

import dev.rfj.blog.model.BlogPost;
import dev.rfj.blog.renderer.AvailableBlogPostsRenderer;
import io.quarkus.test.Mock;

import java.util.Collection;

@Mock
public class MockAvailableBlogPostRenderer implements AvailableBlogPostsRenderer {

    public static String MOCKED_HTML;

    private static final String HTML_PREFIX = "" +
            "<html>" +
            "   <head>" +
            "       <title>Welcome</title>" +
            "   </head>" +
            "   <body>";
    private static final String BLOG_POST_PREFIX = "<div>";
    private static final String NAME_FORMAT = "<h1>%s</h1>";
    private static final String DESCRIPTION_FORMAT = "<p>%s</p>";
    private static final String BLOG_POST_SUFFIX = "</div>";
    private static final String HTML_SUFFIX = "" +
            "   </body>" +
            "</html>";

    static {
        StringBuilder stringBuilder = new StringBuilder();
        Collection<BlogPost> blogPosts = MockAvailableBlogPostService.MOCKED_BLOG_POSTS;

        stringBuilder.append(HTML_PREFIX);
        for (BlogPost blogPost : blogPosts) {
            stringBuilder.append(BLOG_POST_PREFIX);
            stringBuilder.append(String.format(NAME_FORMAT, blogPost.getName()));
            stringBuilder.append(String.format(DESCRIPTION_FORMAT, blogPost.getDescription()));
            stringBuilder.append(BLOG_POST_SUFFIX);
        }
        stringBuilder.append(HTML_SUFFIX);

        MOCKED_HTML = stringBuilder.toString();
    }

    @Override
    public String renderAvailableBlogPosts() {
        return MOCKED_HTML;
    }
}
