package dev.rfj.blog.util;

public abstract class StringUtils {

    private StringUtils() {}

    /**
     * Helper method for examining if a {@link String} is blank (contains no characters).
     * <code>null</code> evaluates <code>false</code>
     *
     * @param str
     *  The input {@link String} to be checked, may be <code>null</code>
     *
     * @return
     *  <code>true</code> if the {@link String} is <code>null</code> or contains no characters, otherwise <code>false</code>
     */
    public static boolean isBlank(String str) {
        return str == null || str.trim().length() < 1;
    }

    /**
     * Inverse method of Util#isBlank()
     *
     * @param str
     *  The input {@link String} to be validated, may be <code>null</code>
     *
     * @return
     *  <code>false</code> if the {@link String} is <code>null</code> or contains no characters, otherwise <code>false</code>
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * Trims a {@link String} completely for easier comparison, replaces
     * - Spaces (" ")
     * - Tabs ("\t")
     * - Newlines ("\n")
     * with nothing
     *
     * @param str
     *  The input {@link String}
     *
     * @return
     *  A new {@link String} that is equal to the input {@link String} without the specified characters
     */
    public static String fullTrim(String str) {
        if (isBlank(str))
            return "";

        return str
                .replaceAll("( )", "")
                .replaceAll("\\t", "")
                .replaceAll("\\n", "")
                .replaceAll("\\r", "");
    }
}
