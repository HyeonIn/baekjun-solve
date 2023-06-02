import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int m = Integer.parseInt(br.readLine());
		
		String s = br.readLine();
		
		int iterCount = 2*n+1;
		int countI = 0;
		int countO = 0;
		char last = ' ';
		
		int answer = 0;
		
		for (int i = 0; i < 2*n+1; i++) {
			if (i == 0) {
				iterCount -= 1;
				if (s.charAt(i) == 'O') {
					countO++;
				}
				else {
					countI++;
				}
				last = s.charAt(i);
			}
			else {
				if (s.charAt(i) == last) {
					iterCount = 2*n;
				}
				else {
					iterCount -= 1;
				}
				if (s.charAt(i) == 'O') {
					countO++;
				}
				else {
					countI++;
				}
				last = s.charAt(i);
			}
		}
		if (iterCount == 0) {
			if (countI > countO) {
				answer++;
			}
		}
		for (int i = 2*n+1; i < m; i++) {
			if (s.charAt(i-(2*n+1)) == 'I') {
				countI--;
			}
			else {
				countO--;
			}
			if (s.charAt(i) == last) {
				iterCount = 2*n;
			}
			else {
				if (iterCount != 0) {
					iterCount -= 1;
				}
			}
			if (s.charAt(i) == 'O') {
				countO++;
			}
			else {
				countI++;
			}
			last = s.charAt(i);
			if (iterCount == 0) {
				if (countI > countO) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}