package cz.mendelu.ja.xvavrina;

@CustomComponent
public class UserServiceImpl implements UserService {
    @Override
    public String getUserName() {
        return "janvavrina";
    }
}
