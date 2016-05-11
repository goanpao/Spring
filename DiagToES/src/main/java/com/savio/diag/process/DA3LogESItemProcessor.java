package com.savio.diag.process;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;

import com.savio.diag.model.DA3Log;

public class DA3LogESItemProcessor implements ItemProcessor<DA3Log, IndexQuery> {

	public IndexQuery process(DA3Log da3log) throws Exception {

		IndexQueryBuilder builder = new IndexQueryBuilder();
		builder.withObject(da3log);
		builder.withIndexName("dadiag");
		builder.withType("da3log");
		return builder.build();
	}

}
