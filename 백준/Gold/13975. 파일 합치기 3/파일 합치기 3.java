import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int tc = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int t = 0; t < tc; t++) {
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			PriorityQueue<Long> pq = new PriorityQueue<>();
			
			for (int i = 0; i < n; i++) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			int count = 1;
			long result = 0;
			long temp = 0;
			while (!pq.isEmpty()) {
				temp += pq.poll();
				if (count % 2 == 0) {
					pq.add(temp);
					result += temp;
					temp = 0;
				}
				count++;
			}
			sb.append(result).append('\n');
		}
		System.out.println(sb);
	}
}