import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] snakes;
	static int[] ladders;
	static int[] check;
	static int answer;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		snakes = new int[101];
		ladders = new int[101];
		check = new int[101];
		for (int i = 0; i < 101; i++) {
			check[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			ladders[x] = y;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			snakes[u] = v;
		}
		answer = Integer.MAX_VALUE;
		dfs(1, 0);
		System.out.println(answer);
	}
	public static void dfs(int n, int count) {
		if (n == 100) {
			answer = Math.min(answer, count);
		}
		if (check[n] < count) {
			return;
		}
		check[n] = count;
		for (int i = 1; i <= 6; i++) {
			int next = n + i;
			if (next > 100) {
				continue;
			}
			if (snakes[next] != 0) {
				next = snakes[next];
			}
			if (ladders[next] != 0) {
				next = ladders[next];
			}
			dfs(next, count+1);
		}
	}
}