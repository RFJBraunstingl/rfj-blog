package dev.rfj.blog.util;

import java.util.Collection;

public abstract class CollectionUtils {

    private CollectionUtils() {}

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
}
