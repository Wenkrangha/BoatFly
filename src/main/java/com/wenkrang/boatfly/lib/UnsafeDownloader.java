package com.wenkrang.boatfly.lib;

import javax.net.ssl.HttpsURLConnection;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class UnsafeDownloader {
    public static void downloadFile(String urlString, String destinationFile) throws Exception {
        // 创建URL对象
        URL url = new URL(urlString);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

        // 绕过SSL验证
        try {
            connection.setHostnameVerifier((hostname, session) -> true);
            javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
            sc.init(null, new javax.net.ssl.TrustManager[]{new MyTrustManager()}, null);
            connection.setSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            ConsoleLogger.error(e);
        }

        try (final InputStream in = connection.getInputStream();
             final FileOutputStream out = new FileOutputStream(destinationFile)) {
            byte[] buffer = new byte[1024];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
        }
    }

    public static class MyTrustManager implements javax.net.ssl.X509TrustManager {
        @Override
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        @Override
        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
        }

        @Override
        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
        }
    }
}
