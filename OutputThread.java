package Network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class OutputThread extends Thread {



    private DataOutputStream output;
    public OutputThread(Socket socket) throws IOException {
        output = new DataOutputStream(socket.getOutputStream());


    }


    @Override
public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String value = sc.nextLine();
            try {
                output.writeBytes(value + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (value.equalsIgnoreCase("exit")) {
                break;
            }

        }
    }
}
