package com.savio.spring.processor;

import org.springframework.batch.item.ItemProcessor;

import com.savio.spring.model.DtlSection;

public class DtlSectionFilterProcessor implements ItemProcessor<DtlSection, DtlSection> {

	public DtlSection process(DtlSection section) throws Exception {
		return section;
	}

}
