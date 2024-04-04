package com.turing.api.common.component;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;

public class PageResultVo<DTO,EN> {

    private List<DTO> dtoList;
    private int totalPage,page,size,start,end;
    private boolean prev,next;
    private List<Integer> pageList;

    public PageResultVo(Page<EN> result, Function<EN,DTO> fn) {
    }
}
