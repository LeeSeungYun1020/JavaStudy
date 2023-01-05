package stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CollectorEx1 {
    public static void main(String[] args) {
        String[] array = {"aaa", "bbb", "ccc"};
        System.out.println(Arrays.stream(array).collect(new ConcatCollector()));
    }
}

class ConcatCollector implements Collector<String, StringBuilder, String> {

    @Override
    public Supplier<StringBuilder> supplier() {
        // return () -> new StringBuilder();
        return StringBuilder::new;
    }

    @Override
    public BiConsumer<StringBuilder, String> accumulator() {
        // return (sb, s) -> sb.append(s);
        return StringBuilder::append;
    }

    @Override
    public BinaryOperator<StringBuilder> combiner() {
        // return (sb1, sb2) -> sb1.append(sb2);
        return StringBuilder::append;
    }

    @Override
    public Function<StringBuilder, String> finisher() {
        // return sb -> sb.toString();
        return StringBuilder::toString;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}
