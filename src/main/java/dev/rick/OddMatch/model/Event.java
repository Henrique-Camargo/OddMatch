package dev.rick.OddMatch.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime localDateTime;


}
