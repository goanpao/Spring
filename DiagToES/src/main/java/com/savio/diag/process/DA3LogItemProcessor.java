package com.savio.diag.process;

import org.springframework.batch.item.ItemProcessor;

import com.savio.diag.model.DA3Log;

public class DA3LogItemProcessor implements ItemProcessor<DA3Log, DA3Log> {

    public DA3Log process(final DA3Log da3log) throws Exception {
        return da3log;
    }
}
