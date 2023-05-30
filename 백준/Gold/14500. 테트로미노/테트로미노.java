import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dx = {
						{0,1,2,3}, {0,0,0,0}, {0,1,0,1}, 
						{0,0,0,1}, {0,1,2,0}, {0,1,1,1}, {2,0,1,2},
						{1,1,0,1}, {0,0,1,2}, {0,1,0,0}, {0,1,2,2},
						{0,0,1,1}, {1,2,0,1}, {1,0,1,0}, {0,1,1,2},
						{0,1,2,1}, {1,0,1,1}, {1,0,1,2},{0,0,1,0}};
	static int[][] dy = {
						{0,0,0,0}, {0,1,2,3},{0,0,1,1}, 
						{0,1,2,2}, {0,0,0,1}, {0,0,1,2}, {0,1,1,1},
						{0,1,2,2}, {0,1,1,1}, {0,0,1,2}, {0,0,0,1},
						{0,1,1,2}, {0,0,1,1}, {0,1,1,2}, {0,0,1,1},
						{0,0,0,1}, {0,1,1,2}, {0,1,1,1},{0,1,1,2}};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < 19; k++) {
					boolean flag = true;
					int tempScore = 0;
					for (int l = 0; l < 4; l++) {
						int next_i = i + dy[k][l];
						int next_j = j + dx[k][l];
						if (next_i >= n || next_j >= m ) {
							flag = false;
							continue;
						}
						tempScore+= map[next_i][next_j];
					}
					if (flag) {
						answer = Math.max(answer, tempScore);
					}
				}
			}
		}
		System.out.println(answer);
	}
}