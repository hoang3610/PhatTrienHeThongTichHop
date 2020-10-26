package baitaplab4_ptthht.bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /* Khai báo */
        Socket socket = null;
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        String str1 = null;

        try {
            System.out.println("Client starting.......");
            socket = new Socket("localhost", 8888);

            // Nhap vao 1 ky tu
            System.out.println("Nhap vao so 0 - > 9");
            str1 = sc.nextLine();

            // Gui du lieu den server
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(str1);

            // Nhan du lieu tu server tra ve
            dataInputStream = new DataInputStream(socket.getInputStream());
            String dataReceive = dataInputStream.readUTF();
            System.out.println("Number tra vê tu Server la: " + dataReceive);

            /* Dong ket noi */
            socket.close();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
    }
}
