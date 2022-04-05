package $25MediatorPattern;

public class Main {
	public static void main(String[] args) {
		UnitedNationsSecurityCouncil unitedNationsSecurityCouncil = new UnitedNationsSecurityCouncil();
		USA usa = new USA(unitedNationsSecurityCouncil);
		Iraq iraq = new Iraq(unitedNationsSecurityCouncil);
		unitedNationsSecurityCouncil.setUsa(usa);
		unitedNationsSecurityCouncil.setIraq(iraq);

		usa.declare("不准研制核武器，否则发动战争！");
		iraq.declare("我们没有核武器，也不怕侵略！");
	}
}


