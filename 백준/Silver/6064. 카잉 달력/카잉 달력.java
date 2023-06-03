import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int nowLcm = M >= N ? gcd(M,N) : gcd(N,M);
			int nowGcd = (M*N)/(nowLcm);
			
			int answer = -1;
			for (int i = 0; i <= nowGcd; i+= M) {
				int target = i + x;
				if (target % N == 0) {
					if (N == y) {
						answer = target;
						break;
					}
				}
				if (target%N == y) {
					answer = target;
					break;
				}
			}
			if (M == x && N == y) {
				answer = nowGcd;
			}
			sb.append(answer).append('\n');
		}
		System.out.println(sb);
	}
	public static int gcd(int a, int b) {
		while (b != 0) {
			int r = a%b;
			a = b;
			b = r;
		}
		return a;
	}
}