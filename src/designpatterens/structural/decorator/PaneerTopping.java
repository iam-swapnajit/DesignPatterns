package designpatterens.structural.decorator;

public class PaneerTopping extends PizzaTopping{

    public PaneerTopping(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public String description() {
        return basePizza.description() + " Panner top";
    }

    @Override
    public double getCost() {
        return basePizza.getCost() + 100;
    }
}
