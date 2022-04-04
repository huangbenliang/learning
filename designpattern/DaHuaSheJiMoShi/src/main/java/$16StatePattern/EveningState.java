package $16StatePattern;

import java.text.MessageFormat;

public class EveningState extends State {
	@Override
	public void writeProgram(Work work) {
		if (work.isFinish()) {
			work.setCurrent(new RestState());
			work.writeProgram();
		} else {
			if (work.getHour() < 21) {
				System.out.println(MessageFormat.format("当前时间{0}点 加班哦,疲累之极!", work.getHour()));
			} else {
				work.setCurrent(new SleepingState());
				work.writeProgram();
			}
		}
	}
}
