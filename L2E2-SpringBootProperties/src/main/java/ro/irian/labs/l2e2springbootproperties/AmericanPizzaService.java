package ro.irian.labs.l2e2springbootproperties;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmericanPizzaService implements PizzaService  {

    private List<Pizza> pizzas;

    @PostConstruct
    private void init(){
        pizzas = List.of(
                new Pizza(4L, "Pepperoni",45D),
                new Pizza(5L, "Hawaiian", 49D),
                new Pizza(6L, "BBQ", 54D)
        );
    }

    @Override
    public List<Pizza> getAllPizzas(){
        return pizzas;
    }

    @Override
    public Pizza getPizzaById(Long id){
        return pizzas.stream()
                .filter(pizza -> pizza.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Pizza> getPizzaByNameContains(String nameContainsString){
        return pizzas.stream()
                .filter(pizza -> pizza.nameContains(nameContainsString))
                .toList();
    }
}
