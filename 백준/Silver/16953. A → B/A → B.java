import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		result = Integer.MAX_VALUE;
		
		ArrayDeque<Long> q = new ArrayDeque<>();
		
		q.add(a);
		int count = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				long temp = q.poll();
				if (temp == b) {
					result = Math.min(result, count);
				}
				long next1 = temp * 2;
				long next2 = temp * 10 + 1;
				if (next1 <= b) {
					q.add(next1);
				}
				if (next2 <= b) {
					q.add(next2);
				}
			}
			count++;
		}
		
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
}