import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][3];
		int[][] dp = new int[n][3];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = Integer.MAX_VALUE;
		
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];
		for (int i = 1; i < n; i++) {
			dp[i][0] = Integer.MAX_VALUE;
			dp[i][1] = Integer.MAX_VALUE;
			dp[i][2] = Integer.MAX_VALUE;
		}
		
		dp[1][1] = arr[0][0] + arr[1][1];
		dp[1][2] = arr[0][0] + arr[1][2];
		for (int i = 2; i < n; i++) {
			if (i == n-1) {
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
			}
			else {
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
			}
		}
		answer = Math.min(answer, Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));
		
		for (int i = 1; i < n; i++) {
			dp[i][0] = Integer.MAX_VALUE;
			dp[i][1] = Integer.MAX_VALUE;
			dp[i][2] = Integer.MAX_VALUE;
		}
		
		dp[1][0] = arr[0][1] + arr[1][0];
		dp[1][2] = arr[0][1] + arr[1][2];
		for (int i = 2; i < n; i++) {
			if (i == n-1) {
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
			}
			else {
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
			}
		}
		
		answer = Math.min(answer, Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));
		
		for (int i = 1; i < n; i++) {
			dp[i][0] = Integer.MAX_VALUE;
			dp[i][1] = Integer.MAX_VALUE;
			dp[i][2] = Integer.MAX_VALUE;
		}
		
		dp[1][0] = arr[0][2] + arr[1][0];
		dp[1][1] = arr[0][2] + arr[1][1];
		for (int i = 2; i < n; i++) {
			if (i == n-1) {
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
			}
			else {
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
			}
		}
		answer = Math.min(answer, Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));
		System.out.println(answer);
	}
}