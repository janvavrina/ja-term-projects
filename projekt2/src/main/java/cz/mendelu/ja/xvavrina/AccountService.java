package cz.mendelu.ja.xvavrina;

import java.util.UUID;

public interface AccountService {
    UUID getAccountNumber(String userName);
}
