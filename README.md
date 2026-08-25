Vacation Booking Back-End API (WGU D288: Back-End Programming)
Overview

A Spring Boot REST API backing a vacation/excursion booking application. The service manages customers, vacation packages, excursions, and a shopping-cart checkout flow backed by a MySQL relational database, designed to be consumed by an Angular front end.

Designed the relational schema and entity relationships across Country,  Division, Customer, and Vacation, Excursion, Cart, CartItem, using JPA annotations (@OneToMany, @ManyToOne, @ManyToMany) to model the data.
Implemented the Spring Data JPA repository layer (CustomerRepository, CartRepository, CartItemRepository, VacationsRepository, ExcursionRepository, CountryRepository, DivisionRepository), exposing REST resources via Spring Data REST.
Built a custom checkout flow: POST /api/checkout/purchase, takes a cart and customer payload, generates a unique order-tracking number (UUID), persists the cart with cascading cart items, and returns a purchase confirmation response.
Added field-level input validation on the Customer entity (required fields, minimum postal code length) using Jakarta Bean Validation.


Tech Stack
Backend: Java 17, Spring Boot 3.2, Spring Data JPA, Spring Data REST
Database: MySQL
Validation: Jakarta Bean Validation
Build tool: Maven
Frontend (not included in this repo): Angular, consuming the API via CORS-enabled endpoints

What I'd Improve
Add unit and integration tests (JUnit/Mockito), none were included in the original scope
Add authentication/authorization (Spring Security), currently fully open, CORS-permissive
Restrict the auto-exposed REST endpoints to only what's needed (flagged as a TODO in the original config)
Containerize with Docker for easier local setup
Replace @Autowired field injection with constructor injection for consistency (currently mixed)