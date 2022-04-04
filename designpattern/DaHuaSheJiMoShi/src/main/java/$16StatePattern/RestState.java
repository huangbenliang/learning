package $16StatePattern;

import java.text.MessageFormat;

public class RestState extends State {
	@Override
	public void writeProgram(Work work) {
		System.out.println(MessageFormat.format("当前时间{0}点 下班回家!", work.getHour()));
	}
}
