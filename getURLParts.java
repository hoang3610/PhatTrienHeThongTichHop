package baitaplab3_ptthht;

import java.net.MalformedURLException;
import java.net.URL;

public class getURLParts {
    public static void main(String[] args) {
        try {
            /* đối số dòng lệnh sẽ được tạo ra khi mình chạy trên command line: java getURLParts  <Hostname> (Hostname ở đây là args)*/
            // URL u = new URL(args[0]);

            URL u = new URL("https://www.facebook.com/");
            System.out.println("URL is " + u);
            System.out.println("The protocol part is " + u.getProtocol());
            System.out.println("The host part is " + u.getHost());
            System.out.println("The file part is " + u.getFile());
            System.out.println("The reference part is " + u.getRef());
        } catch (MalformedURLException e) {
            System.err.println(e);
        }
    }

}
