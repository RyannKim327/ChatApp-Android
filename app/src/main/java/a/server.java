package a;
import android.os.AsyncTask;
import java.net.URLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class server extends AsyncTask {
    String _URL = "https://chatapp.mpoprevii.repl.co/mpopapi";
    String pattern = "mpop.revii.chatapp.AUTHENTICATION";
    @Override
    protected Object doInBackground(Object[] p1) {
        String method = p1[0].toString();
        String result = "";
        if(method.equalsIgnoreCase("login")){
            String user = p1[1].toString();
            String pass = p1[2].toString();
            try {
                URL url = new URL(_URL);
                URLConnection con = url.openConnection();
                String data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8");
                data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");
                data += "&" + URLEncoder.encode("KEY", "UTF-8") + "=" + URLEncoder.encode(pattern);
                con.setDoOutput(true);
                OutputStreamWriter write = new OutputStreamWriter(con.getOutputStream());
                write.write(data);
                write.flush();
                BufferedReader read = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String s = "";
                while((s = read.readLine()) != null){
                    result += s;
                    break;
                }
            } catch (Exception e) {}
        }
        return result;
    }
}
