package ma.enset.InventoryService.CommandSide.controllers;

import commands.category.CategoryCreateCommand;
import commands.category.CategoryUpdateCommand;
import dtos.category.CategoryReqDto;
import dtos.category.CategoryUpdateReqDto;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/commands/category") @AllArgsConstructor
public class CategoryController {

    private CommandGateway commandGateway;

    @PostMapping("/create")
    public CompletableFuture<String>  createCategory(@RequestBody CategoryReqDto reqDto){
        CompletableFuture<String> response = commandGateway.send(new CategoryCreateCommand(
                UUID.randomUUID().toString(),
                reqDto.getName(),
                reqDto.getDescription()
        ));
        return response;
    }

    @PutMapping("/update")
    public CompletableFuture<String>  createCategory(@RequestBody CategoryUpdateReqDto reqDto){
        CompletableFuture<String> response = commandGateway.send(new CategoryUpdateCommand(
                reqDto.getId(),
                reqDto.getName(),
                reqDto.getDescription()
        ));
        return response;
    }


    @ExceptionHandler
    public ResponseEntity<String> exceptionHandler(Exception e){
        ResponseEntity<String> entity= new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }

}
