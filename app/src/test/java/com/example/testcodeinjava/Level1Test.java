package com.example.testcodeinjava;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Level1Test {
    @Test
    public void printCode() {
        System.out.println("test 1 : " + babblingTest(new String[]{"aya", "yee", "u", "maa", "wyeoo"}));
//        System.out.println("test 2 : " + Arrays.toString(solution(new String[]{"SOO", "OXX", "OOO"}, new String[]{"E 2", "S 2", "W 1"})));
        System.out.println("test3: " + Arrays.toString(solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2)));
    }

    // 2022 KAKAO BLIND RECRUITMENT > 신고 결과 받기
    public int[] solution(String[] id_list, String[] report, int k) {
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
