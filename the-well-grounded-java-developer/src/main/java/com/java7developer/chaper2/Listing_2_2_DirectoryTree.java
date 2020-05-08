package main.java.com.java7developer.chaper2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * iterate directory tree recursively
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-05-05 21:44:17
 */
public class Listing_2_2_DirectoryTree {

    public static void main(String[] args) throws IOException {
        /**
         * output:
         * /Users/kingdomdong/Documents/dumps/develop_menu.sql
         * /Users/kingdomdong/Documents/dumps/develop_menu_2020-04-29.sql
         * /Users/kingdomdong/Documents/dumps/release_sys_menu.sql
         * /Users/kingdomdong/Documents/dumps/robot_platform_sys_menu.sql
         * /Users/kingdomdong/Documents/dumps/staff.sql
         * /Users/kingdomdong/Documents/Major_Backup/alter table auto_increment.sql
         * /Users/kingdomdong/Documents/Major_Backup/ams_device_module_2019_12_20.sql
         * /Users/kingdomdong/Documents/Major_Backup/grammer.sql
         * /Users/kingdomdong/Documents/Tech/Technology/findStationsNearby.sql
         * /Users/kingdomdong/Documents/Tech/Technology/getNearbyAssets.sql
         * /Users/kingdomdong/Documents/Tech/Technology/getsonpercinct.sql
         */
        Path startingDir = Paths.get("/Users/kingdomdong/Documents");
        Files.walkFileTree(startingDir, new FindJavaVisitor());
    }

    private static class FindJavaVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toString().endsWith(".sql")) {
                System.out.println(file.toAbsolutePath());
            }
            return super.visitFile(file, attrs);
        }
    }
}
