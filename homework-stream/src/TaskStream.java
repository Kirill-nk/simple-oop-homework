import java.awt.event.ItemEvent;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskStream {

    /**
     * общая сумма по всем книгам.
     *
     * @param books - список книг
     * @return сумма по всем книгам
     */
    public static double task1(List<Book> books) {
        return books.stream().mapToDouble(book -> book.getPrice()).sum();
    }

    /**
     * количество уникальных авторов среди всех книг.
     *
     * @param books - список книг
     * @return количество уникальных авторов
     */
    public static long task2(List<Book> books) {
        return books.stream().map(x -> x.getAuthor()).distinct().count();
    }

    /**
     * Map в ключе название книги, в значении все отзывы по этой книге.
     *
     * @param books - список книг
     * @return ожидаемый мап
     */
    public static Map<String, List<String>> task3(List<Book> books) {
        return books.stream().collect(Collectors.toMap(book -> book.getTitle(), Book::getReviews));
    }


    /**
     * Map в ключе название книги, в значении все отзывы по этой книге.
     * Дополнительное условие: хранить ключи только тех, у кого есть отзывы
     *
     * @param books - список книг
     * @return ожидаемый мап
     */
    public static Map<String, List<String>> task4(List<Book> books) {
//        return books.stream()
//                .filter(book -> book.getReviews() != null && !book.getReviews().isEmpty())
//                .collect(Collectors.toMap(book -> book.getTitle(), book -> book.getReviews()));
        return books.stream()
                .filter(book -> !book.getReviews().isEmpty())
                .collect(Collectors.toMap(book -> book.getTitle(), Book::getReviews));
    }

    /**
     * Список всех отзывов по всем книгам
     *
     * @param books - список книг
     * @return список отзывов
     */
    public static List<String> task5(List<Book> books) {
        return books.stream()
                .map(new Function<Book, List<String>>() {
                    @Override
                    public List<String> apply(Book book) {
                        return book.getReviews();
                    }
                }).flatMap(new Function<List<String>, Stream<String>>() {
                    @Override
                    public Stream<String> apply(List<String> strings) {
                        return strings.stream();
                    }
                })
                .collect(Collectors.toList());
    }

    /**
     * Определить среднюю стоимость книги (не считая сумму книг)
     *
     * @param books - список книг
     * @return среднюю стоимость книги
     */
    public static double task6(List<Book> books) {
        return books.stream()
                .mapToDouble(book -> book.getPrice())
                .average().orElseThrow();
    }
    //Функциональные интерфейсы - посмотреть

    /**
     * У всех книг в поле Автор есть слово "Автор"
     *
     * @param books - список книг
     * @return результат
     */
    public static boolean task7(List<Book> books) {
        return books.stream()
                .filter(book -> book.getAuthor().contains("Автор"))
                .collect(Collectors())
    }

    /**
     * Преобразовать List в Set. где Set это все названия книг. достаточно 3
     *
     * @param books - список книг
     * @return не больше 3 названий книг
     */
//    public static Set<String> task8(List<Book> books) {
//        return Collections.emptySet();
//    }

    /**
     * Найти книги, у которых в названии четная цифра, но цена меньше 100
     *
     * @param books - список книг
     * @return
     */
//    public static List<Book> task9(List<Book> books) {
//        return Collections.emptyList();
//    }

    /**
     * поместить книга в Map по двум ключам: "OK" и "Not Ok". где второе когда цена у книги больше 50
     *
     * @param books - список книг
     * @return Map с двумя ключами
     */
//    public static Map<String, List<Book>> task10(List<Book> books) {
//        return Collections.emptyMap();
//    }

    /**
     * Получить список книг, у которых хотя бы один отзыв содержит слово "рекомендую".
     *
     * @param books - список книг
     * @return список книг с интересными отзывами
     */
//    public static List<Book> task11(List<Book> books) {
//        return Collections.emptyList();
//    }

    /**
     * Найти самую дешевую книгу.
     *
     * @param books - список книг
     * @return самая дешевая книга
     */
//    public static Book task12(List<Book> books) throws IllegalArgumentException {
//        return null;
//    }
}

