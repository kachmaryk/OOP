package lab2;

import java.util.ArrayList;
import java.util.Scanner;

public class ConteinerMenu{

    static StringBuffer text = new StringBuffer();
    public static void main(String[] args) {
        boolean debug = false;
        // перевірка аргументів командного рядка
        if(args != null && args.length == 1) {
            if (args[0].equals("-h")) {
                System.out.println("Качмарик Віктор\n" +
                        "Ввести текст.\n" +
                        "Ввести довжину слова яке ви хочете заміняти на стрічку.\n" +
                        "Ввести стрічку, якою ви будете заміняти слово заданої довжини.\n" +
                        "Зробіть зміни.\n" +
                        "Виведіть результат.\n");
            }
            if (args[0].equals("-d")) {
                debug = true;
            }
        }

        Functions functions = new Functions();
        Menu menu = new Menu();

        Scanner in = new Scanner(System.in);
        ArrayList<Container> listOfContainers = new ArrayList<>();
        boolean get_menu = true;
        while (get_menu == true) {
            System.out.println("__________________________________________");
            System.out.println("1 - make container");
            System.out.println("2 - fill container");
            System.out.println("3 - clear container");
            System.out.println("4 - show container");
            System.out.println("5 - container menu");
            System.out.println("6 - exit");
            System.out.println("__________________________________________");

            int choice = in.nextInt();

            if (choice < 1 || choice > 6) {
                System.out.println("Unknown ghoice");
                System.out.println("Enter \"1\", \"2\", \"3\", \"4\", \"5\" or \"6\"" );
            }
            else if (choice == 1) {
                System.out.print("enter container's max length: ");
                listOfContainers.add(new Container(in.nextInt()));
                System.out.println("success! your container's key is [" + listOfContainers.size() + "]");
            }

            else if (choice == 2) {
                System.out.print("enter container's key: ");
                int index = in.nextInt();
                if (index > listOfContainers.size() || index < 0) {
                    System.out.println("error! not found");
                }
                System.out.println("Enter " + listOfContainers.get(index - 1).maxSize() + " strings using enter:");
                in.nextLine();
                for (int i = 0, n = listOfContainers.get(index - 1).maxSize(); i < n; i++) {
                    listOfContainers.get(index - 1).add(in.nextLine());
                }
                text.append(listOfContainers.get(index - 1));
            }

            else if (choice == 3) {
                System.out.print("enter container's key: ");
                int delIndex = in.nextInt();
                if (delIndex > listOfContainers.size() || delIndex < 1) {
                    System.out.println("error! not found");
                }
                listOfContainers.get(delIndex - 1).clear();
                System.out.println("done!");
            }

            else if (choice == 4) {
                System.out.print("enter container's key: ");
                int showIndex = in.nextInt();
                if (showIndex > listOfContainers.size() || showIndex < 1) {
                    System.out.println("error! not found");
                }
                System.out.println(listOfContainers.get(showIndex - 1).toString());
            }

            else if (choice == 5) {
                boolean get_menu_second = true;
                System.out.print("enter container's key: ");
                int menuIndex = in.nextInt();
                if (menuIndex > listOfContainers.size() || menuIndex < 1) {
                    System.out.println("error! not found");
                }
                while (get_menu_second == true){
                    System.out.println("__________________________________________");
                    System.out.println("1 - result");
                    System.out.println("2 - size");
                    System.out.println("3 - iterate (for each)");
                    System.out.println("4 - iterate (while)");
                    System.out.println("5 - remove element");
                    System.out.println("6 - add element");
                    System.out.println("7 - check if container includes string");
                    System.out.println("8 - serialize");
                    System.out.println("9 - deserialize");
                    System.out.println("10 - return");
                    System.out.println("__________________________________________");
                    int choice_second = in.nextInt();

                    if (choice_second < 1 || choice_second > 10) {
                        System.out.println("Unknown ghoice");
                        System.out.println("Enter \"1\", \"2\", \"3\", \"4\", \"5\", \"6\", \"7\", \"8\", \"9\" or \"10\"" );
                    }

                    else if (choice_second == 1) {
                        functions.get_string(text);
                        functions.get_boolean(debug);
                        System.out.println("\n");
                        menu.main();
                    }

                    else if (choice_second == 2) {
                        System.out.println(listOfContainers.get(menuIndex - 1).size());
                    }

                    else if (choice_second == 3) {
                        for (String i : listOfContainers.get(menuIndex - 1)) {
                            System.out.println(i);
                        }
                    }

                    else if (choice_second == 4) {
                        lab2.MyIterator i = (lab2.MyIterator) listOfContainers.get(menuIndex - 1).iterator();
                        while (i.hasNext()) {
                            System.out.println(i.next());
                        }
                    }

                    else if (choice_second == 5) {
                        System.out.println("enter element:");
                        in.nextLine();
                        listOfContainers.get(menuIndex - 1).remove(in.nextLine());
                    }

                    else if (choice_second == 6) {
                        System.out.println("enter element:");
                        in.nextLine();
                        listOfContainers.get(menuIndex - 1).add(in.nextLine());
                    }

                    else if (choice_second == 7) {
                        System.out.println("enter string to check if container includes it:");
                        in.nextLine();
                        System.out.println(listOfContainers.get(menuIndex - 1).contains(in.nextLine()));
                    }

                    else if (choice_second == 8) {
                        System.out.println("enter file: ");
                        in.nextLine();
                        listOfContainers.get(menuIndex - 1).serialize(in.nextLine());
                    }

                    else if (choice_second == 9) {
                        System.out.println("enter file: ");
                        in.nextLine();
                        listOfContainers.get(menuIndex - 1).deserialize(in.nextLine());
                    }

                    else if (choice_second == 10) {
                        get_menu_second = false;
                    }
                }
            }

            else if (choice ==6 ) {
                System.out.println("goodbye!");
                get_menu = false;
            }
        }
    }
}
