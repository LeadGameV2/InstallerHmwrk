import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Installer.install();

        GameProgress char1 = new GameProgress(3,6,3,1.1);
        GameProgress char2 = new GameProgress(2,5,9,4.7);
        GameProgress char3 = new GameProgress(1,9,5,3.1);

        List<String> saves = new ArrayList<>(Arrays.asList(
                "C://DistinctProjects/Games/savegames/char1.dat",
                "C://DistinctProjects/Games/savegames/char2.dat",
                "C://DistinctProjects/Games/savegames/char3.dat"
        ));
        Save.saveGame(saves.get(0), char1);
        Save.saveGame(saves.get(1), char2);
        Save.saveGame(saves.get(2), char3);

        Save.zipSaves("C://DistinctProjects/Games/savegames/saves.zip", saves);

    }
}
