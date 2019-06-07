package lab6;
public class onAverageThread extends Thread {

    static int cCounter;
    @Override
    public void run() {
        cCounter = 0;
        for (String myString : Main.MyData)
        {
            if(myString.contains("l"))
            {
                cCounter++;
                try
                {
                    Thread.sleep(10);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }

    }
}
