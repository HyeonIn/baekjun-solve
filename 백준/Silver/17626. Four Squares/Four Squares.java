import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dp = new int[50001];
		
		for (int i = 0; i < 50001; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		int i = 1;
		
		while (i * i <= 50000) {
			dp[i*i] = 1;
			i+=1;
		}
		for (int j = 2; j <= 50000; j++) {
			for (int k = 1; k < Math.sqrt(j); k++) {
				dp[j] = Math.min(dp[j], dp[j-(k*k)] + 1);
			}
		}
		int n = Integer.parseInt(br.readLine());
		System.out.println(dp[n]);
	}
}