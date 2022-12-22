package tpc;

import tpc.bit.BookDTO;

import java.util.ArrayList;
import java.util.List;

public class TPC35 {
    public static void main(String[] args) {
        List list = new ArrayList(2);
        list.add(new BookDTO("Java", 27_000, "publisher", 400));
        list.add(new BookDTO("C", 14_000, "publisher", 125));
        list.add(new BookDTO("Python", 34_000, "publisher", 241));

        list.forEach((item) -> {
            if (item instanceof BookDTO)
                System.out.println(((BookDTO) item).title);
        });
    }
}
