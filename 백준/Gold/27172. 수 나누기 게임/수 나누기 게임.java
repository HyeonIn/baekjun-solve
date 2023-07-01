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
		 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] check = new int[1000001];
		
		for (int i = 0; i < 1000001; i++) {
			check[i] = -1;
		}
		int[] result = new int[n];
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(st.nextToken());
			arr[i] = now;
			check[now] = i;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = arr[i] * 2; j < 1000001; j += arr[i]) {
				if (check[j] != -1) {
					result[i] += 1;
					result[check[j]] -= 1;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}
}