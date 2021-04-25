package com.platformpublisher.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 200, message = "Size must be between 1 and 200 characters")
    @Column(name = "team_description")
    @NotBlank
    private String teamDescription;

    @Column(name = "id_team_creator")
    private Long idTeamCreator;

    @Column(name = "team_active")
    private boolean teamActive = true;

    // Unir com as outras entidades e fazer o relacionamento
    //@JsonIgnore
    //@OneToMany(mappedBy = "team")
    //private List<User> users;
    // Unir com as outras entidades e fazer o relacionamento
    // @ManyToOne
    // @JoinColumn(name = "id_project", nullable = false)
    // private Project project;
}
