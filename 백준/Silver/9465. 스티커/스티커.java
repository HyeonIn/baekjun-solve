import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < tc; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[2][n];
			
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] dp = new int[2][n];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < n; j++) {
					dp[i][j] = Integer.MIN_VALUE;
				}
			}
			
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			
			for (int j = 0; j < n-1; j++) {
				for (int i = 0; i < 2; i++) {
					int nextJ = j+1;
					if (i == 0) {
						dp[1][nextJ] = Math.max(dp[0][j] + arr[1][nextJ], dp[1][nextJ]);
					}
					else {
						dp[0][nextJ] = Math.max(dp[1][j] + arr[0][nextJ], dp[0][nextJ]);
					}
					int nextJ2 = j+2;
					if (nextJ2 >= n) {
						continue;
					}
					if (i == 0) {
						dp[1][nextJ2] = Math.max(dp[0][j] + arr[1][nextJ2], dp[1][nextJ2]);
					}
					else {
						dp[0][nextJ2] = Math.max(dp[1][j] + arr[0][nextJ2], dp[0][nextJ2]);
					}
				}
			}
			int answer = Integer.MIN_VALUE;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < n; j++) {
					answer = Math.max(answer, dp[i][j]);
				}
			}
			System.out.println(answer);
		}
	}
}