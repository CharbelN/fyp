package com.example.eventfinder.repository;

import com.example.eventfinder.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
