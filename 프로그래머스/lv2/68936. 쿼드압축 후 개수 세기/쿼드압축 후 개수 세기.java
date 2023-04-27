class Solution {
     int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        int x = 0; // 행
        int y = 0; // 열

        int size = arr.length;

        compression(x, y, size, arr);

        return answer;
    }
    public boolean check(int x, int y, int size, int[][]arr) {
        int number = arr[x][y];
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if (number != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    
    public void compression(int x, int y, int size, int arr[][]) {
        if (check(x, y, size, arr) || size == 1) {
            if (arr[x][y] == 0) {
                answer[0]++;
            } else {
                answer[1]++;
            }
        } else {
            // 1사분면
            compression(x, y, size/2, arr);
            // 2사분면
            compression(x, y+size/2, size/2, arr);
            // 3사분면
            compression(x+size/2, y, size/2, arr);
            //4사분면
            compression(x+size/2, y+size/2, size/2, arr);
        }
    }
}