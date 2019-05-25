package com.codersongs.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。

 示例 1:

 输入: [[0, 30],[5, 10],[15, 20]]
 输出: 2

 示例 2:

 输入: [[7,10],[2,4]]
 输出: 1


 * @author wusongsong
 * @date 2019/5/22
 */
public class MinMeetingRooms {
    public static void main(String[] args) {
        System.out.println(minMeetingRooms2(new int[][]{{2,15},{36,45},{9,29},{16,23},{4,9}}));
    }

    /**
     * 贪心算法，最多安排的活动场次，选择最早结束的会议
     * @param intervals
     * @return
     */
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0){
            return 0;
        }
        if (intervals.length == 1){
            return 1;
        }
        int count = 0;
        int limit = 0;
        while (count < intervals.length){
            int index = 0;
            int end = Integer.MAX_VALUE;
            for (int i = 0; i < intervals.length; i++) {
                if (intervals[i] == null){
                    continue;
                }
                //开始时间早于最低界限，结束时间最早的活动
                if (intervals[i][0] >= limit && intervals[i][1] < end){
                    index = i;
                    end = intervals[i][1];
                }
            }
            //更新最低界限
            if (end == Integer.MAX_VALUE){
                return count;
            }
            limit = intervals[index][1];
            intervals[index] = null;
            count ++;
        }

        return count;
    }

    /**
     * 最少需要的会议室数量，选择最早开始的活动
     * @param intervals
     * @return
     */
    public static int minMeetingRooms2(int[][] intervals) {
        if (intervals == null || intervals.length == 0){
            return 0;
        }
        if (intervals.length == 1){
            return 1;
        }
        int sum = 1;
        int count = 0;
        int limit = 0;
        while (count < intervals.length){
            int index = 0;
            int start = Integer.MAX_VALUE;
            for (int i = 0; i < intervals.length; i++) {
                if (intervals[i] == null){
                    continue;
                }
                //开始时间早于最低界限，结束时间最早的活动
                if (intervals[i][0] >= limit && intervals[i][0] < start){
                    index = i;
                    start = intervals[i][0];
                }
            }
            //更新最低界限
            if (start == Integer.MAX_VALUE){
                sum ++;
                limit = 0;
                continue;
            }
            limit = intervals[index][1];
            intervals[index] = null;
            count ++;
        }

        return sum;
    }
}
