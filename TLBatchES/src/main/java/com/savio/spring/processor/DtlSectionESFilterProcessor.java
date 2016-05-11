package com.savio.spring.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;

import com.savio.spring.model.DtlSection;

public class DtlSectionESFilterProcessor implements ItemProcessor<DtlSection, IndexQuery> {
	
	public IndexQuery process(DtlSection section) throws Exception {

		IndexQueryBuilder builder = new IndexQueryBuilder();
		builder.withObject(section);
		builder.withIndexName("policy");
		builder.withType("section");
		return builder.build();
	}

}
