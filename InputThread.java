package Network;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class InputThread extends Thread { //поток из сокета в данные

    private Scanner input;

    public InputThread(Socket socket) throws IOException {
        input = new Scanner(socket.getInputStream());
    }


    @Override
    public void run() {
        while (true) {
            String value = input.nextLine();
            if (value.equalsIgnoreCase("exit")) {
                break;


            }
            System.out.println(value);

        }
    }
}