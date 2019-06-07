package lab6;

public class MaxLengthThread extends Thread {

    static String MaxLWord;
    @Override
    public void run() {
        MaxLWord = "";
        for (String check : Main.MyData)
        {
            if (check.length() > MaxLWord.length())
            {
                MaxLWord = check;
                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}