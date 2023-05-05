package com.joranbergfeld.airportsystem.flight;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findAllByActiveTrue();
}
