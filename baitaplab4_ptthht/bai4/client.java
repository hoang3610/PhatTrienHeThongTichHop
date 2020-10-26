package baitaplab4_ptthht.bai4;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        Socket socket = null;
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        FileInputStream fileInputStream = null;
        Scanner sc = new Scanner(System.in);
        String temp = "";
        try {
            System.out.println("Client starting...............");
            socket = new Socket("localhost", 6969);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // // Input nhap vao tu ban phim
            // System.out.println("nhap vao so va dung lai den khi nhap dau . ");
            // String input = sc.nextLine();

            // while (!input.equals(".")) {
            //     temp += input + " ";
            //     input = sc.nextLine();
            // }
            // System.out.println(temp);
            // dataOutputStream.writeUTF(temp);

            // // nhan du lieu tu server
            // String str = dataInputStream.readUTF();
            // System.out.println("ket qua tong day so la: " + str);
            
            // Input nhan vao tu file data.txt
            dataInputStream = new DataInputStream(socket.getInputStream());
            fileInputStream = new FileInputStream("data.txt");
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            byte[] data = new byte[1024];
            int length = bufferedInputStream.read(data);
            String result = new String(data, 0, length);
            System.out.println(result);
            dataOutputStream.writeUTF(result);
            socket.close();
        } catch (Exception e) {
            // TODO: handle exception
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
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
