package ro.irian.labs.pizza.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaJPARepository extends JpaRepository<Pizza,Long> {

    List<Pizza> findAllByNameContainsIgnoreCase(String nameContainsString);

    boolean existsByName(String name);
}

