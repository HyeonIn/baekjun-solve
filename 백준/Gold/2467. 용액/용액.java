import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int n = Integer.parseInt(br.readLine());
		 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = n-1;
		
		int min = Math.abs(arr[right] + arr[left]);
		int answerLeft = left;
		int answerRight = right;
		
		while (left < right) {
			if (Math.abs(right-left) == 1) {
				int now = Math.abs(arr[right] + arr[left]);
				if (now < min) {
					min = now;
					answerLeft = left;
					answerRight = right;
				}
				break;
			}
			int absLeft = Math.abs(arr[right] + arr[left+1]);
			int absRight = Math.abs(arr[right-1] + arr[left]);
			
			if (absLeft < absRight) {
				if (absLeft < min) {
					min = absLeft;
					answerLeft = left+1;
					answerRight = right;
				}
				left += 1;
			}
			else {
				if (absRight < min) {
					min = absRight;
					answerLeft = left;
					answerRight = right-1;
				}
				right -= 1;
			}
		}
		System.out.println(arr[answerLeft] + " " + arr[answerRight]);
	}
}