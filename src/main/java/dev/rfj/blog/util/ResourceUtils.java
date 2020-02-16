package dev.rfj.blog.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import static dev.rfj.blog.util.StreamUtils.readStream;

public abstract class ResourceUtils {

    private ResourceUtils() {}

    public static String getResourceAsString(String path) throws IOException {
        return getResourceAsStringForClassContext(path, ResourceUtils.class);
    }

    public static String getResourceAsStringForClassContext(String path, Class<?> clazz) throws IOException {
        ClassLoader classLoader = clazz.getClassLoader();
        URL resource = classLoader.getResource(path);
        assert resource != null;
        File file = new File(resource.getFile());
        return readStream(new FileInputStream(file));
    }
}
