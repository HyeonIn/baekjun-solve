import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int cnt = Integer.parseInt(br.readLine());
		boolean[] check = new boolean[10];
		if (cnt != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < cnt; i++) {
				check[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		
		if (cnt == 10) {
			System.out.println(Math.abs(n - 100));
			return;
		}
		int UpperCase = 1000000;
		int UpperCount = 0;
		for (int i = n+1; i <= 1000000; i++) {
			int copyN = i;
			boolean flag = false;
			int count = 0;
			while (copyN > 0) {
				int now = copyN % 10;
				
				if (check[now]) {
					flag = true;
					break;
				}
				
				copyN /= 10;
				count++;
			}
			if (!flag) {
				UpperCase = i;
				UpperCount = count;
				break;
			}
		}
		int DownCase = 5000000;
		int DownCount = 100;
		for (int i = n; i >= 0; i--) {
			int copyN = i;
			boolean flag = false;
			int count = 0;
			while (copyN > 0) {
				int now = copyN % 10;
				
				if (check[now]) {
					flag = true;
					break;
				}
				copyN /= 10;
				count++;
			}
			if (i == 0) {
				if (!check[0]) {
					DownCase = 0;
					DownCount = 1;
				}
				break;
			}
			if (!flag) {
				DownCase = i;
				DownCount = count;
				break;
			}
		}
		int UpperButtonPush = UpperCount + Math.abs(UpperCase - n);
		int DownButtonPush = DownCount + Math.abs(DownCase - n);
		int ButtonPush = Math.abs(n - 100);
		System.out.println(Math.min(ButtonPush, Math.min(UpperButtonPush, DownButtonPush)));
		
	}
}