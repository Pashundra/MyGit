package Network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientSide {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 12876);
        System.out.println("Connectedd to server");
     //   socket.getInputStream();    //входящий поток данных
//socket.getOutputStream();     //исходящий поток  запись чтение с пом. байт

     /*   Scanner input = new Scanner(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        String text = "Hello, server!";
        output.writeBytes(text + "\n");
        String fromServer = input.nextLine();
        System.out.println(fromServer);*/
        InputThread inputThread = new InputThread(socket);
        OutputThread outputThread = new OutputThread(socket);
        inputThread.start();
        outputThread.start();

        inputThread.join();
        outputThread.join();



        socket.close();
    }
}
