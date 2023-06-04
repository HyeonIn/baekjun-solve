import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static class node {
		int num, left, right;
		public node(int num, int left, int right) {
			this.num = num;
			this.left = left;
			this.right = right;
		}
		
	}
	static node[] tree;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		tree = new node[n];
		
		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			int num = input[0] - 'A';
			int left = input[2] == '.' ? -1 : input[2] - 'A'; 
			int right = input[4] == '.' ? -1 : input[4] - 'A'; 
			tree[num] = new node(num, left, right);
		}
		preorder(0);
		System.out.println();
		inorder(0);
		System.out.println();
		postorder(0);
	}
	public static void preorder(int n) {
		System.out.print((char)(n+'A'));
		if (tree[n].left != -1) {
			preorder(tree[n].left);
		}
		if (tree[n].right != -1) {
			preorder(tree[n].right);
		}
	}
	public static void inorder(int n) {
		if (tree[n].left != -1) {
			inorder(tree[n].left);
		}
		System.out.print((char)(n+'A'));
		if (tree[n].right != -1) {
			inorder(tree[n].right);
		}
	}
	public static void postorder(int n) {
		if (tree[n].left != -1) {
			postorder(tree[n].left);
		}
		if (tree[n].right != -1) {
			postorder(tree[n].right);
		}
		System.out.print((char)(n+'A'));
	}
}