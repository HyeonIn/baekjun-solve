import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String input = br.readLine();
		
		ArrayDeque<Character> stack = new ArrayDeque<>();
		char before = '(';
		int answer = 0;
		for (int i = 0; i < input.length(); i++) {
			char now = input.charAt(i);
			if (now == '(') {
				stack.add(input.charAt(i));
			}
			else {
				stack.pollLast();
				if (before == '(') {
					answer += stack.size();
				}
				else {
					answer += 1;
				}
			}
			before = now;
		}
		
		System.out.println(answer);
	}
}