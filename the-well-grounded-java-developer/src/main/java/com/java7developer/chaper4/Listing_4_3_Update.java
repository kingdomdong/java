package main.java.com.java7developer.chaper4;

public class Listing_4_3_Update {

    private Author author;
    private String updateText;

    private Listing_4_3_Update(Builder builder) {
        this.author = builder.author;
        this.updateText = builder.updateText;
    }

    public Author getAuthor() {
        return author;
    }

    public String getUpdateText() {
        return updateText;
    }

    public static class Builder implements Listing_4_3_1_ObjBuild<Listing_4_3_Update> {
        private Author author;
        private String updateText;

        public Builder author(Author author) {
            this.author = author;
            return this;
        }

        public Builder updateText(String updateText) {
            this.updateText = updateText;
            return this;
        }

        @Override
        public Listing_4_3_Update build() {
            return new Listing_4_3_Update(this);
        }
    }

}
