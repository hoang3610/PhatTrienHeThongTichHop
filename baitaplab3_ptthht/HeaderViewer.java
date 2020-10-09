package baitaplab3_ptthht.lamviecvoiURLConnection;
//thu vien
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;

public class HeaderViewer {
    public static void main(String[] args) {
        URL url;
        URLConnection urlConnection;
        if (args.length > 0) {
            try {
            //Open the URLConnection for reading
            url = new URL(args[0]);
            urlConnection = url.openConnection( );
            System.out.println("Content-type: " + urlConnection.getContentType( ));
            System.out.println("Contentencoding: " + urlConnection.getContentEncoding());
            System.out.println("Date: " + new Date(urlConnection.getDate( )));
            System.out.println("Last modified: " + new Date(urlConnection.getLastModified()));
            System.out.println("Expiration date: " + new Date(urlConnection.getExpiration()));
            System.out.println("Content-length: " + urlConnection.getContentLength( ));
            }catch (MalformedURLException ex) {
                System.err.println(args[0] + " is not a parseable URL");
            }
            catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}
