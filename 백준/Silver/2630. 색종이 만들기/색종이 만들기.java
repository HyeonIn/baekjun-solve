import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] colorMap;
	static int[] colorCount = {0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		colorMap = new int[n][n];
		
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				colorMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0,n);
		
		System.out.println(colorCount[0]);
		System.out.println(colorCount[1]);
	}
	public static void dfs(int startR, int startC, int size) {
		boolean flag = true;
		int color = colorMap[startR][startC];
		
		for (int i = startR; i < startR+size; i++) {
			for (int j = startC; j < startC+size; j++) {
				if (colorMap[i][j] != color) {
					flag = false;
					dfs(startR, startC, size/2);
					dfs(startR, startC+(size/2), size/2);
					dfs(startR+(size/2), startC, size/2);
					dfs(startR+(size/2), startC+(size/2), size/2);
					break;
				}
			}
			if (!flag) {
				break;
			}
		}
		if (flag) {
			colorCount[color]++;
		}
	}
}