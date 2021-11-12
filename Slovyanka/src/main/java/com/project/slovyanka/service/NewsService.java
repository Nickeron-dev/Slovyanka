package com.project.slovyanka.service;

import com.project.slovyanka.entity.News;
import com.project.slovyanka.repository.NewsRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Illia Koshkin
 * Цей клас - сервіс, з яким можно взаємодіяти з базою даних у програмі(так краще).
 */
@AllArgsConstructor

@Service
public class NewsService {
    private NewsRepository repository;

    /**
     * Цей метод буде отримувати потрібну сторінку за запитом через Pageable
     * @param pageable об'єкт, куди передається номер сторінки
     * @return об'єкт сторінки новин
     */
    public Page<News> findCurrentPage(Pageable pageable) {
        return repository.findAllByOrderByIdDesc(pageable);
    }

    /**
     * Цей метод бере останні(за додаванням) 7 новин та передає їх у вигляді списку
     * @return список новин
     */
    public List<News> findLatestSevenNews() {
        return repository.findTop7ByOrderByIdDesc();
    }
}

