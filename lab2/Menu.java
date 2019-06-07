package lab2;

import java.util.Scanner;

public class Menu extends Functions{

    public void main() {
        Scanner in = new Scanner(System.in);
        boolean get_menu = true;
        Functions functions = new Functions();

        while(get_menu == true) {
            System.out.println("\n Choose from the menu:");
            System.out.println("1. input length of the word");
            System.out.println("2. input line on which you want to replace the words");
            System.out.println("3. make changes");
            System.out.println("4. output the result\n");

            int choice = in.nextInt();

            if (choice < 1 || choice > 5) {
                System.out.println("Enter \"1\", \"2\", \"3\" or \"4\"" );
            }

            else if (choice==1){
                functions.length_of_word();
            }
            else if (choice==2){
                functions.input_line();
            }
            else if (choice==3){
                functions.make_changes();

            }
            else if (choice==4){
                get_menu = false;
                functions.output_result();
            }
        }

    }
}