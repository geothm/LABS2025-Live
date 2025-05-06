package ro.irian.labs.l1e4springmultidi;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class ItalianPizzaService implements PizzaService {

    private List<Pizza> pizzas;

    @PostConstruct
    private void init(){
        pizzas = List.of(
                new Pizza(1L, "Salami"),
                new Pizza(2L, "Prosciutto"),
                new Pizza(3L, "Capriciosa")
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
