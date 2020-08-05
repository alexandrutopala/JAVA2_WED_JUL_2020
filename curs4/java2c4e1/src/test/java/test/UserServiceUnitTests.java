package test;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class UserServiceUnitTests {

    @Test
    public void GIVEN_no_args_WHEN_say_hello_THEN_print_hello_called() {
        UserRepo userRepo = Mockito.mock(UserRepo.class);

        UserService userService = new UserService(userRepo);

        userService.sayHello();

        Mockito.verify(userRepo, Mockito.times(1)).printHello();
    }
}
