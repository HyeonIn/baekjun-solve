import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long X = Long.parseLong(st.nextToken());
		long Y = Long.parseLong(st.nextToken());
		long Z = (long)(Y * 100 / X);
		
		if (Z >= 99 || Y == X) {
			System.out.println(-1);
		}
		else {
			long next = Z + 1;
			long left = next * X;
			long right = 100 * Y;
			double a = (double)(left - right)/(double)(100-next);
			System.out.println((long)Math.ceil(a));
		}
		
	}
}