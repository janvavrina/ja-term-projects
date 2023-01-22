package cz.mendelu.ja.xvavrina.projekt3.Tournament;

import cz.mendelu.ja.xvavrina.projekt3.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {
    @Autowired
    private TournamentService tournamentService;

    @GetMapping("")
    public List<Tournament> getAllTournaments(){
        return tournamentService.getAllTournaments();
    }

    /**
     * endpoint for returning one tournament by its ID
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Tournament> getTournamentById(@PathVariable Integer id){
        return ResponseEntity.ok(tournamentService.findTournamentById(id));
    }

    /**
     * create tournament
     * @param tournament
     * @return
     */
    Tournament createTournament(@RequestBody Tournament tournament){
        return tournamentService.createTournament(tournament);
    }

    public ResponseEntity<Tournament> updateTournament(@PathVariable Integer id, @RequestBody Tournament tournamentBody){
        Tournament updatedTournament = tournamentService.updateTournament(id, tournamentBody);
        return new ResponseEntity(updatedTournament,HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Map<String,Boolean>> deleteTournament(@PathVariable Integer id){
        tournamentService.deleteTournament(id);

        Map<String,Boolean> response = new HashMap<>();
        response.put("Successfully deleted.",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
