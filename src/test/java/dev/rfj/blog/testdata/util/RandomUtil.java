package dev.rfj.blog.testdata.util;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static dev.rfj.blog.util.CollectionUtils.isEmpty;

public class RandomUtil {

    private static final Random RANDOM = ThreadLocalRandom.current();
    private static final int DEFAULT_STRING_LENGTH = 10;
    private static final int MAX_DAYS_IN_PAST = 365 * 3; // 3 years

    public static <T> T randomElementOfList(List<T> collection) {
        if (isEmpty(collection))
            return null;

        return collection.get(RANDOM.nextInt(collection.size()));
    }

    public static String randomString() {
        return randomStringWithLength(DEFAULT_STRING_LENGTH);
    }

    public static String randomStringWithLengthBetween(int min, int max) {
        if (min < 1)
            return "";

        if (max < min)
            return randomStringWithLength(min);

        int randomLength = min + RANDOM.nextInt(max - min);
        return randomStringWithLength(randomLength);
    }

    public static String randomStringWithLength(int len) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++)
            stringBuilder.append(RANDOM.nextBoolean() ? randomUppercaseCharacter() : randomLowercaseCharacter());

        return stringBuilder.toString();
    }

    private static char randomUppercaseCharacter() {
        return (char) ('A' + RANDOM.nextInt('Z' - 'A'));
    }

    private static char randomLowercaseCharacter() {
        return (char) ('a' + RANDOM.nextInt('z' - 'a'));
    }

    public static LocalDateTime randomDateInPast() {
        int numOfDaysInPast = RANDOM.nextInt(MAX_DAYS_IN_PAST);
        return LocalDateTime.now().minusDays(numOfDaysInPast);
    }
}
