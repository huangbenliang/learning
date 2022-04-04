package $16StatePattern;

import java.text.MessageFormat;

public class AfternoonState extends State {
	@Override
	public void writeProgram(Work work) {
		if (work.getHour() < 17) {
			System.out.println(MessageFormat.format("当前时间{0}点,下午状态还不错,继续努力!", work.getHour()));
		} else {
			work.setCurrent(new EveningState());
			work.writeProgram();
		}
	}
}
