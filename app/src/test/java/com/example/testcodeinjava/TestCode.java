package com.example.testcodeinjava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

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
        System.out.println("#test11 ::: 분수의 덧셈 : " + Arrays.toString(additionOfFractions(1, 2, 3, 4)));
        System.out.println("#test12 ::: 겹치는 선분의 길이 : " + pathsOfOverlapping(new int[][]{{0, 1}, {2, 5}, {3, 9}}));
        System.out.println("#test13 ::: 음양 더하기 : " + nepoPlus(new int[]{4, 7, 12}, new boolean[]{true, false, true}));
        System.out.println("#test14 ::: 약수 더하기 : " + addDivisors(13, 17));
        System.out.println("#test15 ::: 괄호 회전하기 : " + bracketRotation("[](){}"));
        System.out.println("#test16 ::: 2개 이하로 다른 비트 : " + Arrays.toString(differentBits(new long[]{2, 7})));
        System.out.println("#test17 ::: 전화번호 목록 :" + phoneNumberList(new String[]{"119", "97674223", "1195524421"}));
        System.out.println("#test18 ::: 숫자 문자열과 영단어 :" + NumberAndEnglishWords("one4seveneight"));
        System.out.println("#test19 ::: 피로도 :" + fatigue(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));

    }

    public int fatigueAnswer = 0;
    public boolean[] fatigueVisit;

    public int fatigue(int k, int[][] dungeons) {
        fatigueVisit = new boolean[dungeons.length];

        fatigueDfs(0, k, dungeons);
        return fatigueAnswer;
    }

    public void fatigueDfs(int depth, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            System.out.println("depth : " + depth);
            if (!fatigueVisit[i] && dungeons[i][0] <= k) {
                fatigueVisit[i] = true;
                System.out.println("1. i : " + i);
                System.out.println("1. visit" + Arrays.toString(fatigueVisit));


                fatigueDfs(depth + 1, k - dungeons[i][1], dungeons);
                fatigueVisit[i] = false;
                System.out.println("2. i : " + i);
                System.out.println("2. visit" + Arrays.toString(fatigueVisit));

            }
            System.out.println("3. i : " + i);
            System.out.println("3. visit" + Arrays.toString(fatigueVisit));
        }
        fatigueAnswer = Math.max(fatigueAnswer, depth);
        System.out.println("answer : " + fatigueAnswer + " / depth : " + depth);

    }

    private int NumberAndEnglishWords(String s) {
        int answer = 0;
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < 10; i++) {
            System.out.println("num[" + i + "] : " + num[i]);
            s = s.replace(num[i], Integer.toString(i));
            System.out.println("s : " + s);
        }
        answer = Integer.parseInt(s);
        return answer;
    }


    public boolean phoneNumberList(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return answer;
    }

    public long[] differentBits(long[] numbers) {
        long[] answer = new long[numbers.length];

        System.out.println("numbers long형 : " + numbers[0]);

        for (int i = 0; i < numbers.length; i++) {
            // 짝수
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                // 홀수
                // 달라진 비트의 수 확인
                Integer.toBinaryString((int) numbers[i] + 1);
                answer[i] = Long.parseLong(Integer.toBinaryString(Integer.parseInt(numbers[i] + Integer.toBinaryString(1))));
            }
        }
        return answer;
    }

    public int bracketRotation(String s) {
        int answer = 0;

        // 회전 : 리스트 사용
        List<String> list = new ArrayList<>();
        String[] str = s.split("");

        for (int i = 0; i < s.length(); i++) {
            list.add(str[i]);
        }


        // 올바른 괄호 문자열 확인 : 스택 사용
        Stack<String> stack = new Stack<>();
        int length = list.size();


        // 길이만큼 회전
        while (length > 0) {
            // stack 초기화
            int top = -1; // 삽입 인덱스
            stack.removeAllElements();

            for (String ch : list) {
                // 1. 열려 있는 괄호일 경우 스택에 삽입
                if (ch.equals("(") || ch.equals("{") || ch.equals("[")) {
                    top++;
                    stack.add(ch);
                } else if ((top != -1) && (ch.equals(")") || ch.equals("}") || ch.equals("]"))) {
                    if (isChecked(ch, stack, top)) {
                        stack.remove(top);
                        top--;
                    } else {
                        break;
                    }
                } else {
                    stack.add(0, ch);
                }
            }
            // 3. 다 돌고 난 후 stack에 데이터가 남아있는 경우 false;
            if (stack.size() == 0) {
                answer++;

            }
            length--;

            // 괄호 회전
            list.add(list.get(0));
            list.remove(list.get(0));

        }

        return answer;
    }

    public boolean isChecked(String ch, Stack<String> stack, int top) {
        switch (ch) {
            case ")":
                if (stack.get(top).equals("(")) {
                    return true;
                }
                break;
            case "}":
                if (stack.get(top).equals("{")) {
                    return true;
                }
                break;

            case "]":
                if (stack.get(top).equals("[")) {
                    return true;
                }
                break;
        }
        return false;
    }

    // Refactor
    public int addDivisors(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            // 제곱 수인 경우 약수개 홀수
            if (i % Math.sqrt(i) == 0) {
                answer -= i;
            } else {
                answer += i;
            }
        }

        return answer;
    }

    public int nepoPlus(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }

//    진법 변환
//    int n = 10;
//    Integer.toUnsignedString(n, 3);

    // test 12 . 겹치는 선분의 길이
    public int pathsOfOverlapping(int[][] lines) {
        // 1. arr 배열 및 변수 초기화
        int answer = 0;
        int[] arr = new int[200];

        // 2. lines 정보를 arr 배열에 적용
        // 조건에 음수값이 있으므로 +100
        for (int i = 0; i < lines.length; i++) {
            for (int j = lines[i][0] + 100; j < lines[i][1] + 100; j++) {
                arr[j]++;
            }
        }
        for (int i = 0; i < 200; i++) {
            if (arr[i] > 1) {
                answer++;
            }
        }

        return answer;
    }

    // test11
    public int[] additionOfFractions(int denum1, int num1, int denum2, int num2) {
        int answer[] = new int[2];
        int denum = 0; // 분자
        int num = 0; // 분모

        num = num1 * num2;
        denum = denum1 * num2 + denum2 * num1;
        answer[0] = num;
        answer[1] = denum;
        int gcd = gcd(denum, num);
        answer[0] = denum / gcd;
        answer[1] = num / gcd;
        return answer;
    }

    // gcd. 최대공약수
    public int gcd(int a, int b) {
        if (a < b) {
            // 유클리드 호제법 조건
            int temp = a;
            a = b;
            b = temp;
        }
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
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
