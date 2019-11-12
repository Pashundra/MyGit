package Network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSide {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket server = new ServerSocket(); //созд сервер
        server.setReuseAddress(true);   // переиспользование адреса после падения сервера
        server.bind(new InetSocketAddress("localhost", 12876));

Socket socket = server.accept(); //запускает операцию котор ожидает входящ соедин, возвр обьект типа сокет
        System.out.println("Client connected");

       /* Scanner input = new Scanner(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
String value = input.nextLine();
output.writeBytes(value + "\n");*/
       InputThread inputThread = new InputThread(socket);
       OutputThread outputThread = new OutputThread(socket);
       inputThread.start();
       outputThread.start();

       inputThread.join();
       outputThread.join();


        server.close();
    }
}
