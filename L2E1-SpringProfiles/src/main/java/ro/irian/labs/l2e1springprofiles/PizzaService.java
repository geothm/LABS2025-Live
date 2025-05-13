package ro.irian.labs.l2e1springprofiles;

import java.util.List;

public interface PizzaService {
    List<Pizza> getAllPizzas();

    Pizza getPizzaById(Long id);

    List<Pizza> getPizzaByNameContains(String nameContainsString);
}
