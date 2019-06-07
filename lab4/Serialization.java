package lab4;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

public class Serialization<E>{

    public static BufferedReader str=new BufferedReader(new InputStreamReader(System.in));


    public static void Decode(MarketList<Shop> stack) throws IOException {
        ArrayList <String> pathArr=new ArrayList<String>();
        String path="";
        String add="empty";
        if(Demo.check==true) {
            path="lab4.xml";
        }
        else {
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
        }
        XMLDecoder decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream(path)));
        Shop data=new Shop();
        while(true) {
            try {
                data=(Shop) decoder.readObject();
                stack.push(data);
            }
            catch(ArrayIndexOutOfBoundsException ignored) {
                break;
            }
        }
        decoder.close();
        stack.reverse(stack);

    }

    public static void Encode(MarketList<Shop> stack) throws IOException {
        ArrayList <String> pathArr=new ArrayList<String>();
        String path="";
        String add="empty";
        if(Demo.check==true) {
            path="autosave1.xml";
        }
        else {
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
        }
        XMLEncoder xMLEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)));
        for(Iterator<Shop> iterator=stack.iterator();iterator.hasNext();) {
            if(!stack.isEmpty()) {
                Shop data=iterator.next();
                xMLEncoder.writeObject(data);
            }
            else {
                System.out.println("Empty");
                break;
            }

        }
        xMLEncoder.close();
    }
    public static void Serialize(MarketList<Shop> stack) throws IOException {
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
        for(Iterator<Shop> iterator=stack.iterator();iterator.hasNext();) {
            if(!stack.isEmpty()) {
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
    public static void Deserialize(MarketList<Shop> stack) throws IOException, ClassNotFoundException {
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
                stack.push(data);
            }
            catch(EOFException ignored) {
                break;
            }
        }
        oin.close();
        stack.reverse(stack);
    }
    public static void ls(String folderName) {
        try {
            if (Files.exists(Paths.get(folderName))) {
                File folder = new File(folderName);
                File[] listOfFiles = folder.listFiles();

                System.out.println(folder.getAbsolutePath());

                for (int i = 0; i < listOfFiles.length; i++) {
                    System.out.println(listOfFiles[i].getName());
                }
            }
            else
                System.out.println("\nThere is no such directory");
        }
        catch(InvalidPathException | NullPointerException ignore) {
        }
    }
}