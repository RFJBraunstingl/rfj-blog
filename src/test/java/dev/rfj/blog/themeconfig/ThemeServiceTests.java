package dev.rfj.blog.themeconfig;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class ThemeServiceTests {

    @Inject
    private ThemeService themeService;

    @Test
    public void testThatThemeConfigServiceReturnsValidObjects() {
        assertNotNull(themeService.getActiveTheme());
    }
}
