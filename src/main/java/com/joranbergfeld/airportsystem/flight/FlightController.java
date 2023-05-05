package com.joranbergfeld.airportsystem.flight;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getActiveFlights();
    }

    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable("id") Long id) {
        return flightService.findById(id);
    }

    @PostMapping
    public Flight createFlight(@Valid @RequestBody Flight flight) {
        return flightService.storeFlight(flight);
    }

    @PutMapping("/{id}")
    public Flight updateFlight(@PathVariable("id") Long id, @Valid @RequestBody Flight updatedFlight) {
        return flightService.updateFlight(id, updatedFlight);
    }

    @DeleteMapping("/{id}")
    public Flight deleteFlight(@PathVariable("id") Long id) {
        return flightService.deleteFlight(id);
    }
}
