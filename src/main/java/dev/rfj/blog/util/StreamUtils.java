package dev.rfj.blog.util;

import java.io.*;
import java.nio.charset.StandardCharsets;

public abstract class StreamUtils {

    private StreamUtils() {}

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
