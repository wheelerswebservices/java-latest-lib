import java.util.*;
import java.util.stream.Collectors;

public class BestFeatures {
    void collectionListOf(){
        final List<Integer> old = Arrays.asList(1, 2, 3);
        final List<Integer> cur = List.of(1, 2, 3);

        System.err.println("\ncollectionListOf");
        System.out.printf("old: %s%n", old);
        System.out.printf("cur: %s%n", cur);
    }

    void collectionMapOf(){
        final Map<Integer, Character> old = new HashMap<>() {{
           put(1, 'a');
           put(2, 'b');
           put(3, 'c');
        }};
        // only works up to 10 elements
        final Map<Integer, Character> cur = Map.of(1, 'a', 2, 'b', 3, 'c');

        System.err.println("\ncollectionMapOf");
        System.out.printf("old: %s%n", old);
        System.out.printf("cur: %s%n", cur);
    }

    void collectionMapOfEntries(){
        final Map<Integer, Character> old = new HashMap<>() {{
            put(1, 'a');
            put(2, 'b');
            put(3, 'c');
        }};
        final Map<Integer, Character> cur = Map.ofEntries(
            Map.entry(1, 'a'),
            Map.entry(2, 'b'),
            Map.entry(3, 'c')
        );

        System.err.println("\ncollectionMapOfEntries");
        System.out.printf("old: %s%n", old);
        System.out.printf("cur: %s%n", cur);
    }

    void collectionSetOf(){
        final Set<Integer> old = new HashSet<>(Arrays.asList(1, 2, 3));
        final Set<Integer> cur = Set.of(1, 2, 3);

        System.err.println("\ncollectionSetOf");
        System.out.printf("old: %s%n", old);
        System.out.printf("cur: %s%n", cur);
    }

    void collectorsToList(){
        final String[] val = new String[]{"val1", "val2"};
        final List<String> old = Arrays.stream(val).collect(Collectors.toList());
        final List<String> cur = Arrays.stream(val).toList();

        System.err.println("\ncollectorsToList");
        System.out.printf("val: %s%n", Arrays.toString(val));
        System.out.printf("old: %s%n", old);
        System.out.printf("cur: %s%n", cur);
    }

    void record(){
        final ImmutableClass old = new ImmutableClass("justin");
        final ImmutableRecord cur = new ImmutableRecord("justin");

        System.err.println("\nrecord");
        System.out.printf("old: %s%n", old);
        System.out.printf("cur: %s%n", cur);
    }

    void patternMatchingInstanceOf(){
        final Object[] objects = new Object[]{
                1,
                'a',
                new Cat(),
                new Dog(),
                "String",
        };
        final Map<Pet, String> oldPetMap = new LinkedHashMap<>();
        final Map<Pet, String> curPetMap = new LinkedHashMap<>();

        for(final Object obj : objects){
            if(obj instanceof Pet){
                final Pet p = (Pet)obj;
                oldPetMap.put(p, p.speak());
            }

            if(obj instanceof Pet p){
                curPetMap.put(p, p.speak());
            }
        }

        System.err.println("\npatternMatchingInstanceOf");
        System.out.printf("old: %s%n", oldPetMap);
        System.out.printf("cur: %s%n", curPetMap);
    }

    void switchExpression(){
        final Map<Month, Integer> oldMonthDaysMap = new LinkedHashMap<>();
        final Map<Month, Integer> curMonthDaysMap = new LinkedHashMap<>();

        for(final Month m : Month.values()){
            int oldDays;

            switch(m){
                case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER :
                    oldDays = 31;
                    break;
                case FEBRUARY :
                    oldDays = 28;
                    break;
                case APRIL, JUNE, SEPTEMBER, NOVEMBER :
                    oldDays = 30;
                    break;
                default:
                    throw new IllegalStateException();
            }
            oldMonthDaysMap.put(m, oldDays);

            final int curDays = switch(m){
                case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> 31;
                case FEBRUARY -> 28;
                case APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30;
                default -> throw new IllegalStateException();
            };
            curMonthDaysMap.put(m, curDays);
        }

        System.err.println("\nswitchExpression");
        System.out.printf("old: %s%n", oldMonthDaysMap);
        System.out.printf("cur: %s%n", curMonthDaysMap);
    }

    void switchExpressionYield(){
        final Map<Month, Integer> oldMonthDaysMap = new LinkedHashMap<>();
        final Map<Month, Integer> curMonthDaysMap = new LinkedHashMap<>();

        System.err.println("\nswitchExpressionYield");

        for(final Month m : Month.values()) {
            int oldDays;

            switch (m) {
                case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER:
                    System.out.printf("\t%s: 31%n", m);
                    oldDays = 31;
                    break;
                case FEBRUARY:
                    System.out.printf("\t%s: 28%n", m);
                    oldDays = 28;
                    break;
                case APRIL, JUNE, SEPTEMBER, NOVEMBER:
                    System.out.printf("\t%s: 30%n", m);
                    oldDays = 30;
                    break;
                default:
                    throw new IllegalStateException();
            }
            oldMonthDaysMap.put(m, oldDays);
        }
        System.out.printf("\nold: %s%n%n", oldMonthDaysMap);

        for(final Month m : Month.values()){
            final int curDays = switch(m){
                case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> {
                    System.out.printf("\t%s: 31%n", m);
                    yield 31;
                }
                case FEBRUARY -> {
                    System.out.printf("\t%s: 28%n", m);
                    yield 28;
                }
                case APRIL, JUNE, SEPTEMBER, NOVEMBER -> {
                    System.out.printf("\t%s: 30%n", m);
                    yield 30;
                }
                default -> throw new IllegalStateException();
            };
            curMonthDaysMap.put(m, curDays);
        }
        System.out.printf("\ncur: %s%n%n", curMonthDaysMap);
    }

    void textBlocks(){
        final String old = "{\n  \"feature\": \"Text Blocks\",\n  \"message\": \"Hello World\",\n  \"success\": true\n}";
        final String cur = """
                {
                  "feature": "Text Blocks",
                  "message": "Hello World",
                  "success": true
                }
                """;

        System.err.println("\ntextBlocks");
        System.out.printf("old: %s%n", old);
        System.out.printf("cur: %s%n", cur);
    }

    void var(){
        final SuperHelpfulReallyLongAndDescriptiveClassName old = new SuperHelpfulReallyLongAndDescriptiveClassName();
        final var cur = new SuperHelpfulReallyLongAndDescriptiveClassName();

        System.err.println("\nvar");
        System.out.printf("old: %s%n", old);
        System.out.printf("cur: %s%n", cur);

    }

    enum Month {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
    }

    interface Pet {
        String speak();
    }

    class Cat implements Pet {
        @Override
        public String speak() {
            return "meow";
        }
        @Override
        public String toString() {
            return getClass().getName();
        }
    }

    class Dog implements Pet {
        @Override
        public String speak() {
            return "bark";
        }
        @Override
        public String toString() {
            return getClass().getName();
        }
    }

    class SuperHelpfulReallyLongAndDescriptiveClassName {
        @Override
        public String toString() {
            return getClass().getName();
        }
    }

    class ImmutableClass {
        private final String name;

        ImmutableClass(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            ImmutableClass that = (ImmutableClass) o;
            return Objects.equals(name, that.name);
        }
        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
        @Override
        public String toString() {
            return String.format("ImmutableClass[name=%s]", name);
        }
    }

    record ImmutableRecord(String name){}
}
