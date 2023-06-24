import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		int[][] check = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				check[i][j] = s.charAt(j) - '0';
			}
		}
		int answer = 0;
		for (int i = 0; i < n-2; i++) {
			for (int j = 0; j < m-2; j++) {
				if (arr[i][j] != check[i][j]) {
					answer++;
					flip(i,j,arr);
				}
			}
		}
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] != check[i][j]) {
					flag = false;
					break;
				}
			}
		}
		System.out.println(flag ? answer : -1);
	}
	public static void flip(int i, int j, int[][] arr) {
		for (int k = i; k < i+3; k++) {
			for (int l = j; l < j+3; l++) {
				if (arr[k][l] == 1) {
					arr[k][l] = 0;
				}
				else {
					arr[k][l] = 1;
				}
			}
		}
	}
}