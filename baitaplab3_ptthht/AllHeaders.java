package baitaplab3_ptthht.lamviecvoiURLConnection;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;



public class AllHeaders {
    public static void main(String[] args) {
        URL url;
        URLConnection urlConnection;
        if (args.length > 0) {
            try {
            //Open the URLConnection for reading
            url = new URL(args[0]);
            urlConnection = url.openConnection( );
            for (int j = 1; ; j++) {
                String header = urlConnection.getHeaderField(j);
                if (header == null) break;
                System.out.println(urlConnection.getHeaderFieldKey(j) + ": " + header);
                }
            }catch (MalformedURLException ex) {
                System.err.println(args[0] + " is not a parseable URL");
            }
            catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}
