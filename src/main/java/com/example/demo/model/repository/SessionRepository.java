package com.example.demo.model.repository;

import com.example.demo.model.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    Optional<Session> findSessionByIdSession(Long idSession);

    List<Session> findByCinema(Cinema cinema);
    List<Session> findByMovie(Movie movie);

//    List<Session> findByHall(Hall hall);

    Optional<Session>  findSessionByHallAndStartSession(Hall hall, String startSession);
}
