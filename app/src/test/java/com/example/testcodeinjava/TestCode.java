package com.example.testcodeinjava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

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
        System.out.println("#test6 ::: 기사단원 무기 : " + orderWeapon(10, 3, 2));
        System.out.println("#test7 ::: 과일장수 : " + fruitSeller(3, 4, new int[]{1, 2, 3, 1, 2, 3, 1, 1}));
        System.out.println("#test8 ::: 모의고사 : " + Arrays.toString(exam(new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1})));
        System.out.println("#test9 ::: 소수 찾기 : " + findPrimeNumber("17"));
        System.out.println("#test10 ::: 다음에 올 숫자 : " + nextNumber(new int[]{1, 2, 3, 4}) + ", " + nextNumber(new int[]{2, 4, 8}));
    }

    // test10. 다음에 올 숫자
    public int nextNumber(int[] common) {
        int answer = 0;
        int length = common.length;

        if ((common[1] - common[0]) == (common[2] - common[1])) {
            answer = common[length - 1] + (common[1] - common[0]);
        } else {
            answer = common[length - 1] * (common[1] / common[0]);
        }
        return answer;
    }

    // 8번 틀림
    public int nextNumber1(int[] common) {
        int length = common.length;
        int seq = 0;

        int a = Math.abs(common[length - 1]);
        int b = Math.abs(common[length - 2]);
        int c = Math.abs(common[length - 3]);
        if (Math.abs(a - b) == Math.abs(b - c)) {
            seq = Math.abs(a - b);
            return common[length - 1] + seq;
        } else {
            seq = Math.abs(a / b);
            if (common[length - 1] < 0) {
                return common[length - 1] / seq;
            } else {
                return common[length - 1] * seq;
            }
        }
    }


    // test9 소수 찾기
    public int findPrimeNumber(String numbers) {
        int answer = 0;
        int count = 0;

        // set에 모든 수를 넣기 위한 정의
        HashSet<Integer> set = new HashSet<>();

        permutation("", numbers, set);

        //iterator : 저장되어잇는 요소를 읽어오는 방법 ,
        while (set.iterator().hasNext()) { // 다음 읽어올 요소가 있으면 true, 없으면 false
            int ele = set.iterator().next(); // 다음요소를 가져온다.
            set.remove(ele);
            if (ele == 2) {
                count++;
            }
            if (ele % 2 != 0 && isPrime(ele)) {
                count++;
            }
        }
        return count;
    }

    public boolean isPrime(int ele) {
        // 소수가 맞는지 확인
        if (ele == 0 || ele == 1) {
            return false;
        }
        for (int i = 3; i <= (int) Math.sqrt(ele); i += 2) {
            if (ele % i == 0) {
                return false;
            }
        }
        return true;
    }

    //순열 (재귀함수 사용)
    public void permutation(String prefix, String numbers, HashSet<Integer> set) {
        int length = numbers.length();

        for (int i = 0; i < numbers.length(); i++) {
            permutation(prefix + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i + 1, length), set);
        }
        if (!prefix.equals("")) {
            set.add(Integer.valueOf(prefix));
        }
        for (int i = 0; i < length; i++) {
            permutation(prefix + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i + 1, length), set);
        }

    }

    // test8 : 모의고사
    public int[] exam(int[] answers) {
        int[] answer = {};
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int answer1 = 0;
        int answer2 = 0;
        int answer3 = 0;
        // 몫 , 나머지
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == person1[i % person1.length]) answer1++;
            if (answers[i] == person2[i % person2.length]) answer2++;
            if (answers[i] == person3[i % person3.length]) answer3++;
        }
        int max = Math.max(Math.max(answer1, answer2), answer3);

        ArrayList<Integer> list = new ArrayList<Integer>();
        if (max == answer1) list.add(1);
        if (max == answer2) list.add(2);
        if (max == answer3) list.add(3);

//        answer = new int[list.size()];
//        for (int i = 0; i < answers.length; i++) {
//            answer[i] = list.get(i);
//        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    // test7 : fruitSeller
    public int fruitSeller(int k, int m, int[] score) {
        int answer = 0;
        int boxCnt = score.length / m; // 2
        int totalCnt = boxCnt * m; // 8
        int idx = score.length - totalCnt; // 8-4 = 4

        Arrays.sort(score); // 1,1,1,2,2,3,3
        while (idx < totalCnt) { // 3 < 4
            answer += score[idx] * m; // 0 = 0+score(3)
            idx += m;
        }

        return answer;
    }

//    public int fruitSeller(int k, int m, int[] score) {
//        int answer = 0;
//        int apple = score.length;
//        int checkedAppleCount = apple;
//        int box = apple / m;
//        if (box == 0) {
//            return 0;
//        }
//        // 오름차순
//        Arrays.sort(score); //1,1,1,2,2,3,3
//        // 내림차순
////        List<Integer> arrayList = Arrays.stream(score).boxed().collect(Collectors.toList());
////        Collections.sort(arrayList, Collections.reverseOrder());
//        // 3,3,2,2,1,1,1
//        for (int i = 0; i < box; i++) {
//            int[] profitArr = getScore(m, score, checkedAppleCount);
//            System.out.println("profitArr : " + Arrays.toString(profitArr));
//            int profit = profitArr[m - 1]; //2
//            answer += profit * m;
//        }
//        return answer;
//    }
//
//    public int[] getScore(int m, int[] arrayList, int checkedAppleCount) {
//        int[] profitArr = new int[m];
//        System.out.println("arrayList : " + Arrays.toString(arrayList));
//        for (int i = 0; i < m; i++) {
//            profitArr[i] = arrayList[checkedAppleCount - 1];
//            System.out.println("profitArr[" + i + "]" + " : " + profitArr[i]);
//            checkedAppleCount--;
//        }
//        return profitArr;
//    }

    // test6: orderWeapon
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
