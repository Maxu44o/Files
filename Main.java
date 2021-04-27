import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        File games = new File("D://Games");
        sb.append("Dirictory: " + games.getName() + " exists \n");


        String src = "D://Games//src";
        String res = "D://Games//res";
        String savegames = "D://Games//savegames";
        String tmp = "D://Games//tmp";

        String main = "D://Games//src//main";
        String test = "D://Games//src//test";

        String draw = "D://Games//res//drawables";
        String vect = "D://Games//res//vectors";
        String icon = "D://Games//res//icons";

        String tempf = "D://Games//tmp//Temp.txt";
        String mainf = "D://Games//src//main//Utils.java";
        String utilsf = "D://Games//tmp//Temp.txt";


        createFolder(src, sb);
        createFolder(res, sb);
        createFolder(savegames, sb);
        createFolder(tmp, sb);

        createFolder(main, sb);
        createFolder(test, sb);

        createFolder(draw, sb);
        createFolder(vect, sb);
        createFolder(icon, sb);


        createFile(mainf, sb);
        createFile(utilsf, sb);
        createFile(tempf, sb);


        System.out.println(sb);

        try (FileWriter fw = new FileWriter(tempf)) {
            fw.write(String.valueOf(sb));
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createFolder(String dirpath, StringBuilder sb) {
        File file = new File(dirpath);
        if (file.mkdir()) sb.append(file.getName() + " created \n");

    }

    private static void createFile(String dirpath, StringBuilder sb) {
        File file = new File(dirpath);

        try {
            if (file.createNewFile()) sb.append("File: " + file.getName() + " was created at " + new Date() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
