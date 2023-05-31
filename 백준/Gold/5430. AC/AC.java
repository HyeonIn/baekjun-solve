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
		
		for (int i = 0; i < tc; i++) {
			String operations = br.readLine();
			int size = Integer.parseInt(br.readLine());
			String arr = br.readLine();
			String arr2 = arr.substring(1, arr.length()-1);
			String[] afterArr = arr2.split(",");
			ArrayDeque<Integer> deq = new ArrayDeque<>();
			for (int j = 0; j < size; j++) {
				deq.add(Integer.parseInt(afterArr[j]));
			}
			boolean flag = true;
			boolean isErr = false;
			for (int j = 0; j < operations.length(); j++) {
				if (operations.charAt(j) == 'R') {
					flag = !flag;
				}
				else {
					if (deq.isEmpty()) {
						System.out.println("error");
						isErr = true;
						break;
					}
					if (flag) {
						deq.pollFirst();
					}
					else {
						deq.pollLast();
					}
				}
			}
			if (!isErr) {
				StringBuilder sb = new StringBuilder();
				sb.append('[');
				while (!deq.isEmpty()) {
					if (flag) {
						sb.append(deq.pollFirst());
						if (deq.size() != 0) {
							sb.append(',');
						}
							
					}
					else {
						sb.append(deq.pollLast());
						if (deq.size() != 0) {
							sb.append(',');
						}
					}
				}
				sb.append(']');
				System.out.println(sb);
			}
			
			
		}
	}
}