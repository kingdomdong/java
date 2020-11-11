import java.util.LinkedList;
import java.util.List;

public class ListClientExample {

    private final List list;

    public ListClientExample() {
        this.list = new LinkedList();
    }

    public List getList() {
        return list;
    }

    public static void main(String[] args) {
        ListClientExample listClientExample = new ListClientExample();
        List list = listClientExample.getList();
        System.out.println(list);
    }

}
