package lab3;

import java.io.IOException;
import java.util.Scanner;
import java.util.Locale;

public class Menu {
    private static int good = -1;
    public static void main(String[] args) throws IOException {
        Locale.setDefault(new Locale("uk", "UA"));
        Scanner in = new Scanner(System.in);
        Functions functions = new Functions();
        New_product menuInNew_product = new New_product();
        Existing_product menuInExisting_product = new Existing_product();

        boolean get_menu = true;
        while (get_menu == true) {
            System.out.println("__________________________________________");
            System.out.println("1 - add product");
            System.out.println("2 - existing product");
            System.out.println("3 - serialize");
            System.out.println("4 - deserialize");
            System.out.println("5 - show all products");
            System.out.println("6 - exit");
            System.out.println("__________________________________________");

            int choice = in.nextInt();
            if (choice < 1 || choice > 6) {
                System.out.println("Unknown ghoice");
                System.out.println("Enter number from \"1\" to\"6\"");
            }
            else if (choice==1){
                good++;
                menuInNew_product.menuInNew_product(good);
            }
            else if (choice==2){
                menuInExisting_product.menuInExisting_product();
            }
            else if (choice==3){
                functions.serealize();
            }
            else if (choice==4){
                functions.deserealize();
            }
            else if (choice==5){
                functions.show_all();
            }
            else if (choice==6){
                System.out.println("Bye my friend!");
                get_menu = false;
            }
        }
    }
}
