import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {
	
	@DisplayName("패스워드를 초기화 한다.")
	@RepeatedTest(100)
	void passwordTest() {
		// Given
		User user = new User();
		
		// When
		user.initPassword();
		
		// Then
		assertThat(user.getPassword()).isNotNull();
	}
}