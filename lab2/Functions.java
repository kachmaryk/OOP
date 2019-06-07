package lab2;

import java.util.Scanner;
public class Functions{
    public static StringBuffer text1 = new StringBuffer();
    private int length;
    private String line;
    private StringBuffer newText = new StringBuffer();
    private int element = 0;
    private boolean debug_main = false;

    public void get_string(StringBuffer text){
        text1.append(text);
        System.out.println(text1);
    }

    public void get_boolean(boolean debug){
        debug_main = debug;
    }

    public void length_of_word(){
        Scanner input_length = new Scanner(System.in);
        length = input_length.nextInt();
        System.out.println("The length of the word = " + length);
    }

    public void input_line(){
        Scanner input_line = new Scanner(System.in);
        line = input_line.nextLine();
        System.out.println("Line that raplace the words is: " + line);
    }

    public void make_changes(){
        System.out.println("Making changes...");
        String anotherText = text1 + " ";
        System.out.println(anotherText);
        int amount = text1.length();
        if(debug_main == true){
            System.out.println(amount);
        }
        int wordLength = 0;
        for(int i = 0; i<=amount; i++){
            if (anotherText.charAt(i) != ' '){
                wordLength +=1;
                if(debug_main == true){
                    System.out.println(wordLength);
                }
            }
            else{
                if (wordLength != length ){
                    for (int k = element; k < i; k++){
                        newText.append(anotherText.charAt(k));
                    }
                    element += wordLength+1;
                    if(debug_main == true){
                        System.out.println(element);
                    }
                    newText.append(" ");
                }
                if (wordLength == length){
                    newText.append(line);
                    element += length+1;
                    if(debug_main == true){
                        System.out.println(element);
                    }
                    newText.append(" ");
                }
                wordLength = 0;
            }
        }
    }

    public void output_result(){
        System.out.println(text1 + "\n");
        System.out.println(newText);
    }
}