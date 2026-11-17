public class DSAar {
    static int[] buildLps(String pattern) {
        int[] lps = new int[pattern.length()];
        int matched = 0;
        int index = 1;

        while (index < pattern.length()) {
            if (pattern.charAt(index) == pattern.charAt(matched)) {
                matched++;
                lps[index] = matched;
                index++;
            } else if (matched > 0) {
                matched = lps[matched - 1];
            } else {
                index++;
            }
        }

        return lps;
    }

    static int findPattern(String text, String pattern) {
        if (pattern.isEmpty()) {
            return 0;
        }

        int[] lps = buildLps(pattern);
        int matched = 0;
        int index = 0;

        while (index < text.length()) {
            if (text.charAt(index) == pattern.charAt(matched)) {
                index++;
                matched++;

                if (matched == pattern.length()) {
                    return index - matched;
                }
            } else if (matched > 0) {
                matched = lps[matched - 1];
            } else {
                index++;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String text = "ababcabcabababd";
        String pattern = "ababd";

        System.out.println(findPattern(text, pattern));
    }
}