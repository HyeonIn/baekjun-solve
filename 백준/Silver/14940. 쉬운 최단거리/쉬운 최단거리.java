import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static class coord{
		int i,j;
		public coord(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static int[][] map;
	static int[][] result;
	static boolean[][] check;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		result = new int[n][m];
		check = new boolean[n][m];
		
		coord start = new coord(0,0);
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int now = Integer.parseInt(st.nextToken());
				if (now == 2) {
					start = new coord(i,j);
				}
				if (now == 0) {
					result[i][j] = 0;
					
				}
				else {
					result[i][j] = -1;
				}
				map[i][j] = now;
			}
		}
		bfs(start);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	public static void bfs(coord start) {
		check[start.i][start.j] = true;
		result[start.i][start.j] = 0;
		ArrayDeque<coord> q = new ArrayDeque<>();
		q.add(start);
		int step = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			step++;
			for (int i = 0; i < size; i++) {
				coord now = q.poll();
				for (int j = 0; j < 4; j++) {
					int ni = now.i + dx[j];
					int nj = now.j + dy[j];
					if (ni < 0 || nj < 0 || ni >= n || nj >= m || check[ni][nj] || map[ni][nj] == 0) {
						continue;
					}
					check[ni][nj] = true;
					result[ni][nj] = step;
					q.add(new coord(ni,nj));
				}
			}
		}
	}
}