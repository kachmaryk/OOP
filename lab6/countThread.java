package lab6;

public class countThread extends Thread {

    static int ANDcounter;
    @Override
    public void run() {
        ANDcounter = 0;
        String search = "lol";
        for (String myString : Main.MyData)
        {
            if (myString.contains(search))
            {
                ANDcounter++;
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
