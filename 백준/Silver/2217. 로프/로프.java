import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int answer = Integer.MIN_VALUE;
		
		int n = Integer.parseInt(br.readLine());
		 
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(br.readLine());
			pq.add(now);
		}
		
		while (!pq.isEmpty()) {
			int size = pq.size();
			int min = pq.poll();
			
			answer = Math.max(answer, min*size);
		}
		
		System.out.println(answer);
		
	}
}