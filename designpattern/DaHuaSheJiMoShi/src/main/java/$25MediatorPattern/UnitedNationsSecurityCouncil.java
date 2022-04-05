package $25MediatorPattern;

import lombok.Setter;

@Setter
public class UnitedNationsSecurityCouncil extends UnitedNations {
	private USA usa;
	private Iraq iraq;

	@Override
	public void declare(String message, Country country) {
		if (country == usa) {
			iraq.getMessage(message);
		} else {
			usa.getMessage(message);
		}
	}
}
