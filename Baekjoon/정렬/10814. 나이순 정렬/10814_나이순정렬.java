import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[][] ages = new String[n][2];
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ages[i][0] = st.nextToken();
            ages[i][1] = st.nextToken();
        }

        Arrays.sort(ages, Comparator.comparingInt(o -> Integer.parseInt(o[0])));

        StringBuilder sb = new StringBuilder();
        for (String[] age: ages) {
            sb.append(age[0]).append(" ").append(age[1]).append("\n");
        }

        System.out.println(sb);
    }
}