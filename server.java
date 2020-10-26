package baitaplab4_ptthht.bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        /* Khai báo */
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        Socket socket = null;
        ServerSocket serverSocket = null;
        
        try {
            System.out.println("Server starting...........");
            serverSocket = new ServerSocket(8888);
            socket = serverSocket.accept();

            // nhan du lieu tu client
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String str = dataInputStream.readUTF();
            System.out.println(str);
           
            
            /* Xu ly yeu cau: in ra chu so nhan dươc tu client
            trong khoang tu 0 -> 9, neu nhu ki tu nhan duoc khong phai la so
            thi tra ve client "day khong phai la so nguyen " */
            if(isNumeric(str))
            {
                int convert = Integer.parseInt(str);
                System.out.println(convertNumber(convert));
                dataOutputStream.writeUTF(convertNumber(convert));
            }
            else
            {
                String output = "day khong phai la so nguyen";
                System.out.println(output);
                dataOutputStream.writeUTF(output);
            }

            /* Dong ket noi */
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
        }
    }

    /* function check number or string */
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /* function doc tu so sang chu so */
    public static String convertNumber(int number)
    {
        String output = null;
        if(number < 0)
        {
            output = Integer.toString(number) + " la so am";
        }
        if(number == 0)
        {
            output = "khong";
        }
        else if(number == 1)
        {
            output = "mot";
        }
        else if(number == 2)
        {
            output = "hai";
        }
        else if(number == 3)
        {
            output = "ba";
        }
        else if(number == 4)
        {
            output = "bon";
        }
        else if(number == 5)
        {
            output = "nam";
        }
        else if(number == 6)
        {
            output = "sau";
        }
        else if(number == 7)
        {
            output = "bay";
        }
        else if(number == 8)
        {
            output = "tam";
        }else if(number == 9)
        {
            output = "chin";
        }else if(number > 9)
        {
            output =  Integer.toString(number) + " la so co 2 chu so";
        }
        return output;
    }
}
