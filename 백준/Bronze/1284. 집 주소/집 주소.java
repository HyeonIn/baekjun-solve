import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while (true) {
			String now = br.readLine();
			
			if (now.equals("0")) {
				break;
			}
			int answer = 0;
			answer += now.length() + 1;
			for (int i = 0; i < now.length(); i++) {
				if (now.charAt(i) == '1') {
					answer += 2;
				}
				else if (now.charAt(i) == '0') {
					answer += 4;
				}
				else {
					answer += 3;
				}
			}
			
			sb.append(answer).append('\n');
		}
		System.out.println(sb);
	}
}