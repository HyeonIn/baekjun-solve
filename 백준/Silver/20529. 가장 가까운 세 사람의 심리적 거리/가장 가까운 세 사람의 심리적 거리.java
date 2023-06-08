import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<String> arr;
	static boolean check[];
	static int n, answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < tc; t++) {
			n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new ArrayList<>();
			answer = Integer.MAX_VALUE;
			if (n > 32) {
				sb.append(0).append('\n');
			}
			else {
				for (int i = 0; i < n; i++) {
					String now = st.nextToken();
					arr.add(now);
				}
				check = new boolean[n];
				getAnswer();
				sb.append(answer).append('\n');
			}
		}
		System.out.println(sb);
	}
	public static void getAnswer() {
		for (int i = 0; i < n-2; i++) {
			for (int j = i+1; j < n-1; j++) {
				for (int k = j+1; k < n; k++) {
					int tempCount = 0;
					tempCount += compare(arr.get(i), arr.get(j));
					tempCount += compare(arr.get(j), arr.get(k));
					tempCount += compare(arr.get(i), arr.get(k));
					answer = Math.min(tempCount, answer);
				}
			}
		}
	}
	public static int compare(String s1, String s2) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				count++;
			}
		}
		return count;
	}
}