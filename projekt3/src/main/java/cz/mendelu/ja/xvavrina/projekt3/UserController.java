package cz.mendelu.ja.xvavrina.projekt3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projekt3/v1/")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("users")
    public List<User> getAllUsers(){return userRepository.findAll();}
}
