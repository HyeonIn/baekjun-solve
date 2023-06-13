import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class time implements Comparable<time>{
		int start, end;
		public time(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		public int compareTo(time t) {
			if (this.start > t.start) {
				return 1;
			}
			else if (this.start < t.start) {
				return -1;
			}
			else {
				return this.end - t.end;
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<time> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			pq.add(new time(s, t));
		}
		PriorityQueue<Integer> checkTime = new PriorityQueue<>();
		int answer = 0;
		while (!pq.isEmpty()) {
			time temp = pq.poll();
			if (checkTime.size() == 0 || temp.start < checkTime.peek()) {
				checkTime.add(temp.end);
				answer = Math.max(answer, checkTime.size());
			}
			else {
				checkTime.poll();
				checkTime.add(temp.end);
			}
		}
		System.out.println(answer);
	}
}