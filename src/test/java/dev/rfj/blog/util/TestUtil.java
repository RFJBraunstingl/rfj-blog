package dev.rfj.blog.util;

import java.io.IOException;

public abstract class TestUtil {

    private TestUtil() {}

    public static String getTestResourceAsString(String path) throws IOException {
        return ResourceUtils.getResourceAsStringForClassContext(path, TestUtil.class);
    }
}
