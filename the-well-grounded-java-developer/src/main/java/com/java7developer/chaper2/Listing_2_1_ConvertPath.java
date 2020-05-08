package main.java.com.java7developer.chaper2;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * convert Path
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-05-05 20:06:31
 */
public class Listing_2_1_ConvertPath {

    private static String firstPathName = "/User/kingdomdong/";
    private static String secondPathName = "Documents/dumps/out.pdf";
    private static String majorPathName = "/User/kingdomdong/Major";

    public static void main(String[] args) {
        /**
         * output:
         * /User/kingdomdong/Documents/dumps
         */
        printPathParent(combinePaths());

        /**
         * output:
         * Major
         */
        System.out.println(relativePath());
    }

    private static Path relativePath() {
        Path firstPath = Paths.get(firstPathName);
        Path secondPath = Paths.get(majorPathName);
        return firstPath.relativize(secondPath);
    }

    private static Path combinePaths() {
        Path prefix = Paths.get(firstPathName);
        return prefix.resolve(secondPathName);
    }

    private static void printPathParent(Path completePath) {
        System.out.println(completePath.getParent());
    }

}
