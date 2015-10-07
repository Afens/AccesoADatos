import java.io.File;
import java.io.IOException;

/**
 * Created by Afens on 06/10/2015.
 */
public class Pr002 {
    public static void main(String[] args) {
        File dir = new File("Dir");
        File subdir = new File(dir,"Subdir");
        File file1 = new File(dir, "File1.txt");
        File file2 = new File(dir, "File2.txt");
        File file3 = new File(dir, "File3.txt");
        File fileSub = new File(subdir, "FileSub.txt");
        String arr[];
        dir.mkdir();
        subdir.mkdir();
        try {
            file1.createNewFile();
            file2.createNewFile();
            file3.createNewFile();
            fileSub.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        file1.renameTo(new File(dir,"F1Renombrado.txt"));
        file3.delete();

        System.out.println(dir.getAbsolutePath());
        arr=dir.list();
        for(int i=0;i<arr.length ;i++){
            System.out.println(arr[i]);
        }

        System.out.println(subdir.getAbsolutePath());
        arr=subdir.list();
        for(int i=0;i<arr.length ;i++){
            System.out.println(arr[i]);
        }
    }
}
