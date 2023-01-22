package cz.mendelu.ja.xvavrina.projekt3.Team;

import cz.mendelu.ja.xvavrina.projekt3.ResourceNotFoundException;
import cz.mendelu.ja.xvavrina.projekt3.User.User;
import cz.mendelu.ja.xvavrina.projekt3.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team findTeamById(String name){
        Team team = teamRepository.findById(name).orElseThrow(() -> new ResourceNotFoundException("Team with this name does not exist"));
        return team;
    }
    public Team createTeam(Team team) {
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

    public Team updateTeam(String name, Team teamBody){
        Team team = findTeamById(name);

        team.setName(teamBody.getName());
        team.setPlayers(teamBody.getPlayers());

        Team updatedTeam = teamRepository.save(team);

        return updatedTeam;
    }

    public void deleteTeam(String name){
        Team team = findTeamById(name);

        var players = team.getPlayers();
        for (User player : players) {
            if (player.getTeam() != null){
                player.setTeam(null);
                userRepository.save(player);
            }
        }
        teamRepository.delete(team);
    }
}
