package com.wipro.transport.service;

import com.wipro.transport.entity.Transport;
import com.wipro.transport.repository.TransportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportServiceImpl implements TransportService {

    @Autowired
    private TransportRepository transportRepository;

    @Override
    public Transport saveTransport(Transport transport) {
        return transportRepository.save(transport);
    }

    @Override
    public List<Transport> getAllTransport() {
        return transportRepository.findAll();
    }

    @Override
    public List<Transport> getTransportByRoute(String source, String destination) {
        return transportRepository.findBySourceAndDestination(source, destination);
    }

    @Override
    public Transport getCheapestTransport(String source, String destination) {
        return transportRepository.findTopBySourceAndDestinationOrderByFareAsc(source, destination);
    }

    @Override
    public Transport updateTransport(int id, Transport transport) {
        Optional<Transport> existingTransport = transportRepository.findById(id);
        if (existingTransport.isPresent()) {
            Transport t = existingTransport.get();
            t.setType(transport.getType());
            t.setSource(transport.getSource());
            t.setDestination(transport.getDestination());
            t.setFare(transport.getFare());
            return transportRepository.save(t);
        }
        return null;
    }

    @Override
    public void deleteTranspor(int id) {  // Ensure this matches exactly
        transportRepository.deleteById(id);
    }
}
