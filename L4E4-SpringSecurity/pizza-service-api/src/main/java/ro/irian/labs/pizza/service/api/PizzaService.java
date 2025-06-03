package ro.irian.labs.pizza.service.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ro.irian.labs.pizza.domain.Pizza;

import java.util.List;

public interface PizzaService {
    List<Pizza> getAllPizzas();

    Pizza getPizzaById(Long id);

    List<Pizza> getPizzaByNameContains(String nameContainsString);

    Page<Pizza> getPagedPizzas(Pageable pageable);

    Long savePizza(PizzaDTO pizzaDTO);

    boolean existsByName(String value);
}
