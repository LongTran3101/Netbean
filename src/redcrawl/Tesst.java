/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redcrawl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Base64;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author me
 */
public class Tesst {

    public static void main(String[] args) {
        POSTDTO b=new POSTDTO();
        POSTDTO.param a = b.new param();
        a.setMessageRequest("Lorem dolore");
        a.setType("dolore cillum tempor et");
        a.setDocumentName("amet eu");
        a.setClientID("elit esse proident amet");
        a.setCustomerId("aute laboris do");
        a.setCustomerName("ad pariatur Lorem");
        a.setBussiness("adipisicing occaecat veni");
        a.setFolderBy("exercitati");
        a.setFolderAt("1960-07-04");
        a.setFolderId("in sit");
        a.setFolderClass("amet proident fugiat aute adipisicing");
        a.setBatchStore("esse culpa tempor");
        a.setUsername("sit laborum");
        b.setInput(a);
        
         Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String bodyKey = gson.toJson(b);
            System.out.println(bodyKey);

        String mess = "{\n" +
"  \"input\": {\n" +
"    \"messageRequest\": \"tempor id dolore\",\n" +
"    \"type\": \"laborum Duis\",\n" +
"    \"documentName\": \"quis dolore sunt\",\n" +
"    \"clientID\": \"eu\",\n" +
"    \"customerId\": \"ad ea\",\n" +
"    \"customerName\": \"Lorem esse eu\",\n" +
"    \"business\": \"id dolor Ut in\",\n" +
"    \"folderBy\": \"labore commodo dolore eu\",\n" +
"    \"folderAt\": \"1959-02-14\",\n" +
"    \"folderId\": \"commodo officia\",\n" +
"    \"folderClass\": \"incididunt in culpa Duis\",\n" +
"    \"batchStore\": \"aliquip ut Lorem voluptate consequat\",\n" +
"    \"username\": \"ea in officia dolor occaecat\"\n" +
"  }\n" +
"}";
        String ccccc = callAPIPost("https://192.168.10.124:9443/automationservices/rest/SSIOA/api/createWHECM", mess);
        System.out.println(ccccc);
    }

    public static String callAPIPost(String completeUrl, String body) {
        try {
            int CONNECTION_TIMEOUT_MS = 60000;
            int LATENT_CONNECTION_TIMEOUT_MS = 60000;
            String encoding = Base64.getEncoder().encodeToString(
                    ("bpmadmin" + ":" + "bpm123").getBytes()
            );
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }};
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());

            CloseableHttpClient client = HttpClientBuilder.create().setSSLContext(sc).build();
            RequestConfig config = RequestConfig.custom().setConnectTimeout(CONNECTION_TIMEOUT_MS)
                    .setConnectionRequestTimeout(CONNECTION_TIMEOUT_MS).setSocketTimeout(CONNECTION_TIMEOUT_MS).build();
            HttpPost httppost = new HttpPost(completeUrl);
            try {
                httppost.setHeader("Content-Type", "application/json;charset=UTF-8");
                httppost.setHeader("Authorization", "Basic " + encoding);
                httppost.setConfig(config);
                StringEntity stringEntity = new StringEntity(body, "UTF-8");
                httppost.getRequestLine();
                httppost.setEntity(stringEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }
            CloseableHttpResponse response = client.execute(httppost);
            if (response.getStatusLine().getStatusCode() >= 300) {
                throw new IOException(String.format("failure - received a %d for %s.",
                        response.getStatusLine().getStatusCode(), httppost.getURI().toString()));
            }
            HttpEntity entity = response.getEntity();

            // StringWriter writer = new StringWriter();
            // IOUtils.copy(entity.getContent(), writer);
            return EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
