package lab7;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);
    public static BufferedReader str=new BufferedReader(new InputStreamReader(System.in));
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Shop> shops = new ArrayList<>();
        int n=0;
        while(n!=-1) {
            System.out.println("Menu:\n" +
                    "1)Enter product\n" +
                    "2)Show list\n" +
                    "3)Remove\n" +
                    "4)Find element\n" +
                    "5)Sort list\n" +
                    "6)Encode\n" +
                    "7)Decode\n" +
                    "8)Serialize\n" +
                    "9)Deserialize\n" +
                    "-1)Show list\n");
            n = in.nextInt();

            if(n==1) {
                System.out.println("Product:");
                String name=(str.readLine());
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
                String num=new String("empty");
                while(num.length()!=0) {
                    num="";
                    System.out.println("Input your description:");
                    num=(str.readLine());
                    description.add(num);
                }
                shops.add(new Shop(name, unitOfMeasurement, amount, priceOfProduct, weight, dateOfArriving, description));

            }
            if(n==2) {
                System.out.println("Shops : " + shops);
            }
            if(n==3) {
                int r=in.nextInt();
                shops.remove(r-1);
            }
            if(n==4) {
                String find=(str.readLine());
                for(int i=0;i<shops.size();i++) {
                    if(shops.get(i).getProduct().equals(find)){
                        System.out.println("true");
                        break;
                    }
                }
                System.out.println("false");
            }
            if(n==5) {
                Comparator<Shop> shopNameComparator = new Comparator<Shop>() {
                    @Override
                    public int compare(Shop e1, Shop e2) {
                        return e1.getProduct().compareTo(e2.getProduct());
                    }
                };
                Collections.sort(shops, shopNameComparator);
            }
            if(n==6) {
                ArrayList <String> pathArr=new ArrayList<String>();
                String path="";
                String add="empty";
                while(!add.equals("")){
                    add=(str.readLine());
                    if(!add.equals("-ls")) {
                        pathArr.add(add);
                    }
                    if(add.equals("-ls")) {
                        pathArr.remove(pathArr.size()-1);
                    }
                    for(int i=0;i<pathArr.size();i++) {
                        path+=pathArr.get(i);
                    }
                    ls(path);
                    System.out.printf(path);
                    path="";
                }
                for(int i=0;i<pathArr.size();i++) {
                    path+=pathArr.get(i);
                }
                XMLEncoder xMLEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)));
                xMLEncoder.writeObject(shops);
                xMLEncoder.close();
                path="";
            }
            if(n==7) {
                ArrayList <String> pathArr=new ArrayList<String>();
                String path="";
                String add="empty";
                while(!add.equals("")){
                    add=(str.readLine());
                    if(!add.equals("-ls")) {
                        pathArr.add(add);
                    }
                    if(add.equals("-ls")) {
                        pathArr.remove(pathArr.size()-1);
                    }
                    for(int i=0;i<pathArr.size();i++) {
                        path+=pathArr.get(i);
                    }
                    ls(path);
                    System.out.printf(path);
                    path="";
                }
                for(int i=0;i<pathArr.size();i++) {
                    path+=pathArr.get(i);
                }
                XMLDecoder decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream(path)));
                shops= (List<Shop>) decoder.readObject();
                decoder.close();
                path="";
            }
            if(n==8) {
                ArrayList <String> pathArr=new ArrayList<String>();
                String path="";
                String add="empty";
                while(!add.equals("")){
                    add=(str.readLine());
                    if(!add.equals("-ls")) {
                        pathArr.add(add);
                    }
                    if(add.equals("-ls")) {
                        pathArr.remove(pathArr.size()-1);
                    }
                    for(int i=0;i<pathArr.size();i++) {
                        path+=pathArr.get(i);
                    }
                    ls(path);
                    System.out.printf(path);
                    path="";
                }
                for(int i=0;i<pathArr.size();i++) {
                    path+=pathArr.get(i);
                }
                FileOutputStream fos = new FileOutputStream(path);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                for(Iterator<Shop> iterator=shops.iterator();iterator.hasNext();) {
                    if(!shops.isEmpty()) {
                        Shop data=iterator.next();
                        oos.writeObject(data);
                    }
                    else {
                        System.out.println("Empty");
                        break;
                    }

                }
                oos.flush();
                oos.close();
            }
            if(n==9) {
                ArrayList <String> pathArr=new ArrayList<String>();
                String path="";
                String add="empty";
                while(!add.equals("")){
                    add=(str.readLine());
                    if(!add.equals("-ls")) {
                        pathArr.add(add);
                    }
                    if(add.equals("-ls")) {
                        pathArr.remove(pathArr.size()-1);
                    }
                    for(int i=0;i<pathArr.size();i++) {
                        path+=pathArr.get(i);
                    }
                    ls(path);
                    System.out.printf(path);
                    path="";
                }
                for(int i=0;i<pathArr.size();i++) {
                    path+=pathArr.get(i);
                }
                FileInputStream fis = new FileInputStream(path);
                ObjectInputStream oin = new ObjectInputStream(fis);
                Shop data=new Shop();
                while(true) {
                    try {
                        data=(Shop) oin.readObject();
                        shops.add(data);
                    }
                    catch(EOFException ignored) {
                        break;
                    }
                }
                oin.close();
            }
            //System.out.println("\nShops (Sorted by Name) : " + shops);
        }
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
            System.out.println("There is no such directory");
    }
}