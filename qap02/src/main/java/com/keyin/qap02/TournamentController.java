package com.keyin.qap02;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// @RestController creates a Restful web application using Spring MVC
@RestController
public class TournamentController {

    // @Autowired (spring bean autowiring) sets relationships involving dependencies
    @Autowired
    TournamentRepo tournamentRepo;

    //Read
    // @GetMapping maps http GET requests to run a method when request succeedss
    @GetMapping("/tournament")
    // Using findAll(), return full list of Tournaments
    public List<Tournament> getAllTournaments() {
        return tournamentRepo.findAll();
    }
    //Read
    @GetMapping("/tournament/{id}")
    // @PathVariable assigns its value to the method indicated by {} above
    public Tournament getTournamentById(@PathVariable String id) {
        int tournyId = Integer.parseInt(id);
        return tournamentRepo.getReferenceById(tournyId);
    }

    //NOTE: Had issues with POST, me and Cam figured it was something missing in mySQL
    //      "Internal Server Error" mentioning I was missing table "qap02.tournament.seq"
    //      Didn't get to debug in time, GET/PUT/DELETE works fine.

    //Create
    // @PostMapping maps http POST requests...
    @PostMapping("/tournament")
    // @RequestBody basically allows the object to be created by filling out the json info in postman
    // ResponseEntity allows Spring to handle to backend work of the whole HTTP response.
    public ResponseEntity<Tournament> addTournament(@RequestBody Tournament tournament) {
        // added try/catch to make debugging/troubleshooting a few problems I ran into
        try {
            // creates tournament object
            Tournament _tournament = tournamentRepo.save(new Tournament(tournament.getLoc(), tournament.getStartDate(), tournament.getEndDate(), tournament.getEntryFee(), tournament.getPrizeAmt()));;
            return new ResponseEntity<>(_tournament, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }


    };

    //Delete
    @DeleteMapping("/tournament/{id}")
    public void deleteTournamentById(@PathVariable("id") int id){
        tournamentRepo.deleteById(id);
    }

    //Update -->
    @PutMapping("/tournament/{id}")
    public ResponseEntity<Tournament> updateTournament(@PathVariable("id") int id, @RequestBody Tournament tournament){
        Optional<Tournament> tournamentData = tournamentRepo.findById(id);
        if(tournamentData.isPresent()){
            Tournament _toUpdate = tournamentData.get();
//          add other fields for edit all data HERE...
//          _toUpdate.setId(tournament.getId());
            _toUpdate.setLoc(tournament.getLoc());
//            _toUpdate.setStartDate(tournament.getStartDate());
//            _toUpdate.setEndDate(tournament.getEndDate());
//            _toUpdate.setEntryFee(tournament.getEntryFee());
//            _toUpdate.setPrizeAmt(tournament.getPrizeAmt());
            return new ResponseEntity<>(tournamentRepo.save(_toUpdate), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
