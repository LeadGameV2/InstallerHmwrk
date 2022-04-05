import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Installer {

    public static void install() {

        StringBuilder log = new StringBuilder();

        File mainDirectory = new File("C://DistinctProjects/Games");

        File srcDir = new File(mainDirectory + "/src");
        File resDir = new File(mainDirectory + "/res");
        File saveDir = new File(mainDirectory + "/savegames");
        File tempDir = new File(mainDirectory + "/temp");

        File mainDir = new File(srcDir + "/main");
        File testDir = new File(srcDir + "/test");

        File drawDir = new File(resDir + "/drawables");
        File vectorsDir = new File(resDir + "/vectors");

        File mainFile = new File(mainDir + "/Main.java");
        File utilFile = new File(mainDir + "/Utils.java");

        File tempFile = new File(tempDir + "/temp.txt");

        List<File> installation = new ArrayList<>(Arrays.asList(
                srcDir, resDir, saveDir, tempDir, mainDir, testDir, drawDir, vectorsDir, mainFile, utilFile, tempFile
        ));

        installation.stream().filter(x -> !x.getPath().contains("."))
                .forEach(x -> {
                    if (x.mkdir()) {
                        log.append(x + " Installed" + "\n");
                    } else {
                        log.append(x + " Installation failed" + "\n");
                    }
                });

        installation.stream().filter(x -> x.getPath().contains("."))
                .forEach(x -> {
                    try {
                        if (x.createNewFile())
                            log.append(x + " Installed" + "\n");
                    } catch (IOException exception) {
                        log.append(exception.getMessage() + "\n");
                    }
                });

        try (FileWriter write = new FileWriter(tempFile)) {
            write.write(log.toString());
            write.flush();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        };
    }
}
