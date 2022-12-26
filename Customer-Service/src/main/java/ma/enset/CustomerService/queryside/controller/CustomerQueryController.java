package ma.enset.CustomerService.queryside.controller;

import lombok.AllArgsConstructor;
import ma.enset.CustomerService.queryside.entities.Customer;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import queries.customer.GetAllCustomerQuery;
import queries.customer.GetCustomerByIdQuery;

import java.util.List;

@RestController
@RequestMapping("/queries/customer")
@AllArgsConstructor
public class CustomerQueryController {
    private QueryGateway queryGateway;
    @GetMapping("/customers")
    public List<Customer> costomersList(){
        List<Customer> customerList = queryGateway.query(new GetAllCustomerQuery(), ResponseTypes.multipleInstancesOf(Customer.class)).join();
        return customerList;
    }

    @GetMapping("/customers/{id}")
    public Customer costomerById(@PathVariable String id){
        Customer customer = queryGateway.query(new GetCustomerByIdQuery(id), ResponseTypes.instanceOf(Customer.class)).join();
        return customer;
    }
    @ExceptionHandler
    public ResponseEntity<String> exceptionHandler(Exception e){
        ResponseEntity<String> entity= new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }
}
