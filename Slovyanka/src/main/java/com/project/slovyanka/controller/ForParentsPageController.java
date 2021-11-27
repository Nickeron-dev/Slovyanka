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
public class ForParentsPageController {
    @GetMapping("/for-parents")
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





        model.addAttribute("rules_of_application", View.view.getBundleText(TextsPaths.RULES_OF_APPLICATION));
        model.addAttribute("rules_of_application_to_gymnasium", View.view.getBundleText(TextsPaths.RULES_OF_APPLICATION_TO_GYMNASIUM));
        model.addAttribute("information_about_free_places", View.view.getBundleText(TextsPaths.INFORMATION_ABOUT_FREE_PLACES));
        model.addAttribute("psychological_service", View.view.getBundleText(TextsPaths.PSYCHOLOGICAL_SERVICE));
        model.addAttribute("psychological_service_degree", View.view.getBundleText(TextsPaths.PSYCHOLOGICAL_SERVICE_DEGREE));
        model.addAttribute("psychological_service_additional", View.view.getBundleText(TextsPaths.PSYCHOLOGICAL_SERVICE_ADDITIONAL));
        model.addAttribute("psychological_service_employee_one_name", View.view.getBundleText(TextsPaths.PSYCHOLOGICAL_SERVICE_EMPLOYEE_ONE_NAME));
        model.addAttribute("psychological_service_position", View.view.getBundleText(TextsPaths.PSYCHOLOGICAL_SERVICE_POSITION));
        model.addAttribute("psychological_service_employee_one_position", View.view.getBundleText(TextsPaths.PSYCHOLOGICAL_SERVICE_EMPLOYEE_ONE_POSITION));
        model.addAttribute("psychological_service_level", View.view.getBundleText(TextsPaths.PSYCHOLOGICAL_SERVICE_LEVEL));
        model.addAttribute("psychological_service_employee_one_category", View.view.getBundleText(TextsPaths.PSYCHOLOGICAL_SERVICE_EMPLOYEE_ONE_CATEGORY));
        model.addAttribute("psychological_service_experience", View.view.getBundleText(TextsPaths.PSYCHOLOGICAL_SERVICE_EXPERIENCE));
        model.addAttribute("psychological_service_employee_one_years", View.view.getBundleText(TextsPaths.PSYCHOLOGICAL_SERVICE_EMPLOYEE_ONE_YEARS));
        model.addAttribute("psychological_service_employee_one_degree", View.view.getBundleText(TextsPaths.PSYCHOLOGICAL_SERVICE_EMPLOYEE_ONE_DEGREE));
        model.addAttribute("psychological_service_employee_one_qualification_improvement", View.view.getBundleText(TextsPaths.PSYCHOLOGICAL_SERVICE_EMPLOYEE_ONE_QUALIFICATION_IMPROVER));
        model.addAttribute("psychological_service_employee_two_name", View.view.getBundleText(TextsPaths.PSYCHOLOGICAL_SERVICE_EMPLOYEE_TWO_NAME));
        model.addAttribute("psychological_service_employee_two_position", View.view.getBundleText(TextsPaths.PSYCHOLOGICAL_SERVICE_EMPLOYEE_TWO_POSITION));
        model.addAttribute("psychological_service_employee_two_category", View.view.getBundleText(TextsPaths.PSYCHOLOGICAL_SERVICE_EMPLOYEE_TWO_CATEGORY));
        model.addAttribute("psychological_service_employee_two_years", View.view.getBundleText(TextsPaths.PSYCHOLOGICAL_SERVICE_EMPLOYEE_TWO_YEARS));
        model.addAttribute("psychological_service_employee_two_degree", View.view.getBundleText(TextsPaths.PSYCHOLOGICAL_SERVICE_EMPLOYEE_TWO_DEGREE));
        model.addAttribute("psychological_service_employee_two_qualification_improvement", View.view.getBundleText(TextsPaths.PSYCHOLOGICAL_SERVICE_EMPLOYEE_TWO_QUALIFICATION_IMPROVER));
        model.addAttribute("psychological_service_employee_three_name", View.view.getBundleText(TextsPaths.PSYCHOLOGICAL_SERVICE_EMPLOYEE_THREE_NAME));
        model.addAttribute("psychological_service_employee_three_position", View.view.getBundleText(TextsPaths.PSYCHOLOGICAL_SERVICE_EMPLOYEE_THREE_POSITION));
        model.addAttribute("psychological_service_employee_three_category", View.view.getBundleText(TextsPaths.PSYCHOLOGICAL_SERVICE_EMPLOYEE_THREE_CATEGORY));
        model.addAttribute("psychological_service_employee_three_years", View.view.getBundleText(TextsPaths.PSYCHOLOGICAL_SERVICE_EMPLOYEE_THREE_YEARS));
        model.addAttribute("psychological_service_employee_three_degree", View.view.getBundleText(TextsPaths.PSYCHOLOGICAL_SERVICE_EMPLOYEE_THREE_DEGREE));
        model.addAttribute("psychological_service_employee_three_qualification_improvement", View.view.getBundleText(TextsPaths.PSYCHOLOGICAL_SERVICE_EMPLOYEE_THREE_QUALIFICATION_IMPROVER));
        model.addAttribute("useful_posts", View.view.getBundleText(TextsPaths.USEFUL_POSTS));
        model.addAttribute("useful_posts_psychologists_thought", View.view.getBundleText(TextsPaths.USEFUL_POSTS_PSYCHOLOGISTS_THOUGHT));
        model.addAttribute("useful_posts_attention_methods", View.view.getBundleText(TextsPaths.USEFUL_POSTS_ATTENTION_METHODS));
        model.addAttribute("useful_posts_hyperactive_child", View.view.getBundleText(TextsPaths.USEFUL_POSTS_HYPERACTIVE_CHILD));
        model.addAttribute("useful_posts_how_to_improve_attention", View.view.getBundleText(TextsPaths.USEFUL_POSTS_HOW_TO_IMPROVE_ATTENTION));
        model.addAttribute("useful_posts_michele_borba", View.view.getBundleText(TextsPaths.USEFUL_POSTS_MICHELE_BORBA));
        model.addAttribute("useful_posts_hours_for_homework", View.view.getBundleText(TextsPaths.USEFUL_POSTS_HOURS_FOR_HOMEWORK));
        model.addAttribute("useful_posts_how_to_understand_that_your_child_has_burned_out", View.view.getBundleText(TextsPaths.USEFUL_POSTS_HOW_TO_UNDERSTAND_THAT_YOUR_CHILD_HAS_BURNED_OUT));
        model.addAttribute("useful_posts_ready_for_school", View.view.getBundleText(TextsPaths.USEFUL_POSTS_READY_FOR_SCHOOL));
        model.addAttribute("useful_posts_workshop_for_parents", View.view.getBundleText(TextsPaths.USEFUL_POSTS_WORKSHOP_FOR_PARENTS));
        model.addAttribute("useful_posts_energy_saving_manual", View.view.getBundleText(TextsPaths.USEFUL_POSTS_ENERGY_SAVING_MANUAL));
        model.addAttribute("useful_posts_dangerous_conditions_manual", View.view.getBundleText(TextsPaths.USEFUL_POSTS_DANGEROUS_CONDITIONS_MANUAL));
        model.addAttribute("useful_posts_cybersecurity_for_children", View.view.getBundleText(TextsPaths.USEFUL_POSTS_CYBERSECURITY_FOR_CHILDREN));
        model.addAttribute("useful_posts_how_to_teach_safety", View.view.getBundleText(TextsPaths.USEFUL_POSTS_HOW_TO_TEACH_SAFETY));
        model.addAttribute("monitoring", View.view.getBundleText(TextsPaths.MONITORING));
        model.addAttribute("monitoring_message", View.view.getBundleText(TextsPaths.MONITORING_MESSAGE));
        model.addAttribute("parents_announcer", View.view.getBundleText(TextsPaths.PARENTS_ANNOUNCER));

        model.addAttribute("psychological_service_message", View.view.getBundleText(TextsPaths.PSYCHOLOGICAL_SERVICE_MESSAGE));
        model.addAttribute("parents_announcer_organisational_structure", View.view.getBundleText(TextsPaths.PARENTS_ANNOUNCER_ORGANISATIONAL_STRUCTURE));
        model.addAttribute("parents_announcer_local_base", View.view.getBundleText(TextsPaths.PARENTS_ANNOUNCER_LOCAL_BASE));
        model.addAttribute("parents_announcer_parents_committee", View.view.getBundleText(TextsPaths.PARENTS_ANNOUNCER_PARENTS_COMMITTEE));
        model.addAttribute("parents_announcer_support", View.view.getBundleText(TextsPaths.PARENTS_ANNOUNCER_SUPPORT));
        model.addAttribute("parents_announcer_books_order", View.view.getBundleText(TextsPaths.PARENTS_ANNOUNCER_BOOKS_ORDER));






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

        return new ModelAndView("for_parents");
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
