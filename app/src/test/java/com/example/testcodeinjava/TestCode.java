package com.example.testcodeinjava;

import org.junit.Test;

import java.util.Arrays;

public class TestCode {

    @Test
    public void testCode() {
        // test1
        System.out.println("test1 ::: binary_gap : " + binaryGap(8806));
        System.out.println("#test2 ::: cyclic_rotation : "
                + Arrays.toString(cyclicRotation(new int[]{1, 2, 3, 4}, 2)));
    }

    // test2: cyclic_rotation
    public int[] cyclicRotation(int[] A, int k) {
        int length = A.length;
        int temp;
        if (length == 0) {
            return A;
        }
        for (int i = 0; i < k; i++) {
            temp = A[length - 1];
            for (int j = length - 1; j > 0; j--) {
                A[j] = A[j - 1];
            }
            A[0] = temp;
        }
        return A;
    }

    // test1: Binary_Gap
    public int binaryGap(int N) {
        int count = 0;
        int maxCount = 0;
        int max = 0;
        String binaryString = Integer.toBinaryString(N);
        System.out.println("binaryString : " + binaryString);
        String[] binaryArr = binaryString.split("");
        int arrLength = binaryArr.length;

        for (int i = 0; i < arrLength; i++) {
            if ("0".equals(binaryArr[i])) {
                count++;
            } else if ("1".equals(binaryArr[i])) {
                if (max < count) {
                    max = count;
                } // max > count   max = 3, count 2
                maxCount = count;
                count = 0;
            } else {
                System.out.println("error");
            }
            max = max > maxCount ? max : maxCount;
        }

        return max;
    }
}
