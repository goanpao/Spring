package com.savio.ar.service.metric;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savio.ar.model.metric.IngestEvent;
import com.savio.ar.repository.metric.MetricsEventESRepository;

@Service
public class MetricsEventService {

    @Autowired
    private MetricsEventESRepository metricsEventESRepository;

    
    public List<IngestEvent> findByTypeOfRec(String typeOfRec) {
    	return metricsEventESRepository.findByTypeOfRec(typeOfRec);
    }
    
	public void addEvent(IngestEvent ingestEvent) {
		metricsEventESRepository.save(ingestEvent);		
	}
	

}
