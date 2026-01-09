package designpatterens.structural.decorator;

public class Main {
    public static void main(String[] args) {
        //Create a farm house pizza with paneer topping.

        BasePizza pannerFarmHousePizza = new PaneerTopping(new FarmHousePizza());
        System.out.println(pannerFarmHousePizza.description() + " Cost is "+pannerFarmHousePizza.getCost());

        /**
         * CheeseTopings
         *    └── PaneerTopings
         *          └── FarmHousePizza
         *
         *
         * | Object           | Wraps            |
         * | ---------------- | ---------------- |
         * | `CheeseTopings`  | `PaneerTopings`  |
         * | `PaneerTopings`  | `FarmHousePizza` |
         * | `FarmHousePizza` | nothing          |
         */


        //Create a classic pizza with paneer and cheese toppings

        BasePizza paneerCheeeseClassicPizza = new PaneerTopping(new ChesseTopping(new ClassicPizza()));
        System.out.println(paneerCheeeseClassicPizza.description() + " Cost is "+paneerCheeeseClassicPizza.getCost());

    }
}
