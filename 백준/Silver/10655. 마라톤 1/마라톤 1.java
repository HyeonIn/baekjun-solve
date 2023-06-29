import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class coord{
		int i, j;
		public coord(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int n = Integer.parseInt(br.readLine());
		 
		coord[] checkPoints = new coord[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		checkPoints[0] = new coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		int totalDist = 0;
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			checkPoints[i] = new coord(Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken()));
			
			totalDist += manhattan(checkPoints[i], checkPoints[i-1]);
		}
		
		int answer = Integer.MAX_VALUE;
		
		for (int i = 1; i < n-1; i++) {
			int tempTotal = totalDist;
			tempTotal -= manhattan(checkPoints[i], checkPoints[i-1]);
			tempTotal -= manhattan(checkPoints[i], checkPoints[i+1]);
			tempTotal += manhattan(checkPoints[i-1], checkPoints[i+1]);
			answer = Math.min(answer, tempTotal);
			
		}
		System.out.println(answer);
	}
	public static int manhattan(coord a, coord b) {
		return Math.abs(a.i - b.i) + Math.abs(a.j - b.j);
	}
}