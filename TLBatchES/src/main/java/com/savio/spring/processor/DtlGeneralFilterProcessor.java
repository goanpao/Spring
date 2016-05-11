package com.savio.spring.processor;

import org.springframework.batch.item.ItemProcessor;

import com.savio.spring.model.DtlGeneral;

public class DtlGeneralFilterProcessor implements
		ItemProcessor<DtlGeneral, DtlGeneral> {

	public DtlGeneral process(DtlGeneral general) throws Exception {
		return general;
	}

}
