import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int map[][];
	static boolean check[];
	static int answer;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[5][5];
		check = new boolean[1000000];
		answer = 0;
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i,j,1,map[i][j]*100000);
			}
		}
		System.out.println(answer);
	}
	public static void dfs(int i, int j, int count, int num) {
		if (count == 6) {
			if (!check[num]) {
				check[num] = true;
				answer++;
			}
			return;
		}
		for (int k = 0; k < 4; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if (ni < 0 || nj < 0 || ni >= 5 || nj >=5) {
				continue;
			}
			dfs(ni, nj, count+1, num+(int)(map[ni][nj]*Math.pow(10, 6-(count+1))));
		}
	}
}