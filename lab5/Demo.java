package lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Demo {

    public static boolean check=false;
    public static BufferedReader str=new BufferedReader(new InputStreamReader(System.in));
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        for(String i:args) {
            if(i.equals("-auto")) {
                check=true;
            }
        }
        MarketList<Shop> stack = new MarketList<Shop>();
        ArrayList<Shop> array = null;
        String string = "";
        int size=0;
        int n=0;
        if(check==true) {
            Serialization.Decode(stack);
            ArrayList <String> description =  new ArrayList<String>();
            description.add("Very fresh");
            stack.push(new Shop("Milk","litters","100", "27","100" ,"today",description));
            for(Iterator<Shop> iterator = stack.iterator(); iterator.hasNext();) {
                if(!stack.isEmpty()) {
                    Shop data=iterator.next();
                    print(data);
                }
            }
            stack.deleteElement(1);
            array=new ArrayList<Shop>();
            for(Iterator<Shop> iterator = stack.iterator(); iterator.hasNext();) {
                if(!stack.isEmpty()) {
                    Shop data=iterator.next();
                    string += data.getProduct()+" ";
                    string += data.getUnitOfMeasurement()+" ";
                    string += data.getAmount()+" ";
                    string += data.getPriceOfProduct()+" ";
                    string += data.getWeight()+" ";
                    string += data.getDateOfArriving()+" ";
                    string += data.getDescription()+"\n";
                    array.add(data);
                    size++;
                    System.out.println("____________________________________________");
                    print(data);
                    System.out.println("____________________________________________");
                }
            }
            System.out.printf("String:%s\n",string);
            System.out.printf("Array:%s\n",array);
            Serialization.Encode(stack);
            System.exit(0);
        }
        while(n!=-1) {
            System.out.println("Menu:\n" +
                               "1)Enter product\n" +
                               "2)Clear all\n" +
                               "3)Show list\n" +
                               "4)Remove element\n" +
                               "5)Encoding\n" +
                               "6)Make array\n" +
                               "7)Show array\n" +
                               "8)Decoding\n" +
                               "9)Make String\n" +
                               "10)Find\n" +
                               "11)Serialization\n" +
                               "12)Deserialization");
            n = in.nextInt();
            if(n==1) {
                Shop shop=enter();
                stack.push(shop);
            }
            if(n==2) {
                System.out.println("Deleting all elements");
                while(!stack.isEmpty()) {
                    stack.pop();
                }
            }
            if(n==3) {
                System.out.println("Elements:");
                for(Iterator<Shop> iterator = stack.iterator(); iterator.hasNext();) {
                    if(!stack.isEmpty()) {
                        Shop data=iterator.next();
                        print(data);
                    }
                    else {
                        System.out.println("Stack is empty\n");
                        break;
                    }

                }
            }
            if(n==4) {
                System.out.println("Which element remove?");
                int r= in.nextInt();
                stack.deleteElement(r);
            }
            if(n==5) {
                Serialization.Encode(stack);
                System.out.println("Encoding successful");
            }
            if(n==6) {
                array=new ArrayList<Shop>();
                for(Iterator<Shop> iterator = stack.iterator(); iterator.hasNext();) {
                    if(!stack.isEmpty()) {
                        array.add(iterator.next());
                        size++;
                    }
                    else {
                        System.out.println("Empty");
                        break;
                    }

                }
            }
            if(n==7) {
                System.out.println("New array:");
                while(true) {
                    for(int i=0;i<size;i++) {
                        array.get(i).print();
                    }
                    break;
                }
            }
            if(n==8) {
                Serialization.Decode(stack);
                System.out.println("Decoding successful");
            }
            if(n==9) {
                System.out.println("String:");
                for(Iterator<Shop> iterator = stack.iterator(); iterator.hasNext();) {
                    if(!stack.isEmpty()) {
                        Shop data=iterator.next();
                        string += data.getProduct()+" ";
                        string += data.getUnitOfMeasurement()+" ";
                        string += data.getAmount()+" ";
                        string += data.getPriceOfProduct()+" ";
                        string += data.getWeight()+" ";
                        string += data.getDateOfArriving()+" ";
                        string += data.getDescription()+"\n";
                    }
                    else {
                        System.out.println("Empty");
                        break;
                    }
                }
                System.out.printf("%s\n",string);
            }
            if(n==10) {
                String find=(str.readLine());
                if(!stack.isEmpty()) {
                    stack.findElement(find);
                }
            }
            if(n==11) {
                Serialization.Serialize(stack);
                System.out.println("Serialization successful");
            }
            if(n==12) {
                Serialization.Deserialize(stack);
                System.out.println("Deserialization successful");
            }
        }
    }
    public static void print(Shop data) {
        System.out.println(data.getProduct());
        System.out.println(data.getUnitOfMeasurement());
        System.out.println(data.getAmount());
        System.out.println(data.getPriceOfProduct());
        System.out.println(data.getWeight());
        System.out.println(data.getDateOfArriving());
        System.out.println(data.getDescription());
    }
    public static Shop enter() throws IOException {
        System.out.println("Product:");
        String product=(str.readLine());
        System.out.println("Unit of measurement:");
        String unitOfMeasurement=(str.readLine());
        System.out.println("Amount:");
        String amount=(str.readLine());
        System.out.println("Price of product:");
        String priceOfProduct=(str.readLine());
        System.out.println("Weight:");
        String weight=(str.readLine());
        System.out.println("dateOfArriving:");
        String dateOfArriving=(str.readLine());
        ArrayList <String> description =  new ArrayList<String>();
        String num = new String("empty");
        while(true) {
            num = "";
            System.out.println("Descriptiion:");
            num=(str.readLine());
            if(num.length()==0) {
                break;
            }
            description.add(num);
        }
        Shop shop=new Shop(product, unitOfMeasurement, amount, priceOfProduct, weight, dateOfArriving, description);
        return shop;
    }
}