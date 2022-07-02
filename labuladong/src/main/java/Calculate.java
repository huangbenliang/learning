import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Calculate {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int res= calculate(str, 0);

		System.out.println("res = " + res);
	}

	private static int calculate(String str, int start) {
		Stack<Integer> stk = new Stack<Integer>();
		int num = 0;
		char sign = '+';

		for (int i = start; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isDigit(c)) {
				num = num * 10 + (c - '0');

			}
			if (c == '(') {
				calculate(str, start + 1);
			}
			if (!Character.isDigit(c) || i == str.length() - 1) {
				int pop = 0;
				switch (sign) {
					case '+':
						stk.push(num);
						break;
					case '-':
						stk.push(-num);
						break;
					case '*':
						pop = stk.pop();
						stk.push(num * pop);
						break;

					case '/':
						pop = stk.pop();
						stk.push(pop / num);
						break;
				}
				sign = c;
				num = 0;
			}
			if (c == ')') break;
		}
		int res = 0;
		while (!stk.empty()) {
			res += stk.pop();
		}
		return res;
	}
}
