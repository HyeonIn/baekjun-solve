import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static class CmdInfo{
		String cmd;
		int len, n;
		public CmdInfo(String cmd, int len, int n) {
			this.cmd = cmd;
			this.len = len;
			this.n = n;
		}
	}
	static int target;
	static boolean flag;
	static int[] check;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			check = new int[10000];
			for (int j = 0; j < 10000; j++) {
				check[j] = Integer.MAX_VALUE;
			}
			flag = false;
			int n = Integer.parseInt(st.nextToken());
			target = Integer.parseInt(st.nextToken());
			String result = bfs(n);
			sb.append(result).append('\n');
		}
		System.out.println(sb);
	}
	public static String bfs(int n) {
		check[n] = 0;
		
		ArrayDeque<CmdInfo> q = new ArrayDeque<>();
		q.add(new CmdInfo("", 0, n));
		
		while (!q.isEmpty()) {
			CmdInfo now = q.poll();
			if (now.n == target) {
				return now.cmd;
			}
			int nextD = (now.n*2)%10000;
			if (check[nextD] > now.len+1) {
				check[nextD] = now.len+1;
				q.add(new CmdInfo(now.cmd+"D", now.len+1, nextD));
			}
			int nextS = now.n-1 < 0 ? 9999 : now.n-1;
			if (check[nextS] > now.len+1) {
				check[nextS] = now.len+1;
				q.add(new CmdInfo(now.cmd+"S", now.len+1, nextS));
			}
			int nextL = (now.n/1000)+((now.n%1000)*10);
			if (check[nextL] > now.len+1) {
				check[nextL] = now.len+1;
				q.add(new CmdInfo(now.cmd+"L", now.len+1, nextL));
			}
			int nextR = (now.n/10)+((now.n%10)*1000);
			if (check[nextR] > now.len+1) {
				check[nextR] = now.len+1;
				q.add(new CmdInfo(now.cmd+"R", now.len+1, nextR));
			}
		}
		return "";
	}
}