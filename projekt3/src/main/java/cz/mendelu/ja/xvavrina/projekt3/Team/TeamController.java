package cz.mendelu.ja.xvavrina.projekt3.Team;

import cz.mendelu.ja.xvavrina.projekt3.ResourceNotFoundException;
import cz.mendelu.ja.xvavrina.projekt3.User.User;
import cz.mendelu.ja.xvavrina.projekt3.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    TeamService teamService;

    /**
     * endpoint for returning all teams
     *
     * @return all teams
     */
    @GetMapping("")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    /**
     * endpoint for returing one team found by name
     *
     * @param name
     * @return one found team
     */
    @GetMapping("/{name}")
    public ResponseEntity<Team> getTeamByName(@PathVariable String name) {
        return new ResponseEntity(teamService.findTeamById(name), HttpStatus.OK);
    }

    /**
     * endpoint for creating team and adding team to players
     *
     * @param team
     * @return new team
     */
    @PostMapping("/create")
    Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    /**
     * endpoint for changing teams name or players
     * @param name
     * @param teamBody
     * @return
     */
    @PutMapping("/{name}/update")
    public ResponseEntity<Team> updateTeam(@PathVariable String name, @RequestBody Team teamBody) {
        Team updatedTeam = teamService.updateTeam(name, teamBody);
        return new ResponseEntity(updatedTeam, HttpStatus.ACCEPTED);
    }

    /**
     * endpoint for deleting team and removing team from user
     * @param name
     * @return
     */
    @DeleteMapping("/{name}/delete")
    public ResponseEntity<Map<String, Boolean>> deleteTeam(@PathVariable String name) {
        teamService.deleteTeam(name);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Successfully deleted.", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
