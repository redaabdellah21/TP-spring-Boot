package fr.sorbonne.paris.nord.university.api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

import javax.persistence.*;
@Data
@Entity
@Table(name="player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    private String number;
    private String position;
    @ManyToOne
    @JoinColumn(name="team_id",nullable = false)
    private Team team;


}