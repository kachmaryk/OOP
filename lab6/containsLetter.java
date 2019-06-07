package lab6;

public class containsLetter extends Thread {

    static int Counter;
    @Override
    public void run() {
        char search = 'l';
        String searching;
        for (int i = 0; i < Main.MyData.size(); i++) {
            searching = Main.MyData.get(i);
            for (int j = 0; j < searching.length(); j++) {
                if(searching.charAt(j) == search){
                    Counter++;
                }
            }
        }
    }
}
