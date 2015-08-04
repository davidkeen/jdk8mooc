package lesson2;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Generators {

    private static final Supplier<String> mobileSupplier = () -> String.format("447700900%03d", ThreadLocalRandom.current().nextInt(999));

    private static final Supplier<String> macSupplier = () -> ThreadLocalRandom.current().ints(6, 0, 255)
            .mapToObj(i -> String.format("%02x", i))
            .collect(Collectors.joining(":"));

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
