import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minPQ = new PriorityQueue<>();
		int plusMax = -1;
		int minusMax = -1;
		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(st.nextToken());
			if (now > 0) {
				maxPQ.add(now);
				plusMax = Math.max(plusMax, now);
			}
			else {
				minPQ.add(now);
				minusMax = Math.max(minusMax, Math.abs(now));
			}
		}
		
		boolean biggerPlus = plusMax >= minusMax ? true : false;
		
		int total = 0;
		
		boolean isFirst = true;
		while (!maxPQ.isEmpty()) {
			for (int i = 0; i < m; i++) {
				if (maxPQ.isEmpty()) {
					break;
				}
				int max = maxPQ.poll();
				if (i == 0) {
					if (biggerPlus) {
						if (isFirst) {
							total += max;
						}
						else {
							total += max*2;
						}
					}
					else {
						total+= max*2;
					}
				}
			}
			isFirst = false;
		}
		isFirst = true;
		while (!minPQ.isEmpty()) {
			for (int i = 0; i < m; i++) {
				if (minPQ.isEmpty()) {
					break;
				}
				int min = minPQ.poll();
				if (i == 0) {
					if (!biggerPlus) {
						if (isFirst) {
							total += Math.abs(min);
						}
						else {
							total += Math.abs(min*2);
						}
					}
					else {
						total += Math.abs(min * 2);
					}
				}
			}
			isFirst = false;
		}
		
		System.out.println(total);
	}
}