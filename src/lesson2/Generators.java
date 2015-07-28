package lesson2;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Generators {

    private static final Supplier<String> mobileSupplier = () -> String.format("447700900%03d", ThreadLocalRandom.current().nextInt(999));

    private static final Supplier<String> macSupplier = () -> {
        String[] s = Stream.generate(() -> String.format("%02x", ThreadLocalRandom.current().nextInt(255)))
                .limit(6)
                .toArray(String[]::new);
        return String.join(":", s);
    };

    public static void main(String[] args) {
        System.out.println("Some mobile numbers:");
        Stream.generate(Generators.mobileSupplier)
                .limit(5)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Some (pseudo) mac addresses:");
        Stream.generate(Generators.macSupplier)
                .limit(5)
                .forEach(System.out::println);
    }
}
