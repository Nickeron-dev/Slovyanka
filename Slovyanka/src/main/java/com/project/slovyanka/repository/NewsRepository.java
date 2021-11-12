package com.project.slovyanka.repository;

import com.project.slovyanka.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Illia Koshkin
 * Цей клас під'єднується до бази даних та взаємодіє з нею на низькому рівні.
 */
@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
    Page<News> findAllByOrderByIdDesc(Pageable pageable);
    List<News> findTop7ByOrderByIdDesc();
}
