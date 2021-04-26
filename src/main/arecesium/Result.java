package main.arecesium;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public class Result {

    class Holding {
        private String date;
        private String security;
        private int quantity;
        private String portfolio;

    }

    class Price {
        private String date;
        private String security;
        private double price;
    }

//    public static double calculateNAV(String date) {
//
//    }

    private String getAPI(String httpUrl) {
        HttpURLConnection con = null;
        try {
            URL url = new URL(httpUrl);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            return content.toString();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) con.disconnect();
        }

        return null;
    }


//    private Map<String, Holding> getHoldings() {
//        String url = "https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/holding";
//        String response = getAPI(url);
//
//        AuthMsg msg = new Gson().fromJson(data, AuthMsg.class);
//        System.out.println(msg);
//
//
//    }
}
