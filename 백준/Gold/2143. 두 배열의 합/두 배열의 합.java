import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		ArrayList<Integer> listA = new ArrayList<>();
		ArrayList<Integer> listB = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += a[j];
				listA.add(sum);
			}
		}
		
		for (int i = 0; i < m; i++) {
			int sum = 0;
			for (int j = i; j < m; j++) {
				sum += b[j];
				listB.add(sum);
			}
		}
		
		Collections.sort(listA);
		Collections.sort(listB);
		
		int pa = 0;
		int pb = listB.size() - 1;
		long cnt = 0;
		while (pa < listA.size() && pb >= 0) {
			long sum = listA.get(pa) + listB.get(pb);
			
			if (sum == T) {
				int checkA = listA.get(pa);
				int checkB = listB.get(pb);
				long aCnt = 0;
				long bCnt = 0;
				while (pa < listA.size() && listA.get(pa) == checkA) {
					aCnt++;
					pa++;
				}
				while (pb >= 0 && listB.get(pb) == checkB) {
					bCnt++;
					pb--;
				}
				
				cnt += aCnt * bCnt;
			}
			else if (sum < T) {
				pa++;
			}
			else {
				pb--;
			}
		}
		System.out.println(cnt);
	}
}