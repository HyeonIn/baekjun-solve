import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] result;
	static int target;
	static boolean[] check;
	static int count = 0;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] num = new int[4];
		
		for (int i = 0; i < 4; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		result = new int[4];
		target = clock(num);
		
		check = new boolean[10000];
		perm(0);
		
	}
	public static void perm(int idx) {
		if (idx == 4) {
			int now = clock(result);
			if (!check[now]) {
				count++;
				if (now == target) {
					System.out.println(count);
				}				
				check[now] = true;
			}
			return;
		}
		for (int i = 1; i <= 9; i++) {
			result[idx] = i;
			perm(idx+1);
		}
	}
	public static int clock(int[] arr) {
		int result = Integer.MAX_VALUE;
		for (int t = 0; t < 4; t++) {
			int temp = arr[0];
			for (int i = 0; i < 3; i++) {
				arr[i] = arr[i+1]; 
			}
			arr[3] = temp;
			int now = 0;
			int mul = 1;
			for (int i = 3; i >= 0; i--) {
				now += arr[i] * mul;
				mul*=10;
			}
			result = Math.min(result, now);
		}
		return result;
	}
}