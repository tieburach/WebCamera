package sample.LightModel.Controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {


    private static StringBuilder sb = new StringBuilder("");

    public static void log(String string){
        sb.append(string);
    }

    public static void onExit(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM_HH;mm");
        Date date = new Date();
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("logs" + formatter.format(date) + ".txt"));
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
