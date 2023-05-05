package com.joranbergfeld.airportsystem.flight;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getActiveFlights() {
        return flightRepository.findAllByActiveTrue();
    }

    public Flight findById(Long id) {
        return flightRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Flight not found with id " + id));
    }

    public Flight storeFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Long id, Flight updatedFlight) {
        return flightRepository.findById(id)
                .map(flight -> {
                    flight.setAirlinerId(updatedFlight.getAirlinerId());
                    flight.setGateId(updatedFlight.getGateId());
                    flight.setPlaneId(updatedFlight.getPlaneId());
                    flight.setPlaneAtGateTime(updatedFlight.getPlaneAtGateTime());
                    flight.setBoardingTime(updatedFlight.getBoardingTime());
                    flight.setTaxiTime(updatedFlight.getTaxiTime());
                    return flightRepository.save(flight);
                }).orElseThrow(() -> new ResourceNotFoundException("Flight not found with id " + id));
    }

    public Flight deleteFlight(Long id) {
        return flightRepository.findById(id)
                .map(flight -> {
                    flight.setActive(false);
                    return flightRepository.save(flight);
                }).orElseThrow(() -> new ResourceNotFoundException("Flight not found with id " + id));
    }
}
