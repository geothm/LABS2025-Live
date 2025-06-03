package ro.irian.labs.pizza.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderJPARepository extends JpaRepository<PizzaOrder,Long> {
    @Query("""
      SELECT DISTINCT o
        FROM PizzaOrder o
        JOIN o.pizzas p
       WHERE p.name = :pizzaName
      """)
    List<PizzaOrder> findOrdersByPizzaName(@Param("pizzaName") String pizzaName);

    List<OrderVO> findAllProjectedBy();

    @Query("""
    SELECT o.id        AS orderNumber,
           COUNT(p)    AS numberOfPizzas
      FROM PizzaOrder o
      JOIN o.pizzas p
      GROUP BY o.id
  """)
    List<OrderCountVO> findOrderPizzaCounts();
}
