package baitaplab3_ptthht.laptrinhsocket;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        try {
            System.out.println("client startingggg......");
            Socket s = new Socket("localhost",6666);
            DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(s.getInputStream());

            /* chat hoi ten */
            //doc du lieu tu thang server
            String str = dataInputStream.readUTF();
            System.out.println(str);

            //ghi du lieu
            Scanner sc = new Scanner(System.in);
            String strWrite = sc.nextLine();
            dataOutputStream.writeUTF(strWrite);
            dataOutputStream.flush();

            //dong ket noi
            dataInputStream.close();
            dataOutputStream.close();
            s.close();
        } catch (Exception e) {
            System.out.println("khong ket noi duoc");
        }
    }
}
