package designpatterens.structural.decorator;

public class FarmHousePizza implements BasePizza{
    @Override
    public String description() {
        return "FarmHouse Pizza";
    }

    @Override
    public double getCost() {
        return 300.0;
    }
}
