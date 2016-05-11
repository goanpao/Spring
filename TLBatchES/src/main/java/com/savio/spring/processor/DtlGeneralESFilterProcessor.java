package com.savio.spring.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;

import com.savio.spring.model.DtlGeneral;

public class DtlGeneralESFilterProcessor implements
		ItemProcessor<DtlGeneral, IndexQuery> {

	public IndexQuery process(DtlGeneral general) throws Exception {

		IndexQueryBuilder builder = new IndexQueryBuilder();
		builder.withObject(general);
		builder.withIndexName("policy");
		builder.withType("general");
		return builder.build();
	}

}
