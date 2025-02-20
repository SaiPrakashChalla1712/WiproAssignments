package com.wipro.transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wipro.transport.entity.Transport;
import java.util.List;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Integer> {  // Change Long to Integer
    List<Transport> findBySourceAndDestination(String source, String destination);
    Transport findTopBySourceAndDestinationOrderByFareAsc(String source, String destination);
}
