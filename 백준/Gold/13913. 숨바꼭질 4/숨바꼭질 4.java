import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static class coord{
		int n;
		coord before;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		public coord(int n, coord c) {
			this.n = n;
			this.before = c;
		}
	}
	static boolean[] check = new boolean[100001];
	static int[] dn = {-1,1,2};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		if (n == m) {
			System.out.println(0);
			System.out.println(n);
		}
		else {
			bfs(n,m);
		}
		
	}
	public static void bfs(int n, int m) {
		check[n] = true;
		int count = 0;
		ArrayDeque<coord> q = new ArrayDeque<>();
		q.add(new coord(n, null));
		while (!q.isEmpty()) {
			count++;
			int repeat = q.size();
			for (int r = 0; r < repeat; r++) {
				coord temp = q.poll();
				for (int k = 0; k < 3; k++) {
					int next_n = k == 2 ? 2*temp.n : temp.n + dn[k];
					if (next_n < 0 || next_n > 100000 || check[next_n]) {
						continue;
					}
					if (next_n == m) {
						System.out.println(count);
						StringBuilder sb = new StringBuilder();
						ArrayDeque<Integer> road = new ArrayDeque<>();
						road.add(next_n);
						while (temp.before != null) {
							road.add(temp.n);
							temp = temp.before;
						}
						sb.append(n).append(" ");
						while (!road.isEmpty()) {
							sb.append(road.pollLast()).append(" ");
						}
						System.out.println(sb);
						return;
					}
					check[next_n] = true;
					q.add(new coord(next_n, temp));
				}
			}
		}
	}
}