package com;

import java.text.DateFormatSymbols;
import java.util.Currency;
import java.util.Locale;

public class Info {
    public Info() {
       Locale locale=Locale.getDefault();

            System.out.println(locale.getDisplayCountry() + "\t" +
                    locale.getDisplayLanguage(locale)+"\t"+
                    Currency.getInstance(locale)+"\t"+
                    DateFormatSymbols.getInstance(locale)+"\t"
                    );
    }
}
