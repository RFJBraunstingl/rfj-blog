package dev.rfj.blog.util;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class TestUtil {

    public static String getTestResourceAsString(String path) throws IOException {
        ClassLoader classLoader = TestUtil.class.getClassLoader();
        File file = new File(classLoader.getResource(path).getFile());
        return readStream(new FileInputStream(file));
    }

    public static String readStream(InputStream in) throws IOException {
        byte[] data = new byte[1024];
        int r;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        while ((r = in.read(data)) > 0) {
            out.write(data, 0, r);
        }
        return new String(out.toByteArray(), StandardCharsets.UTF_8);
    }
}
