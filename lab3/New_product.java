package lab3;

import java.util.Scanner;

public class New_product {

    public void menuInNew_product(int good){
        int goodd = good;
        int how_much;
        Scanner in = new Scanner(System.in);
        boolean get_menu = true;
        Functions functions = new Functions();

        while(get_menu == true) {
            System.out.println("__________________________________________");
            System.out.println("\n Choose from the menu:");
            System.out.println("1. input name of the product");
            System.out.println("2. input unit of measurement");
            System.out.println("3. input amount of goods");
            System.out.println("4. input price of product");
            System.out.println("5. input weight of product");
            System.out.println("6. input data of arriving of the product");
            System.out.println("7. input description");
            System.out.println("8. show out the product");
            System.out.println("9. exit");
            System.out.println("__________________________________________");

            int choice = in.nextInt();

            if (choice < 1 || choice > 9) {
                System.out.println("Enter number from \"1\" to \"9\"" );
            }

            else if (choice==1){
                System.out.println("Input name of the product:");
                //System.out.println("Size of the list = " + Functions.list.size());
                functions.add_product(goodd);
            }
            else if (choice==2){
                System.out.println("Input in what will be measure product: ");
                functions.unit_of_measurement(goodd);
            }
            else if (choice==3){
                System.out.println("Input amount of goods");
                functions.amount_of_goods(goodd);
            }
            else if (choice==4){
                System.out.println("input price of product");
                functions.price_of_product(goodd);
            }
            else if (choice==5){
                System.out.println("input weight of product");
                functions.weight_of_product(goodd);
            }
            else if (choice==6){
                System.out.println("input data of arriving of the product");
                functions.data_of_arriving(goodd);
            }
            else if (choice==7){
                System.out.println("input how much values will be:");
                how_much = in.nextInt();
                functions.description(goodd, how_much);
            }
            else if (choice==8){
                functions.show(goodd);
            }
            else if (choice==9){
                System.out.println("Bye)");
                get_menu = false;
            }
        }
    }
}
