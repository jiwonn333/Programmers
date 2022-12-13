package com.example.testcodeinjava;

import org.junit.Test;

import java.util.Arrays;

public class TestCode {
    @Test
    public void testCode() {
        System.out.println("#test1 ::: binary_gap : " + binaryGap(8806));
        System.out.println("#test2 ::: cyclic_rotation : "
                + Arrays.toString(cyclicRotation(new int[]{1, 2, 3, 4}, 2)));
        System.out.println("#test3 ::: oddOccurrencesInArray : "
                + oddOccurrencesInArray(new int[]{9, 3, 9, 3, 9, 7, 9}));
        System.out.println("#test4 ::: frogJump : " + frogJump(10, 85, 30));
        System.out.println("#test5 ::: permMissingElem : " + permMissingElem(new int[]{2, 3, 1, 5}));
        System.out.println("#test6 :::. 기사단원 무기 : " + orderWeapon(10, 3, 2));

    }

    //test6: orderWeapon
    public int orderWeapon(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int result = getCount(i);
            if (result > limit) {
                answer += power;
            } else {
                answer += result;
            }
        }
        return answer;
    }
    private int getCount(int number) {
        int count = 0;
        for (int i = 1; i * i <= number; i++) {
            if (number % i == 0) {
                count++;
                if (i * i < number) {
                    count++;
                }
            }
        }
        return count;
    }


    // test5: permMissingElem
    public int permMissingElem(int[] A) {
        Arrays.sort(A);
        System.out.println("정렬 : " + Arrays.toString(A)); // 정렬되었는지 확인

        int missingElem = 0;

        for (int i = A.length - 1; i > 0; i--) {
            if (A[i] - 1 != A[i - 1]) {
                missingElem = A[i] - 1;
                System.out.println("A[i] - 1 : " + (A[i] - 1));
            }
        }

        return missingElem;
    }

    // test4: frogJump
    public int frogJump(int X, int Y, int D) {
        int destination = Y - X;
        int jumps = destination % D > 0 ? destination / D + 1 : destination / D;
        return jumps;
    }

    // test3: oddOccurrencesInArray
    public int oddOccurrencesInArray(int[] A) {
        // 비트연산활용
        int single = 0;
        for (int i = 0; i < A.length; i++) {
            single = single ^ A[i];
        }
        return single;
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
