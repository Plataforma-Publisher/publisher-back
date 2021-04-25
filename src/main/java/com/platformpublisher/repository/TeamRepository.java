package com.platformpublisher.repository;

import com.platformpublisher.model.Team;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

   // List<Team> findByTeamDescriptionStartingWithIgnoreCase(String prefix);
}
