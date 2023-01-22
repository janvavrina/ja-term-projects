package cz.mendelu.ja.xvavrina.projekt3.User

import org.junit.Test
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import spock.lang.Specification
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    @DisplayName("Test findUserById success")
    void "FindUserById"() {
        // given
        UUID uuid = 1l;
        User user = new User(uuid,"ss","ss","ss@ss.cz","ssss",null);
        doReturn(Optional.of(User)).when(userRepository).findById(uuid);

        // when
        Optional<User> returnedUser = userService.findUserById(uuid);

        //then
        Assertions.assertTrue(returnedUser.isPresent(),"User was not found.");
        Assertions.assertSame(returnedUser.get(), user, "Did NOT return same objects")
    }

    void "DeleteUser"() {
        // given

        // when

        //then

    }

    void "UpdateUser"() {
        // given

        // when

        //then

    }

    void "CreateUser"() {
        // given

        // when

        //then

    }

    void "GetById"() {
        // given

        // when

        //then

    }

    void "GetAllUsers"() {
        // given

        // when

        //then

    }
}
