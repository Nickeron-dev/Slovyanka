package com.project.slovyanka.controller;

import com.project.slovyanka.entity.News;
import com.project.slovyanka.service.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Illia Koshkin
 * Цей контролер опрацьовує усі запити, які пов'язані зі сторінкою новин
 */
@AllArgsConstructor

@RestController
@RequestMapping("/")
@ResponseBody
public class NewsPageController {

    private final NewsService newsService;

    /**
     * Цей метод розкриває головну сторінку новин(на першій сторінці новин з бази даних)
     * @param model об'єкт, що дає можливість передати новини до HTML
     * @param pageable об'єкт, що дає можливість обрати сторінку
     * @return сторінку з переданими у неї аргументами
     */
    @GetMapping("/news")
    public ModelAndView newsPage(Model model, Pageable pageable) {
        Page<News> currentPage = newsService.findCurrentPage(pageable);
        model.addAttribute("current_page", currentPage);
        model.addAttribute("pages_number", currentPage.getTotalPages());
        return new ModelAndView("newsPage");
    }

    /**
     * Цей метод опрацьовує зміну сторінки новин
     * @param model об'єкт, що дає можливість передати новини до HTML
     * @param pageable об'єкт, що дає можливість обрати сторінку
     * @param number номер обраної сторінки(взято з натиснутої кнопки)
     * @return сторінку з переданими у неї аргументами
     */
    @GetMapping("/news/change-page")
    public ModelAndView changeNewsPage(Model model, Pageable pageable, @RequestParam(value = "number") Integer number) {
        Page<News> currentPage = newsService.findCurrentPage(pageable.withPage(number - 1));
        model.addAttribute("current_page", currentPage);
        model.addAttribute("pages_number", currentPage.getTotalPages());
        return new ModelAndView("newsPage");
    }
}
