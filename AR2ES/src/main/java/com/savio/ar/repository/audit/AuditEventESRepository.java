package com.savio.ar.repository.audit;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.savio.ar.model.audit.AuditEvent;

public interface AuditEventESRepository extends ElasticsearchCrudRepository<AuditEvent, String> {

	public List<AuditEvent> findBySearchType(String searchType);
	public List<AuditEvent> findBySearchUserName(String searchUserName);
	public List<AuditEvent> findByComponent(String component);
}
