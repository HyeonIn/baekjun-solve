import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class coord{
		int i, j;
		public coord(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int answer, n, m;
	static int map[][];
	static boolean check[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		answer = 0;
		map = new int[n][m];
		check = new boolean[n][m];
		coord start = new coord(0,0);
		for (int i = 0; i < n; i++) {
			String now = br.readLine();
			for (int j = 0; j < m; j++) {
				if (now.charAt(j) == 'P') {
					map[i][j] = 2;
				}
				else if (now.charAt(j) == 'X') {
					map[i][j] = 1;
				}
				else if (now.charAt(j) == 'I') {
					start = new coord(i,j);
				}
			}
		}
		bfs(start);
		System.out.println(answer == 0 ? "TT" : answer);
	}
	public static void bfs(coord start) {
		check[start.i][start.j] = true;
		ArrayDeque<coord> q = new ArrayDeque<>();
		
		q.add(start);
		
		while (!q.isEmpty()) {
			coord now  = q.poll();
			for (int i = 0; i < 4; i++) {
				int ni = now.i+di[i];
				int nj = now.j+dj[i];
				
				if (ni < 0 || nj < 0 || ni >= n || nj >= m || check[ni][nj] || map[ni][nj] == 1) {
					continue;
				}
				if (map[ni][nj] == 2) {
					answer++;
				}
				check[ni][nj] = true;
				q.add(new coord(ni, nj));
			}
		}
	}
}