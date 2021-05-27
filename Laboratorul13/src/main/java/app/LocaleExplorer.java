package app;

import com.DisplayLocales;
import com.Info;
import com.SetLocale;

import java.util.Scanner;

public class LocaleExplorer {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(true) {
            System.out.println("Enter Command:");
            String command = scanner.nextLine();
            String[] parts = command.split(" ");
            String part1 = parts[0];
            String part2 = parts[1];
            if (part1.equals("SetLocale"))
                new SetLocale(part2);
            else if (part1.equals("DisplayLocales"))
                new DisplayLocales();
            else if (part1.equals("Info"))
                new Info();
            else  if(part1.equals("Exit"))
                System.exit(0);
        }
    }
}
