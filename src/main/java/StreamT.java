import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamT {

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        Iterable<T> zippedIterable = () -> new Iterator<T>() {
            boolean hasMoreFirst = firstIterator.hasNext();
            boolean hasMoreSecond = secondIterator.hasNext();

            @Override
            public boolean hasNext() {
                return hasMoreFirst || hasMoreSecond;
            }

            @Override
            public T next() {
                if (hasMoreFirst && hasMoreSecond) {
                    hasMoreFirst = firstIterator.hasNext();
                    hasMoreSecond = secondIterator.hasNext();
                    return firstIterator.next();
                } else if (hasMoreFirst) {
                    hasMoreFirst = firstIterator.hasNext();
                    return firstIterator.next();
                } else if (hasMoreSecond) {
                    hasMoreSecond = secondIterator.hasNext();
                    return secondIterator.next();
                } else {
                    return null;
                }
            }
        };

        return StreamSupport.stream(zippedIterable.spliterator(), false);
    }
}