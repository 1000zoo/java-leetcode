//https://leetcode.com/problems/first-unique-character-in-a-string/
//2022-10-19

package queue;

import java.util.*;

public class FirstUniqueCharacterInString {

    //solution1
    //string 의 indexOf 메소드를 이용한 풀이
    //Runtime: 16 ms, faster than 71.68% of Java online submissions for First Unique Character in a String.
    //Memory Usage: 49.3 MB, less than 53.48% of Java online submissions for First Unique Character in a String.
    public int solution1(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                continue;
            } else {
                set.add(s.charAt(i));
            }
            if (s.indexOf(s.charAt(i), i + 1) == -1) {
                return i;
            }
        }
        return -1;
    }

    //solution2
    //HashMap 을 사용한 풀이
    //Runtime: 73 ms, faster than 20.73% of Java online submissions for First Unique Character in a String.
    //Memory Usage: 54.2 MB, less than 30.17% of Java online submissions for First Unique Character in a String.
    public int solution2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(map.get(c) + 1, 1));
        }
        for (char c : s.toCharArray()) {
            if (map.get(c) == 1) {
                return s.indexOf(map.get(c));
            }
        }
        return -1;
    }

    //solution3
    //char array 를 사용한 풀이
    //Runtime: 6 ms, faster than 93.53% of Java online submissions for First Unique Character in a String.
    //Memory Usage: 42.7 MB, less than 90.83% of Java online submissions for First Unique Character in a String.
    public int solution3(String s) {
        char[] count = new char[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            if (count[c - 'a'] == 1) return s.indexOf(c);
        }
        return -1;
    }
}
