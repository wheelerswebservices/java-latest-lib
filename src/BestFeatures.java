import java.util.*;
import java.util.stream.Collectors;

public class BestFeatures {


    void collectorsToList(){
        final String[] val = new String[]{"val1", "val2"};
        final List<String> old = Arrays.stream(val).collect(Collectors.toList());
        final List<String> cur = Arrays.stream(val).toList();

        System.out.println("\ncollectorsToList");
        System.out.printf("val: %s%n", Arrays.toString(val));
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

        System.out.println("\npatternMatchingInstanceOf");
        System.out.printf("old: %s%n", oldPetMap);
        System.out.printf("cur: %s%n", curPetMap);
    }

    void switchExpression(){
        final Color[] colors = Color.values();
        final Map<Color, String> oldColorGroupMap = new LinkedHashMap<>();
        final Map<Color, String> newColorGroupMap = new LinkedHashMap<>();

        for(final Color c : colors){
            String old;
            switch(c){
                case RED:
                case ORANGE:
                    old = "mostly red";
                    break;
                case YELLOW:
                case GREEN:
                    old = "mostly green";
                    break;
                case BLUE:
                case INDIGO:
                case VIOLET:
                    old = "mostly blue";
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
            oldColorGroupMap.put(c, old);

            final String cur = switch(c){
                case RED, ORANGE -> "mostly red";
                case YELLOW, GREEN -> "mostly green";
                case BLUE, INDIGO, VIOLET -> "mostly blue";
                default -> throw new UnsupportedOperationException();
            };
            newColorGroupMap.put(c, cur);
        }

        System.out.println("\nswitchExpression");
        System.out.printf("old: %s%n", oldColorGroupMap);
        System.out.printf("cur: %s%n", newColorGroupMap);
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

        System.out.println("\ntextBlocks");
        System.out.printf("old: %s%n", old);
        System.out.printf("cur: %s%n", cur);
    }

    enum Color {
        RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
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
}
