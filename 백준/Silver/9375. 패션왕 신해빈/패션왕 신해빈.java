import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static boolean[] check;
	static int answer;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < tc; t++) {
			int count = 0;
			arr = new int[40];
			check = new boolean[40];
			answer = 1;
			String[] clothes = new String[40];
			for (int i = 0; i < 40; i++) {
				clothes[i] = "";
			}
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String kind = st.nextToken();
				boolean flag = false;
				for (int j = 0; j <= count; j++) {
					if (clothes[j].equals(kind)) {
						arr[j]++;
						flag = true;
						break;
					}
				}
				if (!flag) {
					arr[++count] = 1;
					clothes[count] = kind;
				}
			}
			for (int i = 1; i <= count; i++) {
				answer *= arr[i]+1;
			}
			sb.append(answer-1).append('\n');
		}
		System.out.println(sb);
	}
}