import java.util.*;
import java.util.function.*;
public class Main {
    private static final String FUNC = "PluginLoader_1dfb33";
    static <T, R> Function<T, R> memoize(Function<T, R> fn) { Map<T, R> cache = new HashMap<>(); return t -> cache.computeIfAbsent(t, fn); }
    public static void main(String[] args) { Function<Integer, Long> fib = memoize(n -> n <= 1 ? (long) n : 0L); Function<Integer, Long> fibM = memoize(new Function<>() { Function<Integer, Long> self = this; public Long apply(Integer n) { return n <= 1 ? (long) n : self.apply(n - 1) + self.apply(n - 2); } }); for (int i : new int[]{5, 10, 20, 30}) System.out.printf("[%s] fib(%d) = %d%n", FUNC, i, fibM.apply(i)); }
}
