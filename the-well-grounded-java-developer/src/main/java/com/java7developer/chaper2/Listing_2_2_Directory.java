package main.java.com.java7developer.chaper2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * process directories and directory trees
 * @author kingdomdong
 * @since 2020-05-05 20:00:55
 * @version 1.0
 */
public class Listing_2_2_Directory {

    public static void main(String[] args) {
        /**
         * output:
         * develop_menu.sql
         * develop_menu_2020-04-29.sql
         * release_sys_menu.sql
         * robot_platform_sys_menu.sql
         * staff.sql
         */
        Path dir = Paths.get("/Users/kingdomdong/Documents/dumps");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.{sql, pdf}")) {
            for (Path entry : stream) {
                System.out.println(entry.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
