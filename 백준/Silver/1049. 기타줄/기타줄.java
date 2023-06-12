import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int minPack = Integer.MAX_VALUE;
		int minEach = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			minPack = Math.min(Integer.parseInt(st.nextToken()), minPack);
			minEach = Math.min(Integer.parseInt(st.nextToken()), minEach);
		}
		
		int case1 = minEach * n;
		int case2 = ((n/6) * minPack) + ((n%6) * minEach);
		int case3 = n%6 == 0 ? minPack*(n/6) : minPack*(n/6+1);
		System.out.println(Math.min(Math.min(case1, case2), case3));
	}
}