package fr.carchop.api.converter;


import org.json.JSONException;
import org.json.JSONObject;
import java.text.DecimalFormat;

public class Converter {


    private String jsonStr;
    private String urlApi;
    private HttpHandler sh;

    public Converter() {
        sh = new HttpHandler();
        this.urlApi = "http://data.fixer.io/api/latest?access_key=cb4cf0a8129f32887f9612e13daa5768&format=1";
        jsonStr = sh.makeServiceCall(urlApi);
    }

    public double ConvertFromEuro(String devise,double m) {
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                boolean etat = jsonObj.getBoolean("success");
                if(etat==false) {

                    jsonStr = sh.makeServiceCall(urlApi);
                    jsonObj = new JSONObject(jsonStr);
                }
                JSONObject rates =  new JSONObject(jsonObj.get("rates").toString());
                double money = rates.getDouble(devise)*m;
                DecimalFormat df = new DecimalFormat("########.00");
                String str = df.format(money);
                money = Double.parseDouble(str.replace(',', '.'));
                return money;
            } catch (final JSONException e) {
                return m;
            }
        }
        return m;
    }

    public double getRateFromDevise(String devise) {
        double rate=0.0;
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                boolean etat = jsonObj.getBoolean("success");
                if(etat==false) {
                    jsonStr = sh.makeServiceCall(urlApi);
                    jsonObj = new JSONObject(jsonStr);
                }
                JSONObject rates =  new JSONObject(jsonObj.get("rates").toString());
                rate = rates.getDouble(devise);
                return rate;
            } catch (final JSONException e) {
                return rate;
            }
        }
        return rate;
    }

}
