package com.platformpublisher.resource;

import com.platformpublisher.model.Team;
import com.platformpublisher.repository.TeamRepository;
import com.platformpublisher.service.TeamService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamResource {

    @Autowired
    TeamRepository teamRepository;
    @Autowired
    TeamService teamService;

    @GetMapping("/{teamId}")
    public ResponseEntity<Optional<Team>> getTeam(@PathVariable Long teamId) {
        Optional<Team> team = teamService.getTeamById(teamId);
        return ResponseEntity.ok(team);
    }

//    @GetMapping("/search/{prefix}")
//    public ResponseEntity<List<Team>> getTeamDescription(@PathVariable String prefix) {
//
//        List<Team> team = teamRepository.findByTeamDescriptionStartingWithIgnoreCase(prefix);
//        return ResponseEntity.ok(team);
//    }
    @PostMapping
    public ResponseEntity<Team> saveTeam(@Valid @RequestBody Team team) {

        Team savedTeam = teamRepository.save(team);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTeam);
    }

    @DeleteMapping("/{teamId}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long teamId) {
        teamService.deleteTeamById(teamId);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{teamId}")
    public ResponseEntity<Team> updateTeam(@PathVariable Long teamId,
            @Valid @RequestBody Team team) {
        team.setId(teamId);
        Team savedTeam = teamService.updateTeam(team);
        return ResponseEntity.ok(savedTeam);
    }

}
