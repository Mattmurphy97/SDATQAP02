package com.keyin.qap02;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TournamentRepo extends JpaRepository<Tournament, Integer> {

    List<Tournament> findAll();


    List<Tournament> findByLoc(String loc);
}

