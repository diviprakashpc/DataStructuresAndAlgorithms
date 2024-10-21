package IntervalsQuestions;

import java.util.*;

//2406. Divide Intervals Into Minimum Number of Groups
//Solved
//Medium
//Topics
//Companies
//Hint
//You are given a 2D integer array intervals where intervals[i] = [lefti, righti] represents the inclusive interval [lefti, righti].
//
//You have to divide the intervals into one or more groups such that each interval is in exactly one group, and no two intervals that are in the same group intersect each other.
//
//Return the minimum number of groups you need to make.
//
//Two intervals intersect if there is at least one common number between them. For example, the intervals [1, 5] and [5, 8] intersect.
//
//

//Example 1:
//
//Input: intervals = [[5,10],[6,8],[1,5],[2,3],[1,10]]
//Output: 3
//Explanation: We can divide the intervals into the following groups:
//- Group 1: [1, 5], [6, 8].
//- Group 2: [2, 3], [5, 10].
//- Group 3: [1, 10].
//It can be proven that it is not possible to divide the intervals into fewer than 3 groups.
//Example 2:
//
//Input: intervals = [[1,3],[5,6],[8,10],[11,13]]
//Output: 1
//Explanation: None of the intervals overlap, so we can put all of them in one group.
// 
//
//Constraints:
//
//1 <= intervals.length <= 105
//intervals[i].length == 2
//1 <= lefti <= righti <= 106


//EXPLANATION

//Step-by-Step Detailed Explanation
//Sorting the Intervals:
//
//First, we sort the intervals by their start times. This allows us to process them in order and ensures that we always consider earlier intervals first.
//Using a Priority Queue:
//
//The min-heap (or priority queue) helps us track the end times of the currently active intervals. The heap ensures that the interval with the earliest end time is always accessible at the top.
//Checking Overlaps:
//
//For each interval, if its start time is greater than the smallest end time (top of the heap), we know that this interval doesn't overlap with the earliest ending interval, and we can reuse that group. We remove the earliest end time from the heap.
//Otherwise, if there's an overlap, we need to create a new group for this interval. We add its end time to the heap.
//Final Count of Groups:
//
//After processing all intervals, the number of active intervals (i.e., the size of the heap) gives us the number of groups required, as each interval in the heap represents an active group.

public class DivideIntervalsIntoMinimumNumberofGroups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int minGroups(int[][] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        for(int[] interval : intervals){
            int st = interval[0];
            int et = interval[1];
            if(pq.size() != 0 && st > pq.peek()){
                pq.remove();
            }
            pq.add(et);
        }

        return pq.size();
    }

}