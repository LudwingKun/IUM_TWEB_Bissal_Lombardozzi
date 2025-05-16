package com.bissallombardozzi.springbootserver.Dto;

import org.springframework.data.domain.Page;

import java.util.List;

public class MoviePageDTO {
    private List<MovieDetails> content;
    private int page;
    private int totalPages;
    private long totalElements;

    public MoviePageDTO(Page<MovieDetails> pageData) {
        this.content = pageData.getContent();
        this.page = pageData.getNumber();
        this.totalPages = pageData.getTotalPages();
        this.totalElements = pageData.getTotalElements();
    }

    public List<MovieDetails> getContent() {
        return content;
    }

    public void setContent(List<MovieDetails> content) {
        this.content = content;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }
}
