package testExample;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

public class RandomPasswordGenerator implements MyPasswordGenerator {
	public static final String ALLOWED_SPL_CHARACTERS = "!@#$%^&*()_+";
	public static final String ERROR_CODE = "ERRONEOUS_SPECIAL_CHARS";
	
	@Override
	public String generatePassword() {
		PasswordGenerator passwordGenerator = new PasswordGenerator();
		
		CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
		CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
		lowerCaseRule.setNumberOfCharacters(2);
		
		CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
		CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
		upperCaseRule.setNumberOfCharacters(2);
		
		CharacterData digitChars = EnglishCharacterData.Digit;
		CharacterRule digitRule = new CharacterRule(digitChars);
		digitRule.setNumberOfCharacters(2);
		
		CharacterData specialChars = new CharacterData() {
			@Override
			public String getErrorCode() {
				return ERROR_CODE;
			}
			
			@Override
			public String getCharacters() {
				return ALLOWED_SPL_CHARACTERS;
			}
		};
		CharacterRule splCharRule = new CharacterRule(specialChars);
		splCharRule.setNumberOfCharacters(2);
		
		return passwordGenerator.generatePassword((int) (Math.random() * 12), splCharRule, lowerCaseRule, upperCaseRule, digitRule);
	}
}
