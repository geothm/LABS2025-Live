package ro.irian.labs.pizza.service.api;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {
    private final PizzaService pizzaService;

    public UniqueNameValidator(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @Override
    public void initialize(UniqueName constraint) { }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext ctx) {
        return value != null && !pizzaService.existsByName(value.trim());
    }
}

