import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Save {

   public static void saveGame(String file, GameProgress save) {

       try (FileOutputStream out = new FileOutputStream(file)) {
           ObjectOutputStream obj = new ObjectOutputStream(out);
           obj.writeObject(save);
       } catch (IOException exception) {
           System.out.println(exception.getMessage());
       };
   }

   public static void zipSaves(String dir, List<String> bruh) {

       try (ZipOutputStream zOut = new ZipOutputStream(new FileOutputStream(dir) )) {
           for (String i:bruh) {
               FileInputStream input = new FileInputStream(i);
               ZipEntry entry = new ZipEntry(i.substring(i.length() - 9));
               zOut.putNextEntry(entry);
               zOut.write(input.read());
           }
           zOut.closeEntry();
       } catch (IOException exception) {
           System.out.println(exception.getMessage());
       }
   }
}
