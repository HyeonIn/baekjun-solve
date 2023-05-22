import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static class coord {
		int i,j;
		public coord(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static coord[] coordArr = new coord[10];
	static boolean[] checkComb;

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static int[][] checkCow;
	
	static int n,m,countTwo, answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[][] cow = new int[n][n];
		checkCow = new int[n][n];
		answer = Integer.MAX_VALUE;
		countTwo = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				cow[i][j] = Integer.parseInt(st.nextToken());
				if (cow[i][j] == 0) {
					checkCow[i][j] = 0;
				}
				else if (cow[i][j] == 1) {
					checkCow[i][j] = -1;
				}
				else {
					checkCow[i][j] = 0;
					coordArr[countTwo++] = new coord(i,j);
				}
				
			}
		}
		checkComb = new boolean[countTwo];
		
		comb(0,0);
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
	
	public static int[][] copy(int[][] arr){
		int[][] copyArr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copyArr[i][j] = arr[i][j];
			}
		}
		return copyArr;
	}
	
	public static boolean checkZero(int[][] arr) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 0) {
					count++;
				}
			}
		}
		return count > m ? true : false;
	}
	
	public static void bfs(int i, int j, int[][] arr, boolean[][] checkTwo) {
		boolean[][] check = new boolean[n][n];
		int count = 0;
		arr[i][j] = 0;
		ArrayDeque<coord> q = new ArrayDeque<>();
		q.add(new coord(i,j));
		check[i][j] = true;
		while(!q.isEmpty()) {
			int repeat = q.size();
			count++;
			for (int r = 0; r < repeat; r++) {
				coord temp = q.poll();
				for (int k = 0; k < 4; k++) {
					int ni = temp.i + di[k];
					int nj = temp.j + dj[k];
					if (ni < 0 || nj < 0 || ni >= n || nj >= n || arr[ni][nj] == -1 || check[ni][nj]) {
						continue;
					}
					if (arr[ni][nj] <= count && arr[ni][nj] > 0) {
						continue;
					}
					if (checkTwo[ni][nj]) {
						continue;
					}
					arr[ni][nj] = count;
					check[ni][nj] = true;
					q.add(new coord(ni, nj));
				}
			}
		}
	}
	public static void comb(int idx, int cnt) {
		if (cnt == m) {
			int[][] copyArr = copy(checkCow);
			boolean[][] checkTwo = new boolean[n][n];
			for (int t = 0; t < countTwo; t++) {
				if (checkComb[t]) {
					checkTwo[coordArr[t].i][coordArr[t].j] = true;
					bfs(coordArr[t].i, coordArr[t].j, copyArr, checkTwo);
				}
			}
			int tempAnswer = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (copyArr[i][j] != -1) {
						tempAnswer = Integer.max(tempAnswer, copyArr[i][j]);
					}
				}
			}
			if (!checkZero(copyArr)) {
				answer = Integer.min(answer, tempAnswer);
			}
			return;
		}
		if (idx == countTwo) {
			return;
		}
		checkComb[idx] = true;
		comb(idx+1, cnt+1);
		checkComb[idx] = false;
		comb(idx+1, cnt);
	}
}