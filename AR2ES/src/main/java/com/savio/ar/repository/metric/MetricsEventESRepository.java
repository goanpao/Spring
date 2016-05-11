package com.savio.ar.repository.metric;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.savio.ar.model.metric.IngestEvent;

public interface MetricsEventESRepository extends ElasticsearchCrudRepository<IngestEvent, String> {

	public List<IngestEvent> findByTypeOfRec(String typeOfRec);
}
