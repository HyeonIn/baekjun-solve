import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s1 = br.readLine().split(":");
		int now = Integer.parseInt(s1[0]) * 3600;
		now += Integer.parseInt(s1[1]) * 60;
		now += Integer.parseInt(s1[2]);
		
		String[] s2 = br.readLine().split(":");
		int start = Integer.parseInt(s2[0]) * 3600;
		start += Integer.parseInt(s2[1]) * 60;
		start += Integer.parseInt(s2[2]);
		
		StringBuilder sb = new StringBuilder();
		int answer = now > start ? 24*3600 - now + start : start - now;
		
		int a1 = answer / 3600;
		sb.append(a1 / 10 < 1 ? "0" : "").append(a1).append(":");
		int a2 = (answer % 3600) / 60;
		sb.append(a2 / 10 < 1 ? "0" : "").append(a2).append(":");
		int a3 = (answer % 3600) % 60;
		sb.append(a3 / 10 < 1 ? "0" : "").append(a3);
		System.out.println(sb);
	}
}