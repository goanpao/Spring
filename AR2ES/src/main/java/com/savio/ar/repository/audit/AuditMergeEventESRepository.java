package com.savio.ar.repository.audit;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.savio.ar.model.audit.AuditMergeEvent;

public interface AuditMergeEventESRepository extends ElasticsearchCrudRepository<AuditMergeEvent, String> {

	public List<AuditMergeEvent> findBySearchType(String searchType);
	public List<AuditMergeEvent> findByIndexName(String indexName);

}
