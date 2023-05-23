import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class coord implements Comparable<coord>{
		int num, idx;
		public coord(int num, int idx) {
			this.num = num;
			this.idx = idx;
		}
		@Override
		public int compareTo(coord o) {
			return this.num - o.num;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		coord[] arr = new coord[n];
		int[] result = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = new coord(Integer.parseInt(st.nextToken()), i);
		}
		
		Arrays.sort(arr);
		
		int count = 0;
		
		for (int i = 0; i < n-1; i++) {
			result[arr[i].idx] = count;
			if (arr[i].num < arr[i+1].num) {
				count++;
			}
		}
		result[arr[n-1].idx] = count;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}
}