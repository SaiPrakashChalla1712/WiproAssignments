package com.wipro.transport.service;

import com.wipro.transport.entity.Transport;
import java.util.List;

public interface TransportService {
    Transport saveTransport(Transport transport);
    List<Transport> getAllTransport();
    List<Transport> getTransportByRoute(String source, String destination);
    Transport getCheapestTransport(String source, String destination);
    Transport updateTransport(int id, Transport transport);
    void deleteTranspor(int id);  // Ensure this matches exactly
}
