import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map;
	static int[][] zeroCheck;
	static class coord{
		int i, j;
		coord(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static int[] numberCount;
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		zeroCheck = new int[n][m];
		numberCount = new int[n * m +1];
		for (int i = 0; i < n; i++) {
			String now = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = now.charAt(j) - '0';
			}
		}
		int number = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0 && zeroCheck[i][j] == 0) {
					bfs(i, j, number);
					number++;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					HashSet<Integer> set = new HashSet<>();
					for (int k = 0; k < 4; k++) {
						int ni = i + dx[k];
						int nj = j + dy[k];
						if (ni < 0 || nj < 0 || ni >= n || nj >= m) {
							continue;
						}
						set.add(zeroCheck[ni][nj]);
					}
					for (Integer integer : set) {
						map[i][j] += numberCount[integer];
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(map[i][j]%10);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	public static void bfs(int i, int j, int number) {
		zeroCheck[i][j] = number;
		int count = 1;
		ArrayDeque<coord> q = new ArrayDeque<>();
		q.add(new coord(i, j));
		while (!q.isEmpty()) {
			coord now = q.poll();
			for (int k = 0; k < 4; k++) {
				int ni = now.i + dx[k];
				int nj = now.j + dy[k];
				if (ni < 0 || nj < 0 || ni >= n || nj >= m || zeroCheck[ni][nj] != 0 || map[ni][nj] == 1) {
					continue;
				}
				zeroCheck[ni][nj] = number;
				count++;
				q.add(new coord(ni, nj));
			}
		}
		numberCount[number] = count;
	}
}