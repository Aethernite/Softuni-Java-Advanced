import java.util.*;

public class MakeASalad {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> vegetables = new ArrayDeque<>();
        ArrayDeque<Integer> saladCalories = new ArrayDeque<>();

        Arrays.stream(sc.nextLine().split("\\s"))
                .forEach(vegetables::offer);

        Arrays.stream(sc.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .forEach(saladCalories::push);

        List<String> readySalads = new ArrayList<>();

        while(!vegetables.isEmpty() && !saladCalories.isEmpty()) {

            int saladCaloriesToMake = saladCalories.peek();

            while(saladCaloriesToMake > 0 && !vegetables.isEmpty()) {
                String vegetable = vegetables.pop();
                int numberOfVeggieCalories = getVeggieCalories(vegetable);

                saladCaloriesToMake -= numberOfVeggieCalories;


            }
            readySalads.add(saladCalories.pop().toString());
        }
        if(!readySalads.isEmpty()) {
            System.out.print(String.join(" ", readySalads));
            System.out.println();

        }

        if(!vegetables.isEmpty()) {
            vegetables.forEach(veggie -> System.out.print(veggie + " "));
            System.out.println();
        }

        if(!saladCalories.isEmpty()) {
            saladCalories.forEach(salad -> System.out.print(salad + " "));
        }
    }

    private static int getVeggieCalories(String vegetable) {
        int calories = 0;
        switch (vegetable) {
            case "tomato":
                calories = 80;
                break;

            case "carrot":
                calories = 136;
                break;

            case "lettuce":
                calories = 109;
                break;

            case "potato":
                calories = 215;
                break;
        }
        return calories;
    }
}