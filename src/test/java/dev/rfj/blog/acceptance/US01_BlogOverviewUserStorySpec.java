package dev.rfj.blog.acceptance;

import dev.rfj.blog.mock.MockAvailableBlogPostService;
import dev.rfj.blog.model.BlogPost;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

/*
 * As a user, I want to be presented with a list of available blog posts rendered as html when going to the site
 */
@QuarkusTest
public class US01_BlogOverviewUserStorySpec {

    /*
     * As a user, I want to be presented with a list of available blog posts rendered as HTML when visiting the site
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

        /* TODO: re-write this using streaming API */
        for (BlogPost blogPost : MockAvailableBlogPostService.MOCKED_BLOG_POSTS) {
            bodyMatcher.body(containsString(blogPost.getName()));
            bodyMatcher.body(containsString(blogPost.getDescription()));
        }
    }
}
