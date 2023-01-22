package cz.mendelu.ja.xvavrina.projekt3.User;

import cz.mendelu.ja.xvavrina.projekt3.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /**
     * endpoint for returing all users
     * @return List of all users
     */
    @GetMapping("")
    public List<User> getAllUsers(){return userRepository.findAll();}

    /**
     * endpoint for returing one user found by ID
     * @param id
     * @return one found user
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByUUID(@PathVariable UUID id){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with this ID does not exist"));
        return ResponseEntity.ok(user);
    }

    /**
     * endpoint for creating new user
     * @param user
     * @return the new user
     */
    @PostMapping("/create")
    public User createUser(@RequestBody User user){return userRepository.save(user);}

    /**
     * endpoint for updating one user
     * @param id - which user to update
     * @param userBody - new values for the user
     * @return
     */
    @PutMapping("/{id}/update")
    public ResponseEntity<User> updateUser(@PathVariable UUID id, @RequestBody User userBody){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with this ID does not exist"));

        user.setFirstName(userBody.getFirstName());
        user.setLastName(userBody.getLastName());
        user.setEmail(userBody.getEmail());
        user.setUsername(userBody.getUsername());

        User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    /**
     * endpoint for deleting ONE user
     * @param id of desired user to be deleted
     * @return status code
     */
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Map<String,Boolean>> deleteUser(@PathVariable UUID id){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with this ID does not exist"));

        userRepository.delete(user);

        Map<String,Boolean> response = new HashMap<>();
        response.put("Successfully deleted.",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
