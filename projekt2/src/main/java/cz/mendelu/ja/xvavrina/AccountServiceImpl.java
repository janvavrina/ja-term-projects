package cz.mendelu.ja.xvavrina;

import java.util.UUID;

@CustomComponent
public class AccountServiceImpl implements AccountService {
    @Override
    public UUID getAccountNumber(String userName) {
        return UUID.randomUUID();
    }
}
