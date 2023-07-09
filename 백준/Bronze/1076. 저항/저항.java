import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] color = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
		
		long answer = 0;
		for (int i = 0; i < 2; i++) {
			String val = br.readLine();
			for (int j = 0; j < color.length; j++) {
				if (val.equals(color[j])) {
					answer += j * Math.pow(10, 1-i);
					break;
				}
			}
			
		}
		String mul = br.readLine();
		for (int i = 0; i < color.length; i++) {
			if (mul.equals(color[i])) {
				answer *= Math.pow(10, i);
			}
		}
		System.out.println(answer);
	}
}