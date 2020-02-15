package dev.rfj.rest;

import dev.rfj.mock.MockAvailableBlogPostRenderer;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.HTML;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class BlogResourceTests {

    @Test
    public void testThatBlogResourceReturnsFormattedHtmlOfAvailableBlogPosts() {
        given()
                .when().get("/blog")
                .then().assertThat()
                    .statusCode(200)
                    .contentType(HTML)
                    .body(is(MockAvailableBlogPostRenderer.MOCKED_HTML));
    }
}
