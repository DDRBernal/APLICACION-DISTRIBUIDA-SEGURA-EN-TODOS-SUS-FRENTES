package co.edu.escuelaing.sparkdockerdemolive;

import static spark.Spark.*;


//co.edu.escuelaing.sparkdockerdemolive.SparkWebServer.java
public class SparkWebServer {

    //server.port=8081
    public static void main(String... args){
        port(getPort());
        staticFileLocation("/files");
        System.out.println(getPort());
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath, truststorePassword);
        secure("keystores/ecikeystore.p12", "12345678", null, null);
        get("hello", (req,res) -> "Hello Spark!");
        post("/checkLogin", (req,res) -> {
            String[] response = parseJson(req.body());
            boolean loged = Control_access.verifyCredentials(response[1]);
            return loged;
        });
    }

    /**
     * This method received a string in format json and return the user and the password given
     * @param string
     * @return
     */
    public static String[] parseJson(String string){
        String[] response = new String[2];
        String[] list = string.split(",");
        String user = list[0].replace("{ \"name\": ","");
        String password = string.replace("{ \"name\": ","").replace(",\"password\": ","").replace("}","");
        if (user.equals(password)) password=user+"none";
        response[0] = user;
        response[1] = password;
        return response;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }
}

//keytool -genkeypair -alias ecikeypair -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore ecikeystore.p12 -validity 3650