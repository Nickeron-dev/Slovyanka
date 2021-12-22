package com.project.slovyanka.controller;

import com.project.slovyanka.entity.Role;
import com.project.slovyanka.view.TextsPaths;
import com.project.slovyanka.view.View;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor

@RestController
@RequestMapping("/")
public class ForStudentsPageController {
    @GetMapping("/for-students")
    public ModelAndView showForParentsPage(Model model) {
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

        return new ModelAndView("for_students");
    }

//    /**
//     * Цей метод змінює мову сайту на українську
//     * @return переадресовує на головну сторінку
//     */
//    @GetMapping(value = "/change-language", params = "ukr")
//    public RedirectView changeLanguageToUkr() {
//        View.view.changeLocale(Optional.of(new Locale(LocaleNames.UKR_LANGUAGE)));
//        return new RedirectView("/");
//    }
//
//    /**
//     * Цей метод змінює мову сайту на англійську
//     * @return переадресовує на головну сторінку
//     */
//    @GetMapping(value = "/change-language", params = "eng")
//    public RedirectView changeLanguageToEng() {
//        View.view.changeLocale(Optional.of(new Locale(LocaleNames.ENG_LANGUAGE)));
//        return new RedirectView("/");
//    }

}