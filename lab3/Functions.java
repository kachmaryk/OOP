package lab3;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Functions {

    private String path=new String();
    private int pointer_show;
    Scanner in = new Scanner(System.in);
    public static ArrayList<Shop> list = new ArrayList<>();
    public static BufferedReader str = new BufferedReader(new InputStreamReader(System.in));
    ArrayList <String> phone =  new ArrayList<String>();

    public void add_product(int goodd){
        list.add(new Shop());
        list.get(goodd).setProduct(in.nextLine());
    }
    public void unit_of_measurement(int goodd){
        list.get(goodd).setUnitOfMeasurement(in.nextLine());
    }
    public void amount_of_goods(int goodd){
        list.get(goodd).setAmount(in.nextInt());
    }
    public void price_of_product(int goodd){
        list.get(goodd).setPriceOfProduct(in.nextInt());
    }
    public void weight_of_product(int goodd){
        list.get(goodd).setWeight(in.nextInt());
    }
    public void data_of_arriving(int goodd){
        list.get(goodd).setDateOfArriving(in.nextLine());
    }
    public void description(int goodd, int how_much){
        HashMap<String, String> buffer = new HashMap<>();
        for (int i = 0; i < how_much; i++) {
            String key = in.nextLine();
            String value = in.nextLine();
            buffer.put(key, value);
            list.get(goodd).setDescription(buffer);
            key = new String();
            value = new String();
        }
    }
    public void show(int goodd){
        System.out.println(" Product: " + list.get(goodd).getProduct() +
                           "\n Unit of measurement: " + list.get(goodd).getUnitOfMeasurement() +
                           "\n Amount: " + list.get(goodd).getAmount() +
                           "\n Price of product: " + list.get(goodd).getPriceOfProduct() +
                           "\n Weight of product: " + list.get(goodd).getWeight() +
                           "\n Data of arriving: " + list.get(goodd).getDateOfArriving() +
                           "\n description: " + list.get(goodd).getDescription());
    }
    public void choose_product(){
        System.out.println("Choose the good from 0 to " + (list.size()-1));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " - " + list.get(i).getProduct());
        }
        System.out.println("Input number");
        pointer_show = in.nextInt();
    }
    public void showw(){
        System.out.println(" Product: " + list.get(pointer_show).getProduct() +
                "\n Unit of measurement: " + list.get(pointer_show).getUnitOfMeasurement() +
                "\n Amount: " + list.get(pointer_show).getAmount() +
                "\n Price of product: " + list.get(pointer_show).getPriceOfProduct() +
                "\n Weight of product: " + list.get(pointer_show).getWeight() +
                "\n Data of arriving: " + list.get(pointer_show).getDateOfArriving() +
                "\n description: " + list.get(pointer_show).getDescription());
    }
    public void show_all(){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(" Product: " + list.get(i).getProduct() +
                    "\n Unit of measurement: " + list.get(i).getUnitOfMeasurement() +
                    "\n Amount: " + list.get(i).getAmount() +
                    "\n Price of product: " + list.get(i).getPriceOfProduct() +
                    "\n Weight of product: " + list.get(i).getWeight() +
                    "\n Data of arriving: " + list.get(i).getDateOfArriving() +
                    "\n description: " + list.get(i).getDescription() + "\n");
        }
    }
    public void serealize() throws IOException {
        int p=0;
        while(p!=-1) {
            System.out.println("---------------------------------------------------------------------");
            System.out.printf("1)Exit\n2)Input where serealize\n3)Output all in derectoria\n");
            System.out.println("---------------------------------------------------------------------");
            p = in.nextInt();
            if(p==1) {
                break;
            }
            System.out.printf(path);
            if(p==2) {
                path+=(str.readLine());
            }
            if(p==3) {
                ls(path);
            }
        }
        XMLEncoder xMLEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)));
        xMLEncoder.writeObject(list);
        xMLEncoder.close();
        path="";
    }
    public void deserealize() throws IOException {
        int p=0;
        while(p!=-1) {
            System.out.println("---------------------------------------------------------------------");
            System.out.printf("1)Exit\n2)Input where to search\n3)Output all in derectoria\n");
            System.out.println();
            System.out.println("---------------------------------------------------------------------");
            p = in.nextInt();
            if(p==1) {
                break;
            }
            System.out.printf(path);
            if(p==2) {
                path+=(str.readLine());
            }
            if(p==3) {
                ls(path);
            }
        }
        XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)));
        list = (ArrayList<Shop>) decoder.readObject();
        decoder.close();
        path = "";
    }
    public static void ls(String folderName) {
        if (Files.exists(Paths.get(folderName))) {
            File folder = new File(folderName);
            File[] listOfFiles = folder.listFiles();

            System.out.println(folder.getAbsolutePath());

            for (int i = 0; i < listOfFiles.length; i++) {
                System.out.println(listOfFiles[i].getName());
            }
        }else
            System.out.println("\nThere is no such directory");
    }
}
