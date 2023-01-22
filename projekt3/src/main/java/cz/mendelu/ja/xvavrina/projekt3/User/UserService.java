package cz.mendelu.ja.xvavrina.projekt3.User;

import cz.mendelu.ja.xvavrina.projekt3.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User findUserById(UUID id){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with this ID does not exist"));
        return user;
    }

    public void deleteUser(UUID id){
        userRepository.delete(findUserById(id));
    }

    public User updateUser(UUID id, User userBody){
        User user = findUserById(id);

        user.setFirstName(userBody.getFirstName());
        user.setLastName(userBody.getLastName());
        user.setEmail(userBody.getEmail());
        user.setUsername(userBody.getUsername());

        User updatedUser = userRepository.save(user);

        return updatedUser;
    }

    public User createUser(@RequestBody User user){return userRepository.save(user);}

    public User getById(UUID id){
        return findUserById(id);
    }

    public List<User> getAllUsers(){return userRepository.findAll();}
}
