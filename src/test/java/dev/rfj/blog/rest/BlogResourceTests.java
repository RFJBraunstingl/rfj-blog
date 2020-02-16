package dev.rfj.blog.rest;

import dev.rfj.blog.renderer.AvailableBlogPostsRenderer;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.HTML;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class BlogResourceTests {

    @Inject
    private AvailableBlogPostsRenderer availableBlogPostsRenderer;

    @Test
    public void testThatBlogResourceReturnsFormattedHtmlOfAvailableBlogPosts() {
        given()
                .when().get("/blog")
                .then().assertThat()
                    .statusCode(200)
                    .contentType(HTML)
                    .body(is(availableBlogPostsRenderer.renderAvailableBlogPosts()));
    }
}
