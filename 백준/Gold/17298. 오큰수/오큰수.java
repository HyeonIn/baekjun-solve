import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static class coord{
		int num, idx;
		public coord(int num, int idx) {
			this.num = num;
			this.idx = idx;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		
		int[] result = new int[n];
		ArrayDeque<coord> s = new ArrayDeque<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			if (s.isEmpty()) {
				s.add(new coord(now, i));
			}
			else {
				while (!s.isEmpty() && now > s.peekLast().num) {
					coord nge = s.pollLast();
					result[nge.idx] = now;
				}
				s.add(new coord(now, i));
			}
		}
		while (!s.isEmpty()) {
			coord now = s.pollLast();
			result[now.idx] = -1;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}
}