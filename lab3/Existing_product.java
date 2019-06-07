package lab3;

import java.util.Scanner;

public class Existing_product {
    public void menuInExisting_product(){
        Scanner in = new Scanner(System.in);
        boolean get_menu = true;
        Functions functions = new Functions();

        while(get_menu == true) {
            System.out.println("__________________________________________");
            System.out.println("\n Choose from the menu:");
            System.out.println("1. Choose the product");
            System.out.println("2. show all about the product");
            System.out.println("3. exit");

            System.out.println("__________________________________________");

            int choice = in.nextInt();

            if (choice < 1 || choice > 5) {
                System.out.println("Enter \"1\", \"2\" or \"3\"" );
            }

            else if (choice==1){
                functions.choose_product();
            }
            else if (choice==2){
                functions.showw();
            }
            else if (choice==3){
                get_menu = false;
            }
        }
    }
}
