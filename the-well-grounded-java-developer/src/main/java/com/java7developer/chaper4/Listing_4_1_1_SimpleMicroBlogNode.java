package main.java.com.java7developer.chaper4;

public interface Listing_4_1_1_SimpleMicroBlogNode {
    String getIdentifier();

    void propagateUpdate(Listing_4_3_Update update, Listing_4_1_1_SimpleMicroBlogNode secondBlogNode);

    default boolean confirmUpdate(Listing_4_1_1_SimpleMicroBlogNode secondBlogNode, Listing_4_3_Update update) {
        return false;
    }

}