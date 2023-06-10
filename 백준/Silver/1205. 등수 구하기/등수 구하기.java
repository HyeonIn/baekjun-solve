import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int newScore = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[p];
		for (int i = 0; i < p; i++) {
			arr[i] = -1;
		}
		int[] rankList = new int[p];
		if (n != 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
		}
		int rank = 0;
		int before = Integer.MAX_VALUE;
		int count = 1;
		int idx = -1;
		boolean flag = false;
		for (int i = 0; i < p; i++) {
			if (before > arr[i]) {
				rank += count;
				count = 1;
			}
			else {
				count++;
			}
			if (arr[i] < newScore) {
				flag = true;
				idx = i;
				break;
			}
			before = arr[i];
			rankList[i] = rank;
		}
		if (flag) {
			if (before == newScore) {
				System.out.println(rankList[idx-1]);
			}
			else {
				System.out.println(rank);
			}
		}
		else {
			if (n == 0) {
				System.out.println(1);
			}
			else {
				System.out.println(-1);
			}
		}
	}
}