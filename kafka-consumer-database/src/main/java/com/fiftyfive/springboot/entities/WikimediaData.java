package com.fiftyfive.springboot.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "wikimedia")
@Data
public class WikimediaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String wikiEventData;
}
