package fr.carchop.api.converter;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpHandler {
    public HttpHandler() {
    }

    public String makeServiceCall(String reqUrl) {


        String response = null;
        try {
            URL url = new URL(reqUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/12.0.2 Safari/605.1.15");
            conn.setRequestMethod("GET");
            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            response = convertStreamToString(in);
        } catch (MalformedURLException e) {
            return "Error";
        } catch (ProtocolException e) {
            return "Error";
        } catch (IOException e) {
            return "Error";
        } catch (Exception e) {
            return "Error";
        }
        return response;
    }


    private String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        String lines = sb.toString();
        StringBuffer sbs = new StringBuffer();
        boolean trouve = false;
        for (int i = 0; i < lines.length(); i++) {
            if(lines.charAt(i)=='{' && trouve==false) {
                trouve=true;
            }
            if(trouve==true) {
                sbs.append(lines.charAt(i));
            }

        }
        return sbs.toString();
    }

}
