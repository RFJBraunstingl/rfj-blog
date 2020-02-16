package dev.rfj.blog.qute;

import io.quarkus.qute.Template;
import io.quarkus.qute.api.ResourcePath;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class QuteInjectonTests {

    // test one level named injection from prod resources
    @Inject
    private Template injectionTest;

    // test one level named injection from test resources
    //@Inject doesn't work
    private Template injectionTestResources;

    // test injection with named resource
    @Inject
    @ResourcePath("test/blog_overview.html")
    private Template blubb;

    @Test
    public void testNotNull() {
        assertNotNull(injectionTest);
        assertNotNull(blubb);
    }
}