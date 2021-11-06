package com.project.slovyanka.view;

import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * @author Illia Koshkin
 * Цей клас дає змогу користуватися відповідними повідомленнями(текстами) з resource bundle(для інтернаціоналізації)
 */
public class View {

    public static final String BUNDLE_NAME = "messages";

    public static View view = new View();

    private ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME, new Locale("ukr"));

    /**
     * Цей метод дістає відповідний(згідно з обраною мовою) текст
     * @param path посилання на цей теста у resource bundle
     * @return строку(string) цього тексту
     */
    public String getBundleText(String path) {
        return bundle.getString(path);
    }

    /**
     * Цей метод змінює мову(далі, якщо діставати тексти за допомогою getBundleText(),
     * будуть обиратися тексти на відповідній мові
     * @param locale об'єкт локоції, що буде переключати bundle
     * @return Булевське значення(true, false), яке відповідає на питання: Чи успішна операція? Це є важливим для тестування.
     */
    public boolean changeLocale(Optional<Locale> locale) {
        if (locale.isPresent()) {
            bundle = ResourceBundle.getBundle(BUNDLE_NAME, locale.get());
            return true;
        } else {
            return false;
        }
    }
}
