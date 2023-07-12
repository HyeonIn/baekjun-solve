import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		while (true) {
			int temp = Integer.parseInt(br.readLine());
			
			if (temp == 0) {
				break;
			}
			
			sb.append(temp).append(" is ");
			sb.append(temp % n == 0 ? "" : "NOT ");
			sb.append("a multiple of ").append(n).append(".\n");
		}
		System.out.println(sb);
	}
}