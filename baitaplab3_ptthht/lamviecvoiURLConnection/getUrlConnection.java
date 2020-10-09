package baitaplab3_ptthht.lamviecvoiURLConnection;
//Thu vien
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class getUrlConnection {
    public static void main(String[] args) {
        URL url;
        URLConnection urlConnection;
        try {
            url = new URL("http://iuh.edu.vn");
            try {
                urlConnection = url.openConnection();
                System.out.println(urlConnection);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } 
    }
}
