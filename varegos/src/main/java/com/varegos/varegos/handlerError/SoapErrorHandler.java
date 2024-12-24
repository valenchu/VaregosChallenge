package com.varegos.varegos.handlerError;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.WebServiceIOException;
import org.springframework.ws.soap.client.SoapFaultClientException;

import java.util.ArrayList;
import java.util.List;

@Component
public class SoapErrorHandler {

    private static final Logger logger = LoggerFactory.getLogger(SoapErrorHandler.class);

    /**
     * Logs the error details with a specific error type and message.
     * This method writes the error details to the logger.
     *
     * @param errorType    the type of error (e.g., "JsonMappingError" or "SoapError")
     * @param errorMessage the detailed error message
     */
    public void logError(String errorType, String errorMessage) {

        logger.error("[{}] - Error: {}", errorType, errorMessage);
    }

    /**
     * Handles errors related to SOAP requests and generates a response with the error details.
     * This method checks the type of exception and returns an appropriate HTTP status and error message.
     *
     * @param ex       the exception that occurred during the SOAP request
     * @param code     code of object
     * @param id       id of object
     * @param messagee message to comunicate.
     * @return a {@link ResponseEntity} containing the error details and corresponding HTTP status
     */
    public ResponseEntity<Object> handleSoapError(Exception ex, String code, String id, String messagee) {
        String message;
        HttpStatus status;
        List<String> errors = new ArrayList<>();
        String errorCode = "SOAP_ERROR"; // Default error code
        String path = "/api/soap"; // Example path, this should be dynamic based on the request

        if (ex instanceof SoapFaultClientException) {
            // SOAP error from the server side
            SoapFaultClientException soapFault = (SoapFaultClientException) ex;
            message = messagee.isEmpty() ? "SOAP Fault: " + soapFault.getFaultStringOrReason() : messagee;
            status = HttpStatus.BAD_REQUEST;
            errors.add(soapFault.getFaultStringOrReason());
        } else if (ex instanceof WebServiceIOException) {
            // Connection error or timeout
            message = messagee.isEmpty() ? "SOAP Connection Error: " + ex.getMessage() : messagee;
            status = HttpStatus.SERVICE_UNAVAILABLE;
            errors.add(ex.getMessage());
        } else {
            // Other types of errors
            message = messagee.isEmpty() ? "Unexpected Error: " + ex.getMessage() : messagee;
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            errors.add(ex.getMessage());
        }

        logger.error("SOAP Error: {}", message, ex);

        // Build the error response
        ErrorResponse errorResponse = new ErrorResponse(
                code,
                id,
                message,
                errors,
                errorCode,
                path
        );

        return new ResponseEntity<>(errorResponse, status);
    }

    /**
     * Handles SOAP request errors, including JSON mapping errors, and returns an appropriate response.
     * If the error is related to JSON mapping, a detailed JSON error response is returned.
     * For other errors, a general SOAP error response is generated.
     *
     * @param exception the exception that occurred during the SOAP request
     * @param code      code of object
     * @param id        id of object
     * @param messagee  message to comunicate.
     * @return a {@link ResponseEntity} containing the error details in a JSON format
     */
    public ResponseEntity<Object> handleSoapErrorLog(Exception exception, String code, String id, String messagee) {
        List<String> errors = new ArrayList<>();
        String message = messagee.isEmpty() ? exception.getMessage() : messagee;
        String errorCode = "SOAP_ERROR";
        String path = "/api/soap"; // Example path, this should be dynamic based on the request

        if (exception instanceof JsonProcessingException) {
            // Log the JSON mapping error
            logError("JsonMappingError", exception.getMessage());

            // Create a detailed error response for JSON mapping error
            errors.add("JSON mapping error: " + exception.getMessage());
            ErrorResponse errorResponse = new ErrorResponse(
                    "500", // Code
                    "12345", // ID (this can be dynamically generated or fetched)
                    message,
                    errors,
                    errorCode,
                    path
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }

        // Log the SOAP error
        logError("SoapError", exception.getMessage());

        // Create a generic SOAP error response
        errors.add("SOAP request error: " + exception.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(
                "500", // Code
                "12345", // ID (this can be dynamically generated or fetched)
                message,
                errors,
                errorCode,
                path
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}

