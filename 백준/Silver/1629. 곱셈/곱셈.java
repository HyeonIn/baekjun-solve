import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int a, c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		System.out.println(exponentiation(b));
	}
	public static long exponentiation(long b) {
        if (b == 0) return 1;
        if (b % 2 == 1) {
            return (a * exponentiation(b - 1)) % c;
        }
        long k = exponentiation(b/2) % c;
        return (k * k) % c;
    }
}