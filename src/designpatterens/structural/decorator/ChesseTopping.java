package designpatterens.structural.decorator;

public class ChesseTopping extends PizzaTopping{
    public ChesseTopping(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public String description() {
        return basePizza.description() + " Cheese topping";
    }

    @Override
    public double getCost() {
        return basePizza.getCost() + 50;
    }
}
