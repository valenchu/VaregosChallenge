package com.varegos.varegos.services;

import com.varegos.varegos.dto.enums.DocumentTypeEnum;
import org.springframework.http.ResponseEntity;

public interface CustomerServiceImpl {
    public ResponseEntity<?> getAgendaCbu(String document, DocumentTypeEnum documentTypeEnum);
}
