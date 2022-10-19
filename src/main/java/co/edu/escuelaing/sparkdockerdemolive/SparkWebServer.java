package co.edu.escuelaing.sparkdockerdemolive;

import static spark.Spark.*;

//co.edu.escuelaing.sparkdockerdemolive.SparkWebServer.java
public class SparkWebServer {

    //server.port=8081
    public static void main(String... args){
        port(getPort());
        System.out.println(getPort());
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath, truststorePassword);
        secure("keystores/ecikeystore.p12", "12345678", null, null);
        get("hello", (req,res) -> "Hello Spark!");
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }
}

//keytool -genkeypair -alias ecikeypair -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore ecikeystore.p12 -validity 3650