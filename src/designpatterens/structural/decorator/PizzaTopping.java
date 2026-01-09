package designpatterens.structural.decorator;

public abstract class PizzaTopping implements BasePizza{
    BasePizza basePizza;
    public PizzaTopping(BasePizza basePizza){
        this.basePizza = basePizza;
    }
}
