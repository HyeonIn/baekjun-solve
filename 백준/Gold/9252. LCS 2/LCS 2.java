import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static String s1, s2;
	static int[][] dp;
	public static void printString(int i, int j) {
		if (dp[i][j] == 0) {
			return;
		}
		if (s1.charAt(i-1) == s2.charAt(j-1)) {
			printString(i-1, j-1);
			System.out.print(s1.charAt(i-1));
		}
		else {
			if (dp[i-1][j] > dp[i][j-1]) {
				printString(i-1, j);
			}
			else{
				printString(i, j-1);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		s1 = br.readLine();
		s2 = br.readLine();
		
		int n = s1.length();
		int m = s2.length();
		
		dp = new int[n+1][m+1];
		
		dp[1][1] = s1.charAt(0) == s2.charAt(0) ? 1 : 0;
		
		for (int i = 2; i <= n; i++) {
			if (s1.charAt(i-1) == s2.charAt(0)) {
				dp[i][1] = 1;
			}
			else {
				dp[i][1] = dp[i-1][1];
			}
		}
		for (int i = 2; i <= m; i++) {
			if (s2.charAt(i-1) == s1.charAt(0)) {
				dp[1][i] = 1;
			}
			else {
				dp[1][i] = dp[1][i-1];
			}
		}
		for (int i = 2; i <= n; i++) {
			for (int j = 2; j <= m; j++) {
				if (s1.charAt(i-1) != s2.charAt(j-1)) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
				else {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
			}
		}
		int answer = dp[n][m];
		System.out.println(answer);
		printString(n, m);
	}
}