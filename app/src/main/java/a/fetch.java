package a;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

class fetch extends AsyncTask{
    String pattern = "mpop.revii.chatapp.AUTHENTICATION";

    @Override
    protected Object doInBackground(Object[] objects) {
        String result = "{\"statusCode\": 404, \"messsage\": \"Server Fetch Error\"}";
        try{
            URL fetch_url = new URL("https://chatapp.mpoprevii.repl.co/fetchdata?key=" + pattern);
            URLConnection url = fetch_url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.getInputStream()));
            String s = "";
            while((s = reader.readLine()) != null){
                result += s;
                break;
            }
            return s;
        }catch (Exception e){}
        return result;
    }
}