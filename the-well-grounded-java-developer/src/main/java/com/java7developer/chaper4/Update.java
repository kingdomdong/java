package main.java.com.java7developer.chaper4;

public class Update {

    private Author author;
    private String updateText;

    private Update(Builder builder) {
        this.author = builder.author;
        this.updateText = builder.updateText;
    }

    public Author getAuthor() {
        return author;
    }

    public String getUpdateText() {
        return updateText;
    }

    public static class Builder implements ObjBuild<Update> {
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
        public Update build() {
            return new Update(this);
        }
    }

}
