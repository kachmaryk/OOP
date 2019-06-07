package lab1;

import java.util.Scanner;
public class Menu extends Functions{

    public static void main(String[] args) {

        boolean debug = false;

        // перевірка аргументів командного рядка
        if(args != null && args.length == 1){
            if(args[0].equals("-h")){
                System.out.println("Качмарик Віктор\n" +
                        "Ввести текст.\n" +
                        "Ввести довжину слова яке ви хочете заміняти на стрічку.\n" +
                        "Ввести стрічку, якою ви будете заміняти слово заданої довжини.\n" +
                        "Зробіть зміни.\n" +
                        "Виведіть результат.\n");
            }
            if(args[0].equals("-d")){
                debug = true;
            }
        }
        Scanner menu_choice = new Scanner(System.in);
        boolean get_menu = true;
        Functions functions = new Functions();

        while(get_menu == true) {
            System.out.println("\n Choose from the menu:");
            System.out.println("1. input text");
            System.out.println("2. input length of the word");
            System.out.println("3. input line on which you want to replace the words");
            System.out.println("4. make changes");
            System.out.println("5. output the result\n");

            int choice = menu_choice.nextInt();

            if (choice < 1 || choice > 5) {
                System.out.println("Enter \"1\", \"2\", \"3\", \"4\" or \"5\"" );
            }

            else if (choice==1){
                if (debug == true) {
                    System.out.println();
                }
                functions.input_text();
            }
            else if (choice==2){
                if (debug == true) {
                }
                functions.length_of_word();
            }
            else if (choice==3){
                if (debug == true) {
                }
                functions.input_line();
            }
            else if (choice==4){
                if (debug == true) {
                    functions.debug();
                }
                functions.make_changes();

            }
            else if (choice==5){
                get_menu = false;
                if (debug == true) {
                }
                functions.output_result();
            }
        }

    }
}
