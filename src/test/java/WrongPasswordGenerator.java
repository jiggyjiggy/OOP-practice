public class WrongPasswordGenerator implements MyPasswordGenerator {
	
	@Override
	public String generatePassword() {
		return "123";
	}
}
