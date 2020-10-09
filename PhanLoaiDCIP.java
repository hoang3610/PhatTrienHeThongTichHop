package baitaplab3_ptthht;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class PhanLoaiDCIP {
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                System.out.println("Cach su dung: java TimDCIP <Hostname>");
            }
            /* đối số dòng lệnh sẽ được tạo ra khi mình chạy trên command line: java PhanLoaiDCIP  <Hostname> (Hostname ở đây là args)*/
            // InetAddress dc = InetAddress.getByName(args[0]);
            
            InetAddress dc =InetAddress.getByName("www.microsoft.com");
            String hostName = dc.getHostName();
            System.out.println("Host name:" + hostName);
            System.out.println("Dia chi IP:" + dc.getHostAddress());
            byte[] b = dc.getAddress();
            int i = b[0] >= 0 ? b[0] : 256 + b[0];
            if ((i >= 1) && (i <= 126))
                System.out.println(dc + " thuoc dia chi lop A");
            if ((i <= 191) && (i >= 128))
                System.out.println(dc + " thuoc dia chi lop B");
            if ((i <= 223) && (i >= 192))
                System.out.println(dc + " thuoc dia chi lop C");
        } catch (UnknownHostException e) {
            System.out.println("Khong tim thay dia chi");
            return;
        }
    }

}
