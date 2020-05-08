package main.java.com.java7developer.chaper2;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * create a Path
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-05-05 17:46:57
 */
public class Listing_2_1_CreatePath {

    /**
     * output:
     *
     * File Name [test.txt]
     * Number of Name Elements [5]
     * Parent Path [/Users/kingdomdong/Documents/temp]
     * Root of Path [/]
     * Subpath from Root, 2 elements deep [Users/kingdomdong]
     *
     * @param args terminal arguments
     */
    public static void main(String[] args) {
        String firstPath = "/Users/kingdomdong/Documents/tmp/test.txt";
        Path listing = Paths.get(firstPath);
        Path listingOther = FileSystems.getDefault().getPath(firstPath);
        System.out.println("File Name [" + listing.getFileName() + "]");
        System.out.println("Number of Name Elements [" + listing.getNameCount() + "]");
        System.out.println("Parent Path [" + listing.getParent() + "]");
        System.out.println("Root of Path [" + listing.getRoot() + "]");
        System.out.println("Subpath from Root, 2 elements deep [" + listing.subpath(0, 2) + "]");
    }

}
