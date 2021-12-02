package com.project.slovyanka.controller;

import com.project.slovyanka.entity.Role;
import com.project.slovyanka.service.NewsService;
import com.project.slovyanka.view.LocaleNames;
import com.project.slovyanka.view.TextsPaths;
import com.project.slovyanka.view.View;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Locale;
import java.util.Optional;

/**
 * @author Illia Koshkin
 * Цей контроллер опрацьовує всі основні запити у головній сторінці(відкриття основної сторінки та зміну мов)
 */
@AllArgsConstructor

@Controller
public class MainController {

    private NewsService newsService;

    /**
     * Цей метод обробляє запит відкриття головної сторінки
     * @param model цей об'єкт дає можливість передавати значення з backend(Java) до frontend(HTML)
     * @return відкриває HTML головної сторінки
     */
    @GetMapping("/")
    public String home(Model model) {
        SecurityContextHolder.getContext().getAuthentication().getAuthorities().forEach(System.out::println);
        try {
            Role role = (Role) SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0];
            model.addAttribute("login_logout", View.view.getBundleText(TextsPaths.HEADER_LOGOUT));
            model.addAttribute("login_logout_reference", View.view.getBundleText(TextsPaths.HEADER_LOGOUT_REFERENCE));

        } catch (ClassCastException exc) {
            model.addAttribute("login_logout", View.view.getBundleText(TextsPaths.HEADER_LOGIN));
            model.addAttribute("login_logout_reference", View.view.getBundleText(TextsPaths.HEADER_LOGIN_REFERENCE));
        }
        model.addAttribute("about", View.view.getBundleText(TextsPaths.ABOUT_GYMNASIUM));
        model.addAttribute("for_students", View.view.getBundleText(TextsPaths.FOR_STUDENTS));
        model.addAttribute("for_parents", View.view.getBundleText(TextsPaths.FOR_PARENTS));
        model.addAttribute("educational_activity", View.view.getBundleText(TextsPaths.EDUCATIONAL_ACTIVITY));
        model.addAttribute("project_activity", View.view.getBundleText(TextsPaths.PROJECT_ACTIVITY));
        model.addAttribute("unesco", View.view.getBundleText(TextsPaths.UNESCO));
        model.addAttribute("news", View.view.getBundleText(TextsPaths.NEWS));
        model.addAttribute("photo_gallery", View.view.getBundleText(TextsPaths.PHOTO_GALLERY));
        model.addAttribute("slavonic_gymnasium", View.view.getBundleText(TextsPaths.SLAVONIC_GYMNASIUM));
        model.addAttribute("entry_campaign", View.view.getBundleText(TextsPaths.ENTRY_CAMPAIGN));

        model.addAttribute("timetable", View.view.getBundleText(TextsPaths.TIMETABLE));
        model.addAttribute("quote_learning", View.view.getBundleText(TextsPaths.QUOTE_LEARNING));
        model.addAttribute("covid", View.view.getBundleText(TextsPaths.COVID));
        model.addAttribute("studying_during_quarantine", View.view.getBundleText(TextsPaths.STUDYING_DURING_QUARANTINE));
        model.addAttribute("get_student_id_first", View.view.getBundleText(TextsPaths.GET_STUDENT_ID_FIRST));
        model.addAttribute("get_student_id_second", View.view.getBundleText(TextsPaths.GET_STUDENT_ID_SECOND));
        model.addAttribute("web_portal_reference", View.view.getBundleText(TextsPaths.WEB_PORTAL_REFERENCE));
        model.addAttribute("online_zno", View.view.getBundleText(TextsPaths.ONLINE_ZNO));
        model.addAttribute("announcement", View.view.getBundleText(TextsPaths.ANNOUNCEMENT));
        model.addAttribute("latest_news", View.view.getBundleText(TextsPaths.LATEST_NEWS));
        model.addAttribute("more", View.view.getBundleText(TextsPaths.LATEST_NEWS_MORE));
        model.addAttribute("documents_by_reference", View.view.getBundleText(TextsPaths.DOCUMENTS_BY_REFERENCE));
        model.addAttribute("documents_by_reference_statute", View.view.getBundleText(TextsPaths.DOCUMENTS_BY_REFERENCE_STATUTE));
        model.addAttribute("documents_by_reference_development_strategy", View.view.getBundleText(TextsPaths.DOCUMENTS_BY_REFERENCE_DEVELOPMENT_STRATEGY));
        model.addAttribute("documents_by_reference_system_provision", View.view.getBundleText(TextsPaths.DOCUMENTS_BY_REFERENCE_SYSTEM_PROVISION));
        model.addAttribute("documents_by_reference_academical_provision", View.view.getBundleText(TextsPaths.DOCUMENTS_BY_REFERENCE_ACADEMICAL_PROVISION));
        model.addAttribute("documents_by_reference_evaluation", View.view.getBundleText(TextsPaths.DOCUMENTS_BY_REFERENCE_EVALUATION));
        model.addAttribute("educational_programs", View.view.getBundleText(TextsPaths.EDUCATIONAL_PROGRAMS));
        model.addAttribute("public_information", View.view.getBundleText(TextsPaths.PUBLIC_INFORMATION));
        model.addAttribute("public_information_request_title", View.view.getBundleText(TextsPaths.PUBLIC_INFORMATION_REQUEST_TITLE));
        model.addAttribute("public_information_request_button", View.view.getBundleText(TextsPaths.PUBLIC_INFORMATION_REQUEST_BUTTON));
        model.addAttribute("useful_links", View.view.getBundleText(TextsPaths.USEFUL_LINKS));
        model.addAttribute("useful_links_first_link", View.view.getBundleText(TextsPaths.USEFUL_LINKS_FIRST_LINK));
        model.addAttribute("useful_links_first_link_address", View.view.getBundleText(TextsPaths.USEFUL_LINKS_FIRST_LINK_ADDRESS));
        model.addAttribute("useful_links_second_link", View.view.getBundleText(TextsPaths.USEFUL_LINKS_SECOND_LINK));
        model.addAttribute("useful_links_second_link_address", View.view.getBundleText(TextsPaths.USEFUL_LINKS_SECOND_LINK_ADDRESS));
        model.addAttribute("useful_links_third_link", View.view.getBundleText(TextsPaths.USEFUL_LINKS_THIRD_LINK));
        model.addAttribute("useful_links_third_link_address", View.view.getBundleText(TextsPaths.USEFUL_LINKS_THIRD_LINK_ADDRESS));
        model.addAttribute("useful_links_fourth_link", View.view.getBundleText(TextsPaths.USEFUL_LINKS_FOURTH_LINK));
        model.addAttribute("useful_links_fourth_link_address", View.view.getBundleText(TextsPaths.USEFUL_LINKS_FOURTH_LINK_ADDRESS));
        model.addAttribute("useful_links_fifth_link", View.view.getBundleText(TextsPaths.USEFUL_LINKS_FIFTH_LINK));
        model.addAttribute("useful_links_fifth_link_address", View.view.getBundleText(TextsPaths.USEFUL_LINKS_FIFTH_LINK_ADDRESS));
        model.addAttribute("useful_links_sixth_link", View.view.getBundleText(TextsPaths.USEFUL_LINKS_SIXTH_LINK));
        model.addAttribute("useful_links_seventh_link", View.view.getBundleText(TextsPaths.USEFUL_LINKS_SEVENTH_LINK));
        model.addAttribute("useful_links_eighth_link", View.view.getBundleText(TextsPaths.USEFUL_LINKS_EIGHTH_LINK));
        model.addAttribute("useful_links_ninth_link", View.view.getBundleText(TextsPaths.USEFUL_LINKS_NINTH_LINK));
        model.addAttribute("contacts", View.view.getBundleText(TextsPaths.CONTACTS));
        model.addAttribute("first_lesson", View.view.getBundleText(TextsPaths.FIRST_LESSON));
        model.addAttribute("second_lesson", View.view.getBundleText(TextsPaths.SECOND_LESSON));
        model.addAttribute("third_lesson", View.view.getBundleText(TextsPaths.THIRD_LESSON));
        model.addAttribute("fourth_lesson", View.view.getBundleText(TextsPaths.FOURTH_LESSON));
        model.addAttribute("fifth_lesson", View.view.getBundleText(TextsPaths.FIFTH_LESSON));
        model.addAttribute("sixth_lesson", View.view.getBundleText(TextsPaths.SIXTH_LESSON));
        model.addAttribute("first_shift", View.view.getBundleText(TextsPaths.FIRST_SHIFT));
        model.addAttribute("second_shift", View.view.getBundleText(TextsPaths.SECOND_SHIFT));

        model.addAttribute("address_first", View.view.getBundleText(TextsPaths.ADDRESS_FIRST_TEXT));
        model.addAttribute("address_second", View.view.getBundleText(TextsPaths.ADDRESS_SECOND_TEXT));
        model.addAttribute("phone_fax", View.view.getBundleText(TextsPaths.PHONE_FAX));
        model.addAttribute("entrance_commission", View.view.getBundleText(TextsPaths.ENTRANCE_COMMISSION));
        model.addAttribute("head_teacher", View.view.getBundleText(TextsPaths.HEAD_TEACHER));
        model.addAttribute("information_document", View.view.getBundleText(TextsPaths.INFORMATION_DOCUMENT));
        model.addAttribute("download_pdf", View.view.getBundleText(TextsPaths.DOWNLOAD_INFORMATION_DOCUMENT));
        model.addAttribute("make_admission_request_message", View.view.getBundleText(TextsPaths.MAKE_ADMISSION_REQUEST_MESSAGE));
        model.addAttribute("make_request", View.view.getBundleText(TextsPaths.MAKE_REQUEST));
        model.addAttribute("contact_us", View.view.getBundleText(TextsPaths.CONTACT_US));

        model.addAttribute("current_language", View.view.getBundleText(TextsPaths.CURRENT_LANGUAGE));
        model.addAttribute("news_list", newsService.findLatestSevenNews());
        newsService.findLatestSevenNews().forEach((e) -> System.out.println(e.getTitleUkr()));

        return "index";
    }

    /**
     * Цей метод змінює мову сайту на українську
     * @return переадресовує на головну сторінку
     */
    @GetMapping(value = "/change-language", params = "ukr")
    public RedirectView changeLanguageToUkr() {
        View.view.changeLocale(Optional.of(new Locale(LocaleNames.UKR_LANGUAGE)));
        return new RedirectView("/");
    }

    /**
     * Цей метод змінює мову сайту на англійську
     * @return переадресовує на головну сторінку
     */
    @GetMapping(value = "/change-language", params = "eng")
    public RedirectView changeLanguageToEng() {
        View.view.changeLocale(Optional.of(new Locale(LocaleNames.ENG_LANGUAGE)));
        return new RedirectView("/");
    }

}
