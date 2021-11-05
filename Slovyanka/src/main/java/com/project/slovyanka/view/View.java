package com.project.slovyanka.view;

import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public class View {

    public static final String BUNDLE_NAME = "messages";

    public static View view = new View();

    private ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME, new Locale("ukr"));

    public String getBundleText(String path) {
        return bundle.getString(path);
    }

    public boolean changeLocale(Optional<Locale> locale) {
        if (locale.isPresent()) {
            bundle = ResourceBundle.getBundle(BUNDLE_NAME, locale.get());
            return true;
        } else {
            return false;
        }
    }
}
