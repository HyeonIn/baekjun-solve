import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		char[] result = new char[50];
		String start = br.readLine();
		int len = start.length();
		for (int i = 0; i < start.length(); i++) {
			result[i] = start.charAt(i);
		}
		for (int i = 1; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < temp.length(); j++) {
				if (result[j] != temp.charAt(j)) {
					result[j] = '?';
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			sb.append(result[i]);
		}
		System.out.println(sb);
	}
}