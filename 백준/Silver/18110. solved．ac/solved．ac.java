import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] diff = new int[n];
		for (int i = 0; i < n; i++) {
			diff[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(diff);
		
		int result = 0;
		float del = n * 0.15f;
		int countDel = Math.round(del);
		for (int i = countDel; i < n-countDel; i++) {
			result += diff[i];
		}
		float avg = (float)result / (n- (countDel*2));
		System.out.println(Math.round(avg));
	}
}