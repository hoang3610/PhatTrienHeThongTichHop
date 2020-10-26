package baitaplab4_ptthht.bai4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Server starting...............");
            serverSocket = new ServerSocket(6969);
            socket = serverSocket.accept();

            // nhan du lieu tu client
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String str = dataInputStream.readUTF();
            System.out.println(str);

            String temp = "";
            int sum = 0;
            // xy ly du lieu file
            for (String s : str.trim().split(" ")) {
                if(s.equals("."))
                {
                    break;
                }
                else
                {
                    int convert = Integer.parseInt(s);
                    sum += convert;
                }
            }
            System.out.println("tong cua day so la: " + sum);
            
            //xu ly du lieu nhap lieu
            // int sum = 0;
            // for (String s : str.trim().split(" ")) {
            //     int num = Integer.parseInt(s);
            //     sum += num;
            // }

            // // in tong day so ra man hinh
            // System.out.println("tong cua day so la:" + sum);

            // // ghi du lieu gui cho client ket qua
            // String convert = Integer.toString(sum);
            // dataOutputStream.writeUTF(convert);
           
            serverSocket.close();
            socket.close();
        } catch (Exception e) {
            //TODO: handle exception
        } finally {
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
