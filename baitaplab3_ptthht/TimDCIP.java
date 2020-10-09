package baitaplab3_ptthht;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TimDCIP {
    public static void main(String[] args) {
        try{
            /* đối số dòng lệnh sẽ được tạo ra khi mình chạy trên command line: java TimDCIP  <Hostname> (Hostname ở đây là args)*/
            InetAddress dc = InetAddress.getByName(args[0]);

            // vì thế nên em thay thế bằng cách getByName 1 cái chuỗi luôn
            // InetAddress dc =InetAddress.getByName("www.google.com");
            String hostName = dc.getHostName();
            System.out.println("dia chi cua microsoft" + dc);
            System.out.println("Host name:" + hostName);
        }catch(UnknownHostException e) {
            System.err.println(e);
        }
    }
}
