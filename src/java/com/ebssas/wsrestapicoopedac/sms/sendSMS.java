/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.sms;

import com.ebssas.wsrestapicoopedac.service.ParametroServiceBean;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author Brayan F Silva R
 */
public class sendSMS {

    private String sURL_API = "", sCredAuthApi = "";
    private String sAcount = "", sApiKey = "", sToken = "";

    HttpClient client = new DefaultHttpClient();

    public sendSMS() {
        //this.sURL_API = new ParametroServiceBean().obtenerParametroPorNombre("URL_API_SMS");
        this.sCredAuthApi = new ParametroServiceBean().obtenerParametroPorNombre("CRED_AUTH_API_SMS");
        if (sCredAuthApi != null && !sCredAuthApi.isEmpty()) {
            String sSplit[] = sCredAuthApi.split(";");
            if (sSplit != null && sSplit.length > 0) {
                sAcount = sSplit[0];
                sApiKey = sSplit[1];
                sToken = sSplit[2];
            }
        }
    }

    public ResponseSendSMSV3 envioSMS_SencilloV3(String sIndicativo, String sNumCel, String sTxtMsj, String prioridad) {
        ResponseSendSMSV3 responseSendSMS = new ResponseSendSMSV3();
        String sJSONResponse = "";
        try {
            RequestSMS requestSMS = new RequestSMS();
            requestSMS.setToNumber(sIndicativo + sNumCel);
            requestSMS.setSms(sTxtMsj);

            HttpPost httpPostEnvioSms = null;

            if (prioridad.equals("1")) {
                this.sURL_API = new ParametroServiceBean().obtenerParametroPorNombre("URL_API_SMS_P");
                httpPostEnvioSms = new HttpPost(sURL_API);
            } else {
                this.sURL_API = new ParametroServiceBean().obtenerParametroPorNombre("URL_API_SMS_M");
                httpPostEnvioSms = new HttpPost(sURL_API);
            }

            String sJSONEnvioSms = new Gson().toJson(requestSMS);
            StringEntity entity = new StringEntity(sJSONEnvioSms);

            httpPostEnvioSms.setEntity(new StringEntity(sJSONEnvioSms, "UTF-8"));
            httpPostEnvioSms.setHeader("account", sAcount);
            httpPostEnvioSms.setHeader("apikey", sApiKey);
            httpPostEnvioSms.setHeader("token", sToken);
            httpPostEnvioSms.setHeader("Accept-Encoding", "gzip, deflate, br");
            httpPostEnvioSms.setHeader("Accept", "*/*");
            httpPostEnvioSms.setHeader("Content-Type", "application/json");

            HttpResponse response = client.execute(httpPostEnvioSms);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            while ((line = rd.readLine()) != null) {
                sJSONResponse = sJSONResponse.trim() + line.trim();
            }

            if (sJSONResponse != null && !sJSONResponse.equals("")) {
                if (!sJSONResponse.equals("\"error\"")) {
                    responseSendSMS = new Gson().fromJson(sJSONResponse, ResponseSendSMSV3.class);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            responseSendSMS = null;
        }

        return responseSendSMS;
    }

//    public ResponseSendSMSV3 envioSMS_MasivoV3(String  Numero, String sTxtMsj, String sms) {
//        ResponseSendSMSV3 responseSendSMS = new ResponseSendSMSV3();
//        String sJSONResponse = "";
//        
//        RequestSMSMasivo requestSMS = new RequestSMSMasivo();
//        requestSMS.setBulk(bulk);
//        
//        
//        try {
////            URL url = new URL(sURL_API);
////            Map<String, Object> params = new LinkedHashMap<>();
////            String sNumCel = Numeros[0];
////            for (int i = 1; i < Numeros.length; i++) {
////                sNumCel = sNumCel + "," + Numeros[i];
////            }
////            params.put("account", sAcount);
////            params.put("apiKey", sApiKey);
////            params.put("token", sToken);
////            params.put("toNumber", sNumCel);
////            params.put("sms", sTxtMsj);
////            params.put("isPriority", prioridad);
//            HttpPost httpPostEnvioSms = null;
//
//            if (prioridad.equals("1")) {
//                this.sURL_API = new ParametroServiceBean().obtenerParametroPorNombre("URL_API_SMS_P");
//                httpPostEnvioSms = new HttpPost(sURL_API);
//            } else {
//                this.sURL_API = new ParametroServiceBean().obtenerParametroPorNombre("URL_API_SMS_M");
//                httpPostEnvioSms = new HttpPost(sURL_API);
//            }
//
//            httpPostEnvioSms.setEntity(entity);
//            httpPostEnvioSms.setHeader("account", sAcount);
//            httpPostEnvioSms.setHeader("apikey", sApiKey);
//            httpPostEnvioSms.setHeader("token", sToken);
//            HttpResponse response = client.execute(httpPostEnvioSms);
//
//            StringBuilder postData = new StringBuilder();
//            for (Map.Entry<String, Object> param : httpPostEnvioSms.entrySet()) {
//                if (postData.length() != 0) {
//                    postData.append('&');
//                }
//                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
//                postData.append('=');
//                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
//            }
//            byte[] postDataBytes = postData.toString().getBytes("UTF-8");
//
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("POST");
//            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
//            conn.setDoOutput(true);
//            conn.getOutputStream().write(postDataBytes);
////            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
////            String line;
//             BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//             String line;
////            while ((line = rd.readLine()) != null) {
////                rtaEvioSMS = rtaEvioSMS.trim() + line.trim();
////            }
////
////            if (rtaEvioSMS != null && !rtaEvioSMS.equals("")) {
////                responseSendSMS = new Gson().fromJson(rtaEvioSMS, ResponseSendSMSv2_1.class);
////
////            }
//              while ((line = rd.readLine()) != null) {
//                sJSONResponse = sJSONResponse.trim() + line.trim();
//            }
//
//            if (sJSONResponse != null && !sJSONResponse.equals("")) {
//                if (!sJSONResponse.equals("\"error\"")) {
//                    responseSendSMS = new Gson().fromJson(sJSONResponse, ResponseSendSMSV3.class);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Error " + e.getMessage());
//            responseSendSMS = null;
//        }
//
//        System.out.println("response " + responseSendSMS.getStatus());
//        return responseSendSMS;
//    }
    public ResponseSendSMS envioSMS_Sencillo(String sIndicativo, String sNumCel, String sTxtMsj, String prioridad) {
        ResponseSendSMS responseSendSMS = new ResponseSendSMS();
        String rtaEvioSMS = "";
        try {
            URL url = new URL("https://api.hablame.co/sms/envio/");
            Map<String, Object> params = new LinkedHashMap<>();

            params.put("cliente", "10013292");
            params.put("api", "fceNDmNiH8Onw8DjmTN6uCzd1Afazu");
            params.put("numero", sIndicativo + sNumCel);
            params.put("sms", sTxtMsj);
            params.put("fecha", "");
            params.put("referencia", "EBS");

            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postData.length() != 0) {
                    postData.append('&');
                }
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = rd.readLine()) != null) {
                rtaEvioSMS = rtaEvioSMS.trim() + line.trim();
            }

            if (rtaEvioSMS != null && !rtaEvioSMS.equals("")) {
                responseSendSMS = new Gson().fromJson(rtaEvioSMS, ResponseSendSMS.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseSendSMS = null;
        }

        return responseSendSMS;
    }

    public ResponseSendSMS envioSMS_Masivo(String[] Numeros, String sTxtMsj) {
        ResponseSendSMS responseSendSMS = new ResponseSendSMS();
        String rtaEvioSMS = "";
        try {
            URL url = new URL("https://api.hablame.co/sms/envio/");
            Map<String, Object> params = new LinkedHashMap<>();
            String sNumCel = Numeros[0];
            for (int i = 1; i < Numeros.length; i++) {
                sNumCel = sNumCel + "," + Numeros[i];
            }
            params.put("cliente", "10013292");
            params.put("api", "fceNDmNiH8Onw8DjmTN6uCzd1Afazu");
            params.put("numero", sNumCel);
            params.put("sms", sTxtMsj);
            params.put("fecha", "");
            params.put("referencia", "EBS");

            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postData.length() != 0) {
                    postData.append('&');
                }
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = rd.readLine()) != null) {
                rtaEvioSMS = rtaEvioSMS.trim() + line.trim();
            }

            if (rtaEvioSMS != null && !rtaEvioSMS.equals("")) {
                responseSendSMS = new Gson().fromJson(rtaEvioSMS, ResponseSendSMS.class);

            }
        } catch (Exception e) {
            e.printStackTrace();
            responseSendSMS = null;
        }

        return responseSendSMS;
    }
    
    
    public void generarToken() {

        String sJSONResponse = "";
        try {
            
            Login login = new Login();
            login.setUsuario("tzora");
            login.setClave("12345678");

            // URL url = new URL(sURL_API);
            //Map<String, Object> params = new LinkedHashMap<>();
            HttpPost httpPost = null;
            httpPost = new HttpPost("https://coogranadawebapitest.coogranada.com.co/GenerarToken");

            String sJSONEnvioSms = new Gson().toJson(login);

            httpPost.setEntity(new StringEntity(sJSONEnvioSms, "UTF-8"));
//            httpPost.setHeader("account", sAcount);
//            httpPost.setHeader("apikey", sApiKey);
//            httpPost.setHeader("token", sToken);
            httpPost.setHeader("Accept-Encoding", "gzip, deflate, br");
            httpPost.setHeader("Accept", "*/*");
            httpPost.setHeader("Content-Type", "application/json");

            HttpResponse response = client.execute(httpPost);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            while ((line = rd.readLine()) != null) {
                sJSONResponse = sJSONResponse.trim() + line.trim();
            }

//            if (sJSONResponse != null && !sJSONResponse.equals("")) {
//                if (!sJSONResponse.equals("\"error\"")) {
//                    responseSendSMS = new Gson().fromJson(sJSONResponse, ResponseSendSMSV3.class);
//                }
//            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error " + e.getMessage());
        }

    }
    
    
    public void listarPaises() {

        String sJSONResponse = "";
        try {
            
//            Login login = new Login();
//            login.setUsuario("tzora");
//            login.setClave("12345678");

            // URL url = new URL(sURL_API);
            //Map<String, Object> params = new LinkedHashMap<>();
            HttpGet httpGet = null;
            httpGet = new HttpGet("https://coogranadawebapitest.coogranada.com.co/ListaPaises");

//            String sJSONEnvioSms = new Gson().toJson(login);
//            StringEntity entity = new StringEntity(sJSONEnvioSms);

//            httpPost.setEntity(new StringEntity(sJSONEnvioSms, "UTF-8"));
//            httpPost.setHeader("account", sAcount);
            httpGet.setHeader("User", "TZORA");
            httpGet.setHeader("token", "HEUYLGHBVSCRKPPWILZIGHDAMPXRIILUDYWUTNEBKRQDPVLXZR");
            httpGet.setHeader("Accept-Encoding", "gzip, deflate, br");
            httpGet.setHeader("Accept", "*/*");
            httpGet.setHeader("Content-Type", "application/json");

            HttpResponse response = client.execute(httpGet);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            while ((line = rd.readLine()) != null) {
                sJSONResponse = sJSONResponse.trim() + line.trim();
                
            }

//            if (sJSONResponse != null && !sJSONResponse.equals("")) {
//                if (!sJSONResponse.equals("\"error\"")) {
//                    responseSendSMS = new Gson().fromJson(sJSONResponse, ResponseSendSMSV3.class);
//                }
//            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error " + e.getMessage());
        }

    }
    
    public static void main(String[] args) {
        sendSMS api = new sendSMS();
        ResponseSendSMSV3 a = api.envioSMS_SencilloV3("57", "3187905455", "prueba", "0");
        System.out.println(a.getStatus());
        System.out.println(a.getAccount());
        System.out.println(a.getSms());
        System.out.println(a.getExecution_time());
    }

}
