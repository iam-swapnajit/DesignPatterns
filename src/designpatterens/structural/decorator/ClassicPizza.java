package designpatterens.structural.decorator;

public class ClassicPizza implements BasePizza{
    @Override
    public String description() {
        return "Classic Pizza";
    }

    @Override
    public double getCost() {
        return 200.0;
    }
}
