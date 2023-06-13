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
		int[] checkTime = new int[200000];
		int count = 0;
		while (!pq.isEmpty()) {
			time temp = pq.poll();
			boolean check = false;
			for (int i = 0; i < count; i++) {
				if (checkTime[i] <= temp.start) {
					check = true;
					checkTime[i] = temp.end;
					break;
				}
			}
			if (!check) {
				checkTime[count++] = temp.end;
			}
		}
		System.out.println(count);
	}
}