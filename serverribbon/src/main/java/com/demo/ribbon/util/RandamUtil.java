package com.demo.ribbon.util;

/**
 * RandamUtil
 *
 * @author qindaorong
 * @create 2018-03-16 11:48 AM
 **/
public class RandamUtil {
    
    
    /**
     * 获得范围大小内的随机数
     * @param min
     * @param max
     * @param n
     * @return
     */
    public static int[] randomCommon(int min, int max, int n) {
        if (n > (max - min + 1) || max < min) {
            return null;
        }
        int[] result = new int[n];
        int count = 0;
        while (count < n) {
            int num = (int) (Math.random() * (max - min)) + min;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (num == result[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result[count] = num;
                count++;
            }
        }
        return result;
    }
}
