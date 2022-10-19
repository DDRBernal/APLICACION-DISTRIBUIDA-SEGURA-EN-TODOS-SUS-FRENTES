package co.edu.escuelaing.sparkdockerdemolive;

import static spark.Spark.get;
import static spark.Spark.port;
//co.edu.escuelaing.sparkdockerdemolive.SparkWebServer.java
public class SparkWebServer {

    //server.port=8081
    public static void main(String... args){
        port(getPort());
        System.out.println(getPort());
        get("hello", (req,res) -> "Hello hello!");
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
