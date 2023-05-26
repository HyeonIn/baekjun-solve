import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		if (n == 0) {
			System.out.println(0);
		}
		else {
			int mul = 1;
			int answer = 0;
			for (int i = 1; i <= n; i++) {
				mul *= i;
				while (mul % 10 == 0) {
					answer += 1;
					mul /= 10;
				}
				mul = mul % 1000;
			}
			System.out.println(answer);
		}
	}
}