package cz.mendelu.ja.xvavrina;


import java.util.UUID;

/**
 * Client class, havin userService and accountService expected to initialized by
 * CustomInjector.java
 */
@CustomComponent
public class ClientApplication {
    @CustomAutowired
    @CustomQualifier(value = "UserServiceImpl")
    private UserService userService;

    @CustomAutowired
    @CustomQualifier(value = "AccountServiceImpl")
    private AccountService accountService;

    public void displayUserAccount() {
        String username = userService.getUserName();
        UUID accountNumber = accountService.getAccountNumber(username);
        System.out.println("\nUser Name: " + username + " Account Number: " + accountNumber);
    }
}
