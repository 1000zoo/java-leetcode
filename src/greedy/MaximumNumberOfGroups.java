//2023-11-21
//https://leetcode.com/problems/maximum-number-of-groups-entering-a-competition/

package greedy;

public class MaximumNumberOfGroups {

    //Runtime 0 ms Beats 100.00%
    public int maximumGroups(int[] grades) {
        int groupCount = 0;
        int totalGrade = 0;

        while (totalGrade + groupCount < grades.length) {
            groupCount++;
            totalGrade += groupCount;
        }

        return groupCount;
    }
}

