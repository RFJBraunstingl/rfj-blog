package dev.rfj.blog.acceptance;

import dev.rfj.blog.testdata.TestBlogPosts;
import dev.rfj.blog.model.BlogPost;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static dev.rfj.blog.util.StringUtils.isNotBlank;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

/*
 * As a user, I want to be presented with a list of available blog posts rendered as html when going to the site
 */
@QuarkusTest
public class US01_BlogOverviewUserStorySpec {

    /*
     * a blog entry consists of
     * - name
     * - description
     * - text
     * - created date
     *
     * and we want to see at least
     * - name
     * - description
     * in the HTML representation
     */
    @Test
    public void testBlogEntryPoint() {
        ValidatableResponse bodyMatcher = given()
                .when().get("/blog")
                .then().assertThat()
                .statusCode(200)
                .contentType(ContentType.HTML);

        TestBlogPosts.FILE_SYSTEM_BLOG_POSTS.forEach(
                blogPost -> {
                    bodyMatcher.body(containsString(blogPost.getName()));

                    String description = blogPost.getDescription();
                    if (isNotBlank(description))
                        bodyMatcher.body(containsString(description));
                }
        );
    }
}
