package client_server_tcp;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class progClient {
    public static void main(String[] args) {
        Socket socket = null;
        String indirizzo = null;
        try{
            socket = new Socket("127.0.0.1", 2200);
            indirizzo = InetAddress.getLocalHost().getHostAddress();
            System.out.println(indirizzo);
            System.out.println("Connessione aperta");
        }
        catch (IOException ex) {
            Logger.getLogger(progClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
            try {
                   if (socket!=null)
                {
                    socket.close();
                    System.out.println("Connessione chiusa!");
                }
            } catch (IOException ex) {
                Logger.getLogger(progClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
}