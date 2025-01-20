package com.residencial.app.application.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ResultPageWrapper<T> {
    List<T> pagesResult;
    private long totalItems;
    private long totalPages;
    private int currentPage;
}
