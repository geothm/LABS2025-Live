package ro.irian.labs.pizza.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
@Primary
public class ItalianPizzaService implements PizzaService {

    private final List<Pizza> pizzas;

    public ItalianPizzaService(PizzaProperties pizzaProperties) {
        pizzas = IntStream.range(0, pizzaProperties.getNames().size())
                .mapToObj(i -> new Pizza((long) i, pizzaProperties.getNames().get(i), pizzaProperties.getPrices().get(i)))
                .toList();

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
