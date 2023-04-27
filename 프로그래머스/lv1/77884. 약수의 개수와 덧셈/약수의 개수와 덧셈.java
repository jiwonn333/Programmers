class Solution {
    public int solution(int left, int right) {
         int answer = 0;
        
        while (left <= right) {
            int cnt = 0;
            for (int i = 1; i <= Math.sqrt(left); i++) {
                if (i * i == left) {
                    cnt++;
                } else if (left % i == 0) {
                    cnt += 2;
                }
            }
            
            if (cnt % 2 == 0) {
                answer += left;
            } else {
                answer -= left;
            }
            left++;
        }
        
        return answer;
    }
}