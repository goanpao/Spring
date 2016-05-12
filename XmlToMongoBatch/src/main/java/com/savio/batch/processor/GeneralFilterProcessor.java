package com.savio.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.savio.batch.model.General;

public class GeneralFilterProcessor implements ItemProcessor<General, General> {

	public General process(General general) throws Exception {
		return general;
	}
	
}
