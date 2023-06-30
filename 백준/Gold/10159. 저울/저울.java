import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int n = Integer.parseInt(br.readLine());
		 
		LinkedList<Integer>[] graph = new LinkedList[n+1];
		for (int i = 0; i < n+1; i++) {
			graph[i] = new LinkedList<>();
		}
		int m = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int big = Integer.parseInt(st.nextToken());
			int small = Integer.parseInt(st.nextToken());
			graph[big].add(small);
		}
		
		StringBuilder sb = new StringBuilder();
		
		int[] check = new int[n+1];
		for (int i = 0; i < n+1; i++) {
			check[i] = n-1;
		}
		
		for (int i = 1; i <= n; i++) {
			ArrayDeque<Integer> q = new ArrayDeque<>();
			boolean[] checkNum = new boolean[n+1];
			q.add(i);
			while (!q.isEmpty()) {
				int temp = q.poll();
				for (Integer integer : graph[temp]) {
					if (checkNum[integer]) {
						continue;
					}
					check[i] -= 1;
					check[integer] -= 1;
					checkNum[integer] = true;
					q.add(integer);
				}
			}
		}
		for (int i = 1; i < n+1; i++) {
			sb.append(check[i]).append('\n');
		}
		System.out.println(sb);
	}
}