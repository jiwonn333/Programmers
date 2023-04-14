package com.example.testcodeinjava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KitTestCode {

    @Test
    public void testCode() {
        System.out.println("#test1 : " + Arrays.toString(hateSameNumber(new int[]{1, 1, 3, 3, 0, 1, 1})));
    }

    //1. 스택/큐_같은 숫자는 싫어
    public int[] hateSameNumber(int[] arr) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        int number = -1;

        for (int i = 0; i < arr.length; i++) {
            // 중복된 값 제거하기
            if (number != arr[i]) {
                number = arr[i];
                list.add(arr[i]);
            }
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {

            answer[i] = list.get(i);
        }
        return answer;
    }
}
