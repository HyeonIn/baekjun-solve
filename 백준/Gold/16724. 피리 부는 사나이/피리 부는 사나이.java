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
	static int[] dx = {1,0,0,-1};
	static int[] dy = {0,-1,1,0};
	static int[][] check;
	static int[][] map;
	
	static class coord{
		int i, j;
		public coord(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		 
		check = new int[n][m];
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				check[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < n; i++) {
			String now = br.readLine();
			for (int j = 0; j < m; j++) {
				char temp = now.charAt(j);
				if (temp == 'D') {
					map[i][j] = 0;
				}
				else if (temp == 'L') {
					map[i][j] = 1;
				}
				else if (temp == 'R') {
					map[i][j] = 2;
				}
				else {
					map[i][j] = 3;
				}
			}
		}
		int num = 0;
		int[] union = new int[1000000];
		for (int i = 0; i < 1000000; i++) {
			union[i] = i;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (check[i][j] == Integer.MAX_VALUE) {
					num++;
					int find = bfs(i, j, num);
					union[num] = union[find];
				}
			}
		}
		int answer = 0;
		boolean[] countCheck = new boolean[num+1];
		for (int i = 1; i <= num; i++) {
			if (!countCheck[union[i]]) {
				countCheck[union[i]] = true;
				answer += 1;
			}
		}
		System.out.println(answer);
	}
	public static int bfs(int i, int j, int num) {
		ArrayDeque<coord> q = new ArrayDeque<>();
		q.add(new coord(i, j));
		check[i][j] = num;
		int find = 0;
		while (!q.isEmpty()) {
			coord temp = q.poll();
			int ni = temp.i + dx[map[temp.i][temp.j]];
			int nj = temp.j + dy[map[temp.i][temp.j]];
			if (check[ni][nj] == Integer.MAX_VALUE) {
				check[ni][nj] = num;
				q.add(new coord(ni, nj));
			}
			else {
				find = check[ni][nj];
			}
		}
		return find;
	}
}