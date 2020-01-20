package client_server_tcp;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client_Server_TCP {

    public static void main(String[] args) throws InterruptedException {
        Socket socket = null;
        String indirizzo = null;
         ServerSocket server = null;
        boolean connesso = false;
        int tempo = 10000;
        countdown conta = new countdown(tempo);
        try {
            server = new ServerSocket(2200);
        } catch (IOException ex) {
            Logger.getLogger(Client_Server_TCP.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
           
            server.setSoTimeout(tempo);
            conta.start();
            indirizzo = InetAddress.getLocalHost().getHostAddress();
            System.out.println("\n--- In Attesa di Connessione ---");
            socket = server.accept();
            conta.connected=true;
            System.out.println("Connessione stabilita!");
            System.out.println(indirizzo);
            System.out.println("Server Socket:" + socket.getLocalSocketAddress());
            System.out.println("Socket client:" + socket.getRemoteSocketAddress());
            conta.interrupt();
        }catch(SocketTimeoutException e){
            System.out.println("Errore di I/O");
        }
        catch (IOException ex) {
            Logger.getLogger(Client_Server_TCP.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
            try{
            if(socket!=null) {
                socket.close();
            }
            } catch (IOException ex) {
                 Logger.getLogger(Client_Server_TCP.class.getName()).log(Level.SEVERE, null, ex);
            }
             System.out.println("Connessione chiusa!");
            ciao mi chiamo mattia
            
    }
}
