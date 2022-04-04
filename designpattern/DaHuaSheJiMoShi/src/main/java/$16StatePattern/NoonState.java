package $16StatePattern;

import java.text.MessageFormat;

public class NoonState extends State {
	@Override
	public void writeProgram(Work work) {
		if (work.getHour() < 13) {
			System.out.println(MessageFormat.format("当前时间{0}点,饿了,午饭!犯困,午休", work.getHour()));
		} else {
			work.setCurrent(new AfternoonState());
			work.writeProgram();
		}
	}
}
