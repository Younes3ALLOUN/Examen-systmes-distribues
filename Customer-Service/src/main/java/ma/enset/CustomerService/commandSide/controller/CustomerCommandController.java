package ma.enset.CustomerService.commandSide.controller;

import commands.customer.CustomerCreateCommand;
import commands.customer.CustomerUpdateCommand;
import dtos.customer.CustomerReqDto;
import dtos.customer.CustomerUPdateReqDto;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path = "/commands/customer")
@AllArgsConstructor
public class CustomerCommandController {

    private CommandGateway commandGateway;
    @PostMapping("/create")
    public  CompletableFuture<String> createCustomer(@RequestBody CustomerReqDto request){
        CompletableFuture<String> response = commandGateway.send(new CustomerCreateCommand(
                UUID.randomUUID().toString(),
                request.getName(),
                request.getAdresse(),
                request.getEmail(),
                request.getPhone()
        ));
        return response;
    }

    @PutMapping("/update")
    public  CompletableFuture<String> updateCustomer(@RequestBody CustomerUPdateReqDto request){
        CompletableFuture<String> response = commandGateway.send(new CustomerUpdateCommand(
                request.getId(),
                request.getName(),
                request.getAdresse(),
                request.getEmail(),
                request.getPhone()
        ));
        return response;
    }

    @ExceptionHandler
    public ResponseEntity<String> exceptionHandler(Exception e){
        ResponseEntity<String> entity= new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }

}
