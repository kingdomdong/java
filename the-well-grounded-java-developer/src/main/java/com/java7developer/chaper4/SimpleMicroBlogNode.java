package main.java.com.java7developer.chaper4;

public interface SimpleMicroBlogNode {
    String getIdentifier();

    void propagateUpdate(Update update, SimpleMicroBlogNode secondBlogNode);

    default boolean confirmUpdate(SimpleMicroBlogNode secondBlogNode, Update update) {
        return false;
    }

}