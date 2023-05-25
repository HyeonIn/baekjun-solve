import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			int k = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> tm = new TreeMap<>();
			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				if (cmd.equals("D")) {
					if (tm.isEmpty()) {
						continue;
					}
					if (num == 1) {
						int maxKey = tm.lastKey();
						if (tm.get(maxKey) == 1) {
							tm.remove(maxKey);
						}
						else {
							tm.put(maxKey, tm.get(maxKey)-1);
						}
					}
					else {
						int minKey = tm.firstKey();
						if (tm.get(minKey) == 1) {
							tm.remove(minKey);
						}
						else {
							tm.put(minKey, tm.get(minKey)-1);
						}
					}
				}
				else {
					tm.put(num, tm.getOrDefault(num,  0) + 1);
				}
			}
			if (tm.isEmpty()) {
				sb.append("EMPTY\n");
			}
			else {
				sb.append(tm.lastKey()+" " + tm.firstKey() + "\n");
			}
		}
		System.out.println(sb);
	}
}