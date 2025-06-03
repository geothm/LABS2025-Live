package ro.irian.labs.pizza.service;

import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ro.irian.labs.pizza.domain.CurrencyValue;
import ro.irian.labs.pizza.domain.Pizza;
import ro.irian.labs.pizza.domain.PizzaJPARepository;
import ro.irian.labs.pizza.service.api.PizzaDTO;
import ro.irian.labs.pizza.service.api.PizzaService;

import java.util.List;
import java.util.stream.IntStream;

@Service
@Primary
public class ItalianPizzaService implements PizzaService {

    private final PizzaJPARepository pizzaRepository;

    public ItalianPizzaService(PizzaJPARepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public List<Pizza> getAllPizzas(){
        return pizzaRepository.findAll();
    }

    @Override
    public Pizza getPizzaById(Long id){
        return pizzaRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Pizza> getPizzaByNameContains(String nameContainsString){
        return pizzaRepository.findAllByNameContainsIgnoreCase(nameContainsString);
    }

    @Override
    public Page<Pizza> getPagedPizzas(Pageable pageable) {
        return pizzaRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void savePizza(PizzaDTO pizzaDTO) {
        Pizza pizza = new Pizza();

        pizza.setName(pizzaDTO.getName());
        pizza.setCurrencyValue(new CurrencyValue(pizzaDTO.getPrice(), pizzaDTO.getCurrency()));

        save(pizza);    }

    private void save(Pizza pizza) {
        pizzaRepository.save(pizza);
    }
}
