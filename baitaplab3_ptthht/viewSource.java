package baitaplab3_ptthht;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class viewSource {
    /*
     * theo em hiểu như trong vd : Viết chương trình nhập một URL từ bàn phím, kết
     * nối với Internet và hiển thị mã nguồn của trang Web đó lên màn hình thì không
     * phải truyền đối số dòng lệnh như những ví dụ trước nên em làm khác code của
     * cô
     */
    public static void main(String[] args) {
        URL url;
        String thisLine;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao 1 URL (Vui long nhap dung dang URL: https:// + <hostname>):");
        String inputURL = sc.nextLine();
        System.out.println(inputURL.length());
        try {
            url = new URL(inputURL);
            try {
                DataInputStream dataInputStream = new DataInputStream(url.openStream());
                while ((thisLine = dataInputStream.readLine()) != null)
                    System.out.println(thisLine);
                // System.out.println(url.openStream());
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

/* code trang của cô */
// URL u;
// String thisLine;
// if(args.length>0){
// try{
// u = new URL(args[0]);
// try{
// BufferedReader br = new BufferedReader(new
// InputStreamReader(u.openStream())); //thay the cho DataInputStream
// while((thisLine = br.readLine())!= null)
// System.out.println(thisLine);
// }
// catch(IOException e)
// {
// System.err.println(e);
// }
// }
// catch(MalformedURLException e){
// System.err.println(e);
// }
// }
