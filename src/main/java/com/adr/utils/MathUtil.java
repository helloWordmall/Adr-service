package com.adr.utils;

import java.util.*;

public class MathUtil {

    public static void main(String[] args){
        int[] test = RandomMath(0,10,10);
        Arrays.sort(test);
        for(int i:test){
            System.out.println(i);
        }
    }

    public static int[] RandomMath(int min,int max,int n){
        Set<Integer> source= new LinkedHashSet<Integer>();
        int[] result = new int[n];
        Random rand = new Random();
        int i =0 , temp= 0;
        while(source.size() < n){
            /**
             * nextInt()作用是生成一个随机的int值，该值介于[0,n)的区间
             */
            temp = rand.nextInt(max)+min;
            if(source.add(temp)){
                result[i++] = temp;
            }
        }
        return result;
    }
}
