//https://leetcode.com/problems/count-sorted-vowel-strings/
//2022-10-19

package dynamic_programming;

public class CountSortedVowelStrings {

    //solution1
    //Runtime: 1 ms, faster than 55.40% of Java online submissions for Count Sorted Vowel Strings.
    //Memory Usage: 41.4 MB, less than 13.57% of Java online submissions for Count Sorted Vowel Strings.
    public int solution1(int n) {
        int[] vowelCount = new int[] {1, 1, 1, 1, 1};
        int temp = sumArray(vowelCount);
        for (int i = 1; i < n; i++) {
            int[] newCount = new int[5];
            newCount[0] = temp;
            for (int j = 1; j < 5; j++) {
                newCount[j] = newCount[j - 1] - vowelCount[j];
            }
            vowelCount = newCount;
            temp = sumArray(vowelCount);
        }
        return temp;
    }

    private int sumArray(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    //ㅋㅋㅋ
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Sorted Vowel Strings.
    //Memory Usage: 40.6 MB, less than 71.74% of Java online submissions for Count Sorted Vowel Strings.
    public int ㅋㅋㅋ(int n) {
        int[] ㅋ = new int[]{
                    0,
                    5,
                    15,
                    35,
                    70,
                    126,
                    210,
                    330,
                    495,
                    715,
                    1001,
                    1365,
                    1820,
                    2380,
                    3060,
                    3876,
                    4845,
                    5985,
                    7315,
                    8855,
                    10626,
                    12650,
                    14950,
                    17550,
                    20475,
                    23751,
                    27405,
                    31465,
                    35960,
                    40920,
                    46376,
                    52360,
                    58905,
                    66045,
                    73815,
                    82251,
                    91390,
                    101270,
                    111930,
                    123410,
                    135751,
                    148995,
                    163185,
                    178365,
                    194580,
                    211876,
                    230300,
                    249900,
                    270725,
                    292825,
                    316251
        };
        return ㅋ[n];
    }

}
