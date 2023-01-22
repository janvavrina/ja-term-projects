package cz.mendelu.ja.xvavrina.projekt3.Team;

import cz.mendelu.ja.xvavrina.projekt3.ResourceNotFoundException;
import cz.mendelu.ja.xvavrina.projekt3.User.User;
import cz.mendelu.ja.xvavrina.projekt3.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * endpoint for returning all teams
     *
     * @return all teams
     */
    @GetMapping("")
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    /**
     * endpoint for returing one team found by name
     *
     * @param name
     * @return one found team
     */
    @GetMapping("/{name}")
    public ResponseEntity<Team> getTeamByName(@PathVariable String name) {
        Team team = teamRepository.findById(name).orElseThrow(() -> new ResourceNotFoundException("Team with this name does not exist"));
        return ResponseEntity.ok(team);
    }

    /**
     * endpoint for creating team and adding team to players
     *
     * @param team
     * @return new team
     */
    @PostMapping("/create")
    Team createTeam(@RequestBody Team team) {
        team.setName(team.getName().replace(' ', '-'));
        teamRepository.save(team);
        var players = team.getPlayers();
        for (User player : players) {
            if (player.getTeam() == null) {
                var user = userRepository.findById(player.getId());
                if (user.isPresent()) {
                    user.get().setTeam(team);
                    userRepository.save(user.get());
                }
            }
        }
        return team;
    }

    /**
     * endpoint for changing teams name or players
     * @param name
     * @param teamBody
     * @return
     */
    @PutMapping("/{name}/update")
    public ResponseEntity<Team> updateTeam(@PathVariable String name, @RequestBody Team teamBody) {
        Team team = teamRepository.findById(name).orElseThrow(() -> new ResourceNotFoundException("Team with this name does not exist."));

        team.setName(teamBody.getName());
        team.setPlayers(teamBody.getPlayers());

        Team updatedTeam = teamRepository.save(team);
        return ResponseEntity.ok(updatedTeam);
    }

    /**
     * endpoint for deleting team and removing team from user
     * @param name
     * @return
     */
    @DeleteMapping("/{name}/delete")
    public ResponseEntity<Map<String, Boolean>> deleteTeam(@PathVariable String name) {
        Team team = teamRepository.findById(name).orElseThrow(() -> new ResourceNotFoundException("Team with this name does not exist."));

        var players = team.getPlayers();
        for (User player : players) {
            if (player.getTeam() != null){
                player.setTeam(null);
                userRepository.save(player);
            }
        }

        teamRepository.delete(team);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Successfully deleted.", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
