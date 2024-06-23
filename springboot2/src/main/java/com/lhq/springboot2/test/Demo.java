package com.lhq.springboot2.test;

import java.util.concurrent.Semaphore;

/**
 * @author lihaiquan (lihq@rd.netease.com)
 * @description:
 * @date 2023/11/14 23:34
 */
public class Demo {
    public static int[] quickSort(int[] array, int start, int end){
        if(array.length < 1 || start < 0 || end > array.length || start > end){
            return null;
        }
        int index = handle(array, start, end);
        if(index > start){
            quickSort(array, start, index -1);
        }else {
            quickSort(array, index + 1, end);
        }
        return array;
    }

    public static int handle(int[] array, int start, int end){
        int tmp = (int) Math.random() * (end -start + 1) + start;
        int index = start - 1;
        swap(array, tmp, end);
        for (int i = start; i <= end; i++) {
            if(array[i] <= array[end]){
                index++;
                if(i > index){
                    swap(array, i, index);
                }
            }
        }
        return index;
    }

    public static void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8,9,5,2,5,4,0};
        int[] ints = quickSort(arr, 0, 6);

        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
