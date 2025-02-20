package com.wipro.transport.controller;

import com.wipro.transport.entity.Transport;
import com.wipro.transport.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transport")
public class TransportController {

    @Autowired
    private TransportService transportService;

    @PostMapping
    public Transport createTransport(@RequestBody Transport transport) {
        return transportService.saveTransport(transport);
    }

    @GetMapping
    public List<Transport> getAllTransport() {
        return transportService.getAllTransport();
    }

    @GetMapping("/from/{source}/to/{destination}")
    public List<Transport> getTransportByRoute(@PathVariable String source, @PathVariable String destination) {
        return transportService.getTransportByRoute(source, destination);
    }

    @GetMapping("/cheapest/from/{source}/to/{destination}")
    public Transport getCheapestTransport(@PathVariable String source, @PathVariable String destination) {
        return transportService.getCheapestTransport(source, destination);
    }

    @PutMapping("/{id}")
    public Transport updateTransport(@PathVariable int id, @RequestBody Transport transport) {
        return transportService.updateTransport(id, transport);
    }

    @DeleteMapping("/{id}")
    public void deleteTransport(@PathVariable int id) {
        transportService.deleteTranspor(id);
    }
}
