package cz.mendelu.ja.xvavrina.projekt3.Tournament;

import cz.mendelu.ja.xvavrina.projekt3.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {
    @Autowired
    private TournamentRepository tournamentRepository;

    @GetMapping("")
    public List<Tournament> getAllTournaments(){
        return tournamentRepository.findAll();
    }

    /**
     * endpoint for returning one tournament by its ID
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Tournament> getTournamentById(@PathVariable Integer id){
        Tournament tournament = tournamentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tournament with this ID does not exist."));
        return ResponseEntity.ok(tournament);
    }

    /**
     * create tournament
     * @param tournament
     * @return
     */
    Tournament createTournament(@RequestBody Tournament tournament){
        return tournamentRepository.save(tournament);
    }

    public ResponseEntity<Tournament> updateTournament(@PathVariable Integer id, @RequestBody Tournament tournamentBody){
        Tournament tournament = tournamentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tournament with this ID does not exist."));

        tournament.setDate(tournamentBody.getDate());
        tournament.setName(tournamentBody.getName());
        tournament.setDescription(tournamentBody.getDescription());
        tournament.setTeamSize(tournamentBody.getTeamSize());
        tournament.setLocation(tournamentBody.getLocation());

        Tournament updatedTournament = tournamentRepository.save(tournament);
        return ResponseEntity.ok(updatedTournament);
    }

    public ResponseEntity<Map<String,Boolean>> deleteTournament(@PathVariable Integer id){
        Tournament tournament = tournamentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tournament with this ID does not exist."));

        tournamentRepository.delete(tournament);

        Map<String,Boolean> response = new HashMap<>();
        response.put("Successfully deleted.",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
