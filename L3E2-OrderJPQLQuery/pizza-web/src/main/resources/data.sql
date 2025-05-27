-- -------------------------------------------------
-- 1) CUSTOMERS
--    (IDs must be provided explicitly)
-- -------------------------------------------------
INSERT INTO customer (id, name) VALUES
                                    (1, 'Alice Johnson'),
                                    (2, 'Bob Smith'),
                                    (3, 'Carol Davis'),
                                    (4, 'David Martinez'),
                                    (5, 'Eva Thompson');

-- -------------------------------------------------
-- 2) PIZZAS
--    20 distinct pizzas, IDs 1–20
-- -------------------------------------------------
INSERT INTO pizza (id, name, price, currency) VALUES
                                                  ( 1,  'Margherita',         7.99,  'RON'),
                                                  ( 2,  'Funghi',             8.49,  'EUR'),
                                                  ( 3,  'Diavola',            9.99,  'RON'),
                                                  ( 4,  'Quattro Formaggi',  11.50,  'EUR'),
                                                  ( 5,  'Hawaii',            10.00,  'RON'),
                                                  ( 6,  'Prosciutto',        12.49,  'EUR'),
                                                  ( 7,  'Capricciosa',       11.20,  'RON'),
                                                  ( 8,  'Vegetariana',        9.50,  'EUR'),
                                                  ( 9,  'Calzone',            9.75,  'RON'),
                                                  (10, 'Bufalina',           11.00,  'EUR'),
                                                  (11, 'Tonno',              10.75,  'RON'),
                                                  (12, 'Quattro Stagioni',   12.00,  'EUR'),
                                                  (13, 'Boscaiola',          11.30,  'RON'),
                                                  (14, 'Spianata',           10.90,  'EUR'),
                                                  (15, 'Napoli',              9.80,  'RON'),
                                                  (16, 'Puttanesca',         10.60,  'EUR'),
                                                  (17, 'Carbonara',          12.20,  'RON'),
                                                  (18, 'Siciliana',          11.75,  'EUR'),
                                                  (19, 'Peperoni',           10.40,  'RON'),
                                                  (20, 'Mediterranea',       11.90,  'EUR');

-- -------------------------------------------------
-- 3) ORDERS
--    10 orders, IDs 1–10
-- -------------------------------------------------
INSERT INTO pizza_orders (id, customer_id, order_date,      order_status) VALUES
                                                                              ( 1, 1, '2025-05-20 11:30:00', 'CREATED'),
                                                                              ( 2, 2, '2025-05-21 13:15:00', 'IN_PROGRESS'),
                                                                              ( 3, 1, '2025-05-22 18:45:00', 'COMPLETED'),
                                                                              ( 4, 3, '2025-05-23 12:00:00', 'CREATED'),
                                                                              ( 5, 2, '2025-05-23 19:30:00', 'IN_DELIVERY'),
                                                                              ( 6, 1, '2025-05-24 14:20:00', 'CREATED'),
                                                                              ( 7, 3, '2025-05-24 20:10:00', 'IN_PROGRESS'),
                                                                              ( 8, 2, '2025-05-25 10:05:00', 'COMPLETED'),
                                                                              ( 9, 1, '2025-05-25 17:50:00', 'IN_DELIVERY'),
                                                                              (10, 3, '2025-05-26 09:15:00', 'CREATED');

-- -------------------------------------------------
-- 4) ORDER–PIZZA LINKS
--    Each order links to 1–4 pizzas
-- -------------------------------------------------
INSERT INTO pizza_order_pizzas (pizza_order_id, pizza_id) VALUES
                                                              -- Order 1 (cust=1): Margherita, Diavola
                                                              (1,  1), (1,  3),

                                                              -- Order 2 (cust=2): Funghi, Prosciutto, Capricciosa
                                                              (2,  2), (2,  6), (2,  7),

                                                              -- Order 3 (cust=1): Bufalina
                                                              (3, 10),

                                                              -- Order 4 (cust=3): Quattro Formaggi, Vegetariana, Napoli
                                                              (4,  4), (4,  8), (4, 15),

                                                              -- Order 5 (cust=2): Spianata, Tonno
                                                              (5, 14), (5, 11),

                                                              -- Order 6 (cust=1): Calzone, Boscaiola, Hawaii, Margherita
                                                              (6,  9), (6, 13), (6,  5), (6,  1),

                                                              -- Order 7 (cust=3): Quattro Stagioni, Carbonara
                                                              (7, 12), (7, 17),

                                                              -- Order 8 (cust=2): Peperoni
                                                              (8, 19),

                                                              -- Order 9 (cust=1): Mediterranea, Puttanesca
                                                              (9, 20), (9, 16),

                                                              -- Order 10 (cust=3): Napoli, Diavola, Funghi
                                                              (10,15), (10, 3), (10, 2);

