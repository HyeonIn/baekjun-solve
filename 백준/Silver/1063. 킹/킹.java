import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
	static class coord{
		int r, c;
		public coord(int r, int c) {
			this.r = r;
			this.c = c;
		}
		public boolean equal(coord o) {
			return o.c == this.c && o.r == this.r ? true : false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String kingLocation = st.nextToken();
		String stoneLocation = st.nextToken();
		int n = Integer.parseInt(st.nextToken());
		
		HashMap<String, coord> dir = new HashMap<>();
		
		dir.put("R", new coord(0, 1));
		dir.put("L", new coord(0, -1));
		dir.put("B", new coord(1, 0));
		dir.put("T", new coord(-1, 0));
		dir.put("RT", new coord(-1, 1));
		dir.put("LT", new coord(-1, -1));
		dir.put("RB", new coord(1, 1));
		dir.put("LB", new coord(1, -1));
		
		coord king = new coord('8' - kingLocation.charAt(1), kingLocation.charAt(0) - 'A');
		coord stone = new coord('8' - stoneLocation.charAt(1), stoneLocation.charAt(0) - 'A');
		
		for (int i = 0; i < n; i++) {
			String cmd = br.readLine();
			coord next = new coord(king.r + dir.get(cmd).r, king.c + dir.get(cmd).c);
			if (next.r < 0 || next.c < 0 || next.r >= 8 || next.c >= 8) {
				continue;
			}
			if (stone.equal(next)) {
				coord nextStone = new coord(stone.r + dir.get(cmd).r, stone.c + dir.get(cmd).c);
				if (nextStone.r < 0 || nextStone.c < 0 || nextStone.c >= 8 || nextStone.r >= 8) {
					continue;
				}
				stone = nextStone;
			}
			king = next;
		}
		System.out.print((char)('A' + king.c));
		System.out.println((char)('8' - king.r));
		System.out.print((char)('A' + stone.c));
		System.out.println((char)('8' - stone.r));
	}
}