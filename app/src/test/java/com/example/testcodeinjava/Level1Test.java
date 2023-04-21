package com.example.testcodeinjava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Level1Test {
    @Test
    public void printCode() {
        System.out.println("test 1 : " + babblingTest(new String[]{"aya", "yee", "u", "maa", "wyeoo"}));
        System.out.println("test 2: " + Arrays.toString(getReportResults(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2)));
        System.out.println("test 내적 : " + getDotProduct(new int[]{1, 2, 3, 4}, new int[]{-3, -1, 0, 2}));
        System.out.println("test : 두 개 뽑아서 더하기 : " + Arrays.toString(pickTwoAdd(new int[]{2, 1, 3, 4, 1})));
    }

    // 월간 코드 챌린지 시즌1 > 두 개 뽑아서 더하기
    public int[] pickTwoAdd(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public int getDotProduct(int[] a, int[] b) {
        int answer = 0;
        // 각 인덱스 곱셈 값 출력
        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }

        return answer;
    }


    // 2022 KAKAO BLIND RECRUITMENT > 신고 결과 받기
    public int[] getReportResults(String[] id_list, String[] report, int k) {
        /**
         * 중복 제거를 위해 distinct() 실행 후 List 저장
         * key: 신고당한사람, value: 몇명한테 당했는지
         */
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        Map<String, Integer> count = new HashMap<>();
        for (String repo : list) {
            String reported = repo.split(" ")[1];
            count.put(reported, count.getOrDefault(reported, 0) + 1);
        }
        /**
         * "muzi" -> 1
         * "neo" -> 2
         * "frodo" -> 2
         */


        return Arrays.stream(id_list).map(_user -> {
            String user = _user;
            List<String> reporterList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
            return reporterList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
        }).mapToInt(Long::intValue).toArray();

    }


    // 옹알이
    public int babblingTest(String[] babbling) {
        int cnt = 0;
        for (int i = 0; i < babbling.length; i++) {
            babbling[i] = babbling[i].replace("aya", " ");
            babbling[i] = babbling[i].replace("ye", " ");
            babbling[i] = babbling[i].replace("woo", " ");
            babbling[i] = babbling[i].replace("ma", " ");
            babbling[i] = babbling[i].replace(" ", "");

            if (babbling[i].equals("")) {
                cnt++;
            }
        }
        return cnt;
    }
}
