package com.fiftyfive.springboot.repositories;

import com.fiftyfive.springboot.entities.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDAO extends JpaRepository<WikimediaData, Long> {
}
