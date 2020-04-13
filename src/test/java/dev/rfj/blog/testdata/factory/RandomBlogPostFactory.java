package dev.rfj.blog.testdata.factory;

import dev.rfj.blog.model.BlogPost;

import java.time.LocalDateTime;

import static dev.rfj.blog.testdata.util.RandomUtil.*;

public class RandomBlogPostFactory {

    public static BlogPost.BlogPostBuilder create() {
        return BlogPost.builder()
                .name(randomName())
                .description(randomDescription())
                .text(randomText())
                .creationDate(randomCreationDate());
    }

    private static String randomName() {
        return randomString();
    }

    private static String randomDescription() {
        return randomStringWithLengthBetween(200, 500);
    }

    private static String randomText() {
        return randomStringWithLengthBetween(1000, 10000);
    }

    private static LocalDateTime randomCreationDate() {
        return randomDateInPast();
    }
}
