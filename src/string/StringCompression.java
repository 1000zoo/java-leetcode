//2023-11-09
//https://leetcode.com/problems/string-compression/description/

package string;

public class StringCompression {

    public int compress(char[] chars) {
        if (chars.length == 1) return 1;
        StringBuilder sb = new StringBuilder();

        int count = 1;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                count++;
                i++;
            }
            sb.append(c);
            if (count > 1) {
                sb.append(count);
            }
            count = 1;
        }

        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }

        return sb.length();
    }
}
