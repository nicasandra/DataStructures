package third;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Nick on 11/13/2016.
 */
public class Util {

    public static String fromFileToString(String fileName) {
        try {
            RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
            StringBuffer buff = new StringBuffer();
            String line = "";
            while ((line = raf.readLine()) != null) {
                buff.append(line);
            }
            return buff.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
