package ma.enset.CustomerService.queryside.repositories;

import ma.enset.CustomerService.queryside.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {

}
