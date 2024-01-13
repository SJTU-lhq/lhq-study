package com.lhq.leet.ex452;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author lihaiquan (lihq@rd.netease.com)
 * @description:
 * @date 2023/8/9 18:07
 */
public class Solution {
        public static void main(String[] args) {
            int[][] points = new int[2][2];
            points[0][0] = -2147483646;
            points[0][1] = -2147483645;
            points[1][0] = 2147483646;
            points[1][1] = 2147483647;
            findMinArrowShots(points);

        }
            public static int findMinArrowShots(int[][] points) {
                Arrays.sort(points, new Comparator<int[]>() {

                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if(o1[0]<o2[0]){
                            return -1;
                        }
                        if(o1[0]>o2[0]){
                            return 1;
                        }

                        return 0;
                    }
                });
                List<Integer> area = new ArrayList<>();
                area.add(points[0][0]);
                area.add(points[0][1]);
                for(int i=1;i<points.length;i++){
                    int length = area.size();
                    if(points[i][1]<=area.get(length-1)){
                        area.remove(length-1);
                        area.remove(length-2);
                        area.add(points[i][0]);
                        area.add(points[i][1]);
                    }else{
                        if(points[i][0]<=area.get(length-1)){
                            area.add(length-1, points[i][0]);
                            area.remove(length-2);
                        }else{
                            System.out.println(11);
                            area.add(points[i][0]);
                            area.add(points[i][1]);
                        }
                    }
                }
                System.out.println(area.size()/2);
                return area.size()/2;
            }
}
