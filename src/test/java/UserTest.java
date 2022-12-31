import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {
	
	@DisplayName("패스워드를 초기화 한다.")
	@RepeatedTest(100)
	void passwordTest() {
		// Given
		User user = new User();
		
		// When
		MyPasswordGenerator passwordGenerator = new CorrectPasswordGenerator();
		user.initPassword(passwordGenerator);
		
		// Then
		assertThat(user.getPassword()).isNotNull();
	}
	
	@DisplayName("패스워드가 요구사항에 부합하지 않아 초기화가 되지 않는다.")
	@RepeatedTest(100)
	void passwordTest2() {
		// Given
		User user = new User();
		
		// When
		MyPasswordGenerator passwordGenerator = new WrongPasswordGenerator();
		user.initPassword(passwordGenerator);
		
		// Then
		assertThat(user.getPassword()).isNull();
	}
}