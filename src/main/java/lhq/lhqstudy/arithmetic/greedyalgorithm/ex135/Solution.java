package lhq.lhqstudy.arithmetic.greedyalgorithm.ex135;

import java.util.HashMap;
import java.util.Map;

/**
 * 星光荡开宇宙，本人闪耀其中
 *
 * @author LHQ
 * @data 2023/8/10
 */
public class Solution {
    public static void main(String[] args) {
        int[] ratings  = new int[]{1,0,2};
        System.out.println(candy(ratings));
        Map<Integer, Integer> map = new HashMap();
    }
    public static int candy(int[] ratings) {
        int size = ratings.length;
        if(size < 2) {
            return size;
        }
        int[] countArr = new int[size];
        countArr[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i - 1]){
                countArr[i] = countArr[i - 1] + 1;
            }else{
                countArr[i] = 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            if(ratings[i - 1] > ratings[i] && countArr[i - 1] <= countArr[i]){
                countArr[i - 1] = countArr[i] + 1;
            }
        }
        int count = 0;
        for (int i = 0; i < countArr.length; i++) {
            count += countArr[i];
        }
        return count;
    }
}
