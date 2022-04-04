package $16StatePattern;

import java.text.MessageFormat;

public class SleepingState extends State {
	@Override
	public void writeProgram(Work work) {
		System.out.println(MessageFormat.format("当前时间{0}点 不行了,睡着了!", work.getHour()));
	}
}
