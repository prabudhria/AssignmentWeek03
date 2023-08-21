package com.ria.springweb.respos;

import com.ria.springweb.entities.Bird;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirdRepository extends JpaRepository<Bird, Integer> {
}
