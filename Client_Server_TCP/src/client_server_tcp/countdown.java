
package client_server_tcp;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class countdown extends Thread {
    private int tempo;
    public boolean connected;
    private Client_Server_TCP serve;
    public countdown(int tempo){
        this.tempo=tempo;
    }
    @Override
    public void run(){
        for (int c=tempo/1000;c>0;c--){
            try {
                if(!connected){
                sleep(1000);
                System.out.print("Mancano:"+ c + "Secondi\n");
                }
                else{
                    break;
                }
            } catch (InterruptedException ex) {
                
            }
        }
    }
}
