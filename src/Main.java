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
                if (integer < 0) {
                    return false;
                } else {
                    return true;
                }
            }
        };

        System.out.println(intPredicate.test(-2));
        System.out.println(intPredicate.test(3));

        Predicate<Integer> integerPredicate1 = i -> (i < 0 ? false : true);

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
                return aDouble.longValue();
            }
        };

        System.out.println(rounding.apply(34.2));

        Function<Double, Long> rounding1 = d -> d.longValue();

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

        public static <T, U> Function<T, U> ternaryOperator(
                Predicate<? super T> condition,
                Function<? super T, ? extends U> ifTrue,
                Function<? super T, ? extends U> ifFalse) {
            // При вставке кода или перепечатывании его самостоятельно все окрашивается в красный цвет,
            // что бы я ни делал, не понимаю в чем может быть проблема
        }
    }
}