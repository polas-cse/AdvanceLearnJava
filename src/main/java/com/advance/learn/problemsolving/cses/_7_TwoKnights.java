
import java.io.*;

public class _7_TwoKnights {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        for (long k = 1; k <= n; k++) {
            long squares = k * k;
            long totalPairs = squares * (squares - 1) / 2;
            long attacking = 4 * (k - 1) * (k - 2);
            sb.append(totalPairs - attacking).append('\n');
        }

        System.out.print(sb);
    }
}