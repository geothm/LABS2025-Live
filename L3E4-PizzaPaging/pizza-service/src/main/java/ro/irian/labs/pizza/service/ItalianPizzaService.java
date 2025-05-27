package ro.irian.labs.pizza.service;

import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ro.irian.labs.pizza.domain.Pizza;
import ro.irian.labs.pizza.domain.PizzaJPARepository;
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
}
