package ma.enset.CustomerService.queryside.service;

import events.customer.CustomerCreatedEvent;
import events.customer.CustomerUpdatedEvent;
import exceptions.customer.CustomerNotFoundException;
import lombok.AllArgsConstructor;
import ma.enset.CustomerService.queryside.entities.Customer;
import ma.enset.CustomerService.queryside.repositories.CustomerRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import queries.customer.GetAllCustomerQuery;
import queries.customer.GetCustomerByIdQuery;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceHandler {

    private CustomerRepository customerRepository;
    @EventHandler
    public void on(CustomerCreatedEvent event){
        Customer customer = new Customer();
        customer.setId(event.getId());
        customer.setName(event.getName());
        customer.setAdresse(event.getAdresse());
        customer.setEmail(event.getEmail());
        customer.setPhone(event.getPhone());
        customerRepository.save(customer);
    }
    @EventHandler
    public  void  on(CustomerUpdatedEvent event){
        Customer customer = customerRepository.findById(event.getId()).orElseThrow(() -> new CustomerNotFoundException(
                "the customer with id : # " + event.getId() + " # is not exise"
        ));
        if(event.getName()!=null) customer.setName(event.getName());
        if(event.getAdresse()!=null) customer.setAdresse(event.getAdresse());
        if(event.getEmail()!=null) customer.setEmail(event.getEmail());
        if(event.getPhone()!=null) customer.setPhone(event.getPhone());

        customerRepository.save(customer);
    }
    @QueryHandler
    public List<Customer> on(GetAllCustomerQuery query){
        return customerRepository.findAll();
    }
    @QueryHandler
    public Customer on(GetCustomerByIdQuery query){
        Customer customer = customerRepository.findById(query.getCustomerId()).orElseThrow(() -> new CustomerNotFoundException(
                "the customer with id : # " + query.getCustomerId() + " # is not exise"
        ));
        return customer;
    }

}
