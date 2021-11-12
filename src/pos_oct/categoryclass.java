package pos_oct;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;


public class categoryclass {

    public static String category[]={"Electronics","Beauty","Dairy Products","Stationary","Grocery"};
    static String savefile(String path) {
        File f = new File(path);
        try {
            FileInputStream fis = new FileInputStream(f);
//            String fname=new Date().getTime()+"";
            String extension = path.substring(path.lastIndexOf("."));
            System.out.println("Extension" + extension);
            String fpath = "src/uploads/" + new Date().getTime() + "" + extension;
            FileOutputStream fos = new FileOutputStream(fpath);
            long fsize = f.length();
            int r = 0, count = 0;
            byte b[] = new byte[100000];
            while (true) {
                r = fis.read(b, 0, b.length);
                fos.write(b, 0, r);
                count = count + r;
                if (count == fsize) {
                    break;
                }

            }
            System.out.println("File copied");
            return fpath;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
