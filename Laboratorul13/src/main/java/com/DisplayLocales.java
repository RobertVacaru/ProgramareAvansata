package com;

import java.util.Locale;
public class DisplayLocales {
    public DisplayLocales() {
        System.out.println("Available locales:");
        Locale available[] =
                Locale.getAvailableLocales();
    }

}