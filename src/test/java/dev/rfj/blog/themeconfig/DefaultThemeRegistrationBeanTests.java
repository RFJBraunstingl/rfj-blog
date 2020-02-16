package dev.rfj.blog.themeconfig;

import dev.rfj.blog.model.Theme;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static dev.rfj.blog.themeconfig.ThemeServiceImpl.DEFAULT_THEME_NAME;

@QuarkusTest
public class DefaultThemeRegistrationBeanTests {

    @Inject
    private ThemeServiceImpl themeService;

    @Test
    public void testDefaultThemeInjection() {
        Theme theme = themeService.getThemeForName(DEFAULT_THEME_NAME);

        Assertions.assertNotNull(theme);
    }
}
