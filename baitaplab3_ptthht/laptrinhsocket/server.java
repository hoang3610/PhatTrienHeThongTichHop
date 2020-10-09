package baitaplab3_ptthht.laptrinhsocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
    public static void main(String[] args) {
        FileOutputStream fileOutputStream = null;

        Scanner sc = new Scanner(System.in);
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;

        try {
            System.out.println("sever starting..................");
            ServerSocket serverSocket = new ServerSocket(6666);
            Socket s= serverSocket.accept();

            dataInputStream = new DataInputStream(s.getInputStream());
            dataOutputStream = new DataOutputStream(s.getOutputStream());

            /* chat hoi ten */
            //ghi du lieu
            String str = "E thang client may ten gi day ? ";
            dataOutputStream.writeUTF(str);
            dataOutputStream.flush();
            
            //doc du lieu
            String strRead = dataInputStream.readUTF();
            System.out.println(strRead);

            /* Đóng kết nối */
            dataInputStream.close();
            dataOutputStream.close();
            s.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
