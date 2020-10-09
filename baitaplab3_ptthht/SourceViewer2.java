package baitaplab3_ptthht.lamviecvoiURLConnection;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;



public class SourceViewer2 {
    public static void main(String[] args) {
        URL url;
        URLConnection urlConnection;
        if (args.length > 0) {
            try {
            //Open the URLConnection for reading
            url = new URL(args[0]);
            urlConnection = url.openConnection( );
            InputStream raw = urlConnection.getInputStream( );
            InputStream buffer = new BufferedInputStream(raw);
            // chain the InputStream to a Reader
            Reader read = new InputStreamReader(buffer);
            int ch;
            while ((ch = read.read( )) != -1) {
            System.out.print((char) ch);
            }
            }
            catch (MalformedURLException ex) {
            System.err.println(args[0] + " is not a parseable URL");
            }
            catch (IOException ex) {
            System.err.println(ex);
            }
        }
    }
}
