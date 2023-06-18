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
		
		int[] result = new int[1000001];
		int[] count = new int[1000001];
		int[] arr = new int[1000001];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(st.nextToken());
			arr[i] = now;
			count[now]++;
		}
		
		
		ArrayDeque<coord> s = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			int now = arr[i];
			
			if (s.isEmpty()) {
				s.add(new coord(now, i));
			}
			else {
				while (!s.isEmpty() && count[now] > count[s.peekLast().num]) {
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