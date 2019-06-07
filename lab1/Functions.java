package lab1;

import java.util.Scanner;
public class Functions {
    private String text;
    private int length;
    private String line;
    private StringBuffer newText = new StringBuffer();
    private int element = 0;

    public void input_text(){
        Scanner input_text = new Scanner(System.in);
        text = input_text.nextLine();
        System.out.println("Your text is: " + text);
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
        String anotherText = this.text + ' ';
        //System.out.println(anotherText);
        int amount =text.length();
        int wordLength = 0;
        for(int i = 0; i<=amount; i++){
            if (anotherText.charAt(i) != ' '){
                wordLength +=1;
            }
            else{
                if (wordLength != length ){
                    for (int k = element; k < i; k++){
                        newText.append(anotherText.charAt(k));
                    }
                    element += wordLength+1;
                    newText.append(" ");
                }
                if (wordLength == length){
                    newText.append(line);
                    element += length+1;
                    newText.append(" ");
                }
                wordLength = 0;
            }
        }
    }

    public void output_result(){
        System.out.println(this.text + "\n");
        System.out.println(newText);
    }

    public void debug(){
        System.out.println("Making changes...");
        String anotherText = this.text + ' ';
        //System.out.println(anotherText);
        int amount =text.length();
        int wordLength = 0;
        for(int i = 0; i<=amount; i++){
            if (anotherText.charAt(i) != ' '){
                wordLength +=1;
            }
            else {
                System.out.println(wordLength);
            }

        }
    }
}