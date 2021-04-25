package com.platformpublisher.service;

import com.platformpublisher.exception.BadRequestException;
import com.platformpublisher.model.Team;
import com.platformpublisher.repository.TeamRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Optional<Team> getTeamById(Long id) {

        verifyIfExists(id);

        return teamRepository.findById(id);

    }

    public Team updateTeam(Team team) {

        verifyIfExists(team.getId());

        return teamRepository.save(team);

    }

    public void deleteTeamById(Long id) {
        Team team = verifyIfExists(id);
        team.setTeamActive(false);
        teamRepository.save(team);

    }

    private Team verifyIfExists(Long id) throws BadRequestException {
        return teamRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("User with ID " + id + " not found"));
    }

}
