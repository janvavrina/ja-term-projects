package cz.mendelu.ja.xvavrina.projekt3.Tournament;

import cz.mendelu.ja.xvavrina.projekt3.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TournamentService {
    @Autowired
    TournamentRepository tournamentRepository;

    List<Tournament> getAllTournaments(){
        return tournamentRepository.findAll();
    }

    Tournament findTournamentById(Integer id){
        Tournament tournament = tournamentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tournament with this ID does not exist."));
        return tournament;
    }

    Tournament createTournament(@RequestBody Tournament tournament){
        return tournamentRepository.save(tournament);
    }

    Tournament updateTournament(Integer id, @RequestBody Tournament tournamentBody){
        Tournament tournament = findTournamentById(id);

        tournament.setDate(tournamentBody.getDate());
        tournament.setName(tournamentBody.getName());
        tournament.setDescription(tournamentBody.getDescription());
        tournament.setTeamSize(tournamentBody.getTeamSize());
        tournament.setLocation(tournamentBody.getLocation());

        Tournament updatedTournament = tournamentRepository.save(tournament);

        return updatedTournament;
    }

    public void deleteTournament(Integer id){
        tournamentRepository.delete(findTournamentById(id));
    }
}
