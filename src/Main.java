import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Main {
    public static void main(String[] args) {
// Задание 1

        Predicate<Integer> intPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer >= 0;
            }
        };

        System.out.println(intPredicate.test(-2));
        System.out.println(intPredicate.test(3));

        Predicate<Integer> integerPredicate1 = i -> i>=0;

        System.out.println(integerPredicate1.test(-10));
        System.out.println(integerPredicate1.test(4));

        // Задание 2

        Consumer<String> helloName = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Приветствуем тебя, " + s);
            }
        };

        helloName.accept("Игорь");

        Consumer<String> helloName1 = s -> System.out.println("Добро пожаловать, " + s);

        helloName1.accept("Василий");

        // Задание 3

        Function<Double, Long> rounding = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };

        System.out.println(rounding.apply(34.2));

        Function<Double, Long> rounding1 = d -> Math.round(d);

        System.out.println(rounding1.apply(22.4));

        // Задание 4

        Supplier<Integer> randomNum = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return ThreadLocalRandom.current().nextInt(0, 100);
            }
        };

        System.out.println(randomNum.get());

        Supplier<Integer> randomNum1 = () -> ThreadLocalRandom.current().nextInt(0, 100);

        System.out.println(randomNum1.get());

        // Задание 5

        Predicate<Integer> condition = i -> i%2 == 0;

        Function<Integer, String> ifTrue = i -> "число " + i.toString() + " кратно двум";

        Function<Integer, String> ifFalse = i -> "число " + i.toString() + " не кратно двум";

        System.out.println(ternaryOperator(condition, ifTrue, ifFalse).apply(4));

    }


    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        Function<T, U> trueOrFalse = p -> (condition.test(p) ? ifTrue.apply(p) : ifFalse.apply(p));
        return trueOrFalse;
    }
}
