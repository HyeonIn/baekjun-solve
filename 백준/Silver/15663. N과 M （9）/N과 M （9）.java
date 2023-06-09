import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] result;
	static boolean[] check;
	static HashMap<String, Integer> map;
	static StringBuilder sb;
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		check = new boolean[n];
		sb = new StringBuilder();
		map = new HashMap<>();
		result = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		perm(0);
		System.out.println(sb);
	}
	public static void perm(int idx) {
		if (idx == m) {
			StringBuilder temp = new StringBuilder();
			for (int i = 0; i < m; i++) {
				temp.append(result[i]).append(' ');
			}
			if (map.get(temp.toString()) != null) {
				return;
			}
			map.put(temp.toString(), 1);
			sb.append(temp.toString());
			sb.append('\n');
			return;
		}
		
		for (int j = 0; j < n; j++) {
			if (!check[j]) {
				result[idx] = arr[j];
				check[j] = true;
				perm(idx+1);
				check[j] = false;
			}
		}
	}
}