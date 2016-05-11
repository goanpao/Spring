package com.savio.ar.service.audit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savio.ar.model.audit.AuditEvent;
import com.savio.ar.model.audit.AuditMergeEvent;
import com.savio.ar.repository.audit.AuditEventESRepository;
import com.savio.ar.repository.audit.AuditMergeEventESRepository;

@Service
public class AuditEventService {

    @Autowired
    private AuditEventESRepository eventElasticSearchRepository;

    @Autowired
    private AuditMergeEventESRepository mergeEventElasticSearchRepository;
    
	public List<AuditEvent> findBySearchType(String searchType){
		return eventElasticSearchRepository.findBySearchType(searchType);
	}
	
	public List<AuditEvent> findBySearchUserName(String searchUserName) {
		return eventElasticSearchRepository.findBySearchUserName(searchUserName);
	}
	
	public List<AuditEvent> findByComponent(String component) {
		return eventElasticSearchRepository.findByComponent(component);
	}

	public void addEvent(AuditEvent event) {
		eventElasticSearchRepository.save(event);		
	}
	
	public void addMergeEvent(AuditMergeEvent mergeEvent) {
		mergeEventElasticSearchRepository.save(mergeEvent);		
	}	

}
