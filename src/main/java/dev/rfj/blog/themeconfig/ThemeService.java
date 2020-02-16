package dev.rfj.blog.themeconfig;

import dev.rfj.blog.model.Theme;
import io.quarkus.qute.Template;

public interface ThemeService {

    Theme getActiveTheme();
}
