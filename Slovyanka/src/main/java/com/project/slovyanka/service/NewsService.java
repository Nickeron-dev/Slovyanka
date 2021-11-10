package com.project.slovyanka.service;

import com.project.slovyanka.entity.News;
import com.project.slovyanka.repository.NewsRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor

@Service
public class NewsService {
    private NewsRepository repository;

    public Page<News> findCurrentPage(Pageable pageable) {
        return repository.findAllByOrderByIdDesc(pageable);
    }
    public List<News> findLatestSevenNews() {
        return repository.findTop7ByOrderByIdDesc();
    }
}

