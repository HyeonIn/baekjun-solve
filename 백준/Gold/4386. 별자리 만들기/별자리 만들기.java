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

import org.w3c.dom.Node;

public class Main {
	static class Point{
		int num;
		double x;
		double y;
		
		public Point(int num, double x, double y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}
	static class Edge implements Comparable<Edge>{
		int start, end;
		double weight;
		
		public Edge(int start, int end, double weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return o.weight > this.weight ? -1 : 1;
		}
		
	}
	static int[] parent;
	static PriorityQueue<Edge> edgeList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Point[] points = new Point[n];
		
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			points[i] = new Point(i, Float.parseFloat(st.nextToken()), Float.parseFloat(st.nextToken()));
		}
		
		edgeList = new PriorityQueue();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				double weight = getDist(points[i], points[j]);
				edgeList.add(new Edge(points[i].num, points[j].num, weight));
			}
		}
		
		parent = new int[n];
		
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		double ans = 0;
		
		while(!edgeList.isEmpty()) {
			Edge now = edgeList.poll();
			if (find(now.start) != find(now.end)) {
				ans += now.weight;
				union(now.start, now.end);
			}
		}
		System.out.println(ans);
	}
	public static double getDist(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}
	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x != y) {
			parent[y] = x;
		}
	}
}