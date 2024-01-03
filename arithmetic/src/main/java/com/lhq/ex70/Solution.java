package com.lhq.ex70;

import java.util.Scanner;

/**
 * @author lihaiquan (lihq@rd.netease.com)
 * @description:
 * @date 2023/8/19 00:01
 */
public class Solution {
/*    public int climbStairs(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 1; i < n; i++) {
            int temp = first + second;
            first = second;
            second = temp;
        }
        return first;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        char[][] road = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
            }
        }
    }*/
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        int a=1,b=2;
        int c=a+b;
        for (int i = 2; i < n; i++) {
            c = a+b;
            a=b;
            b=c;
        }
        return c;
    }
}
