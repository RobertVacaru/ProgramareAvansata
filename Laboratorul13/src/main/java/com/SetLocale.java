package com;

import java.util.Locale;

public class SetLocale {
    public SetLocale(String language) {
        if(language.equals("ro"))
        Locale.setDefault(new Locale("ro","RO"));
        else if(language.equals("en"))
            Locale.setDefault(new Locale("en","US"));
    }
}
