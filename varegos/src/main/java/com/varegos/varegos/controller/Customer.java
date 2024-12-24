package com.varegos.varegos.controller;

import com.varegos.varegos.dto.enums.DocumentTypeEnum;
import com.varegos.varegos.services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class Customer {
    @Autowired
    CustomerServiceImpl customerService;

    @GetMapping("/customer-document/{customer-document-number}/recipients")
    public ResponseEntity<?> getAgendaCbu( @PathVariable("customer-document-number") String customerDocumentNumber,
                                           @RequestParam("customer-document-type")
                                           DocumentTypeEnum customerDocumentType){
        return customerService.getAgendaCbu(customerDocumentNumber,customerDocumentType);
    }


}
