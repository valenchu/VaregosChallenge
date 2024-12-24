package com.varegos.varegos.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.varegos.varegos.dto.GetAgendaCBUResponseDTO;
import com.varegos.varegos.dto.enums.DocumentTypeEnum;
import com.varegos.varegos.dto.mappers.GetAgendaCBUResponseMapper;
import com.varegos.varegos.handlerError.SoapErrorHandler;
import com.varegos.varegos.wsdl.GetAgendaCBU;
import com.varegos.varegos.wsdl.GetAgendaCBUResponse;
import com.varegos.varegos.wsdl.TerminalDTO;
import com.varegos.varegos.wsdl.UsuarioDTO;
import jakarta.xml.bind.JAXBElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerService implements CustomerServiceImpl {
    private final WebServiceTemplate webServiceTemplate;
    private final SoapErrorHandler soapErrorHandler;
    private final GetAgendaCBUResponseMapper getAgendaCBUResponseMapper;
    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    public CustomerService(WebServiceTemplate webServiceTemplate, SoapErrorHandler soapErrorHandler, GetAgendaCBUResponseMapper getAgendaCBUResponseMapper) {
        this.webServiceTemplate = webServiceTemplate;
        this.soapErrorHandler = soapErrorHandler;
        this.getAgendaCBUResponseMapper = getAgendaCBUResponseMapper;
    }

    /**
     * Retrieves the agenda associated with the given document and document type.
     * This method sends a SOAP request to the external web service, logs the request, and processes the response.
     * If an error occurs during the SOAP request or JSON processing, it will be handled and logged appropriately.
     *
     * @param document         the document number (e.g., ID or CBU) for which to retrieve the agenda
     * @param documentTypeEnum the type of the document (e.g., DNI, Passport, etc.) used for the request
     * @return a {@link ResponseEntity} containing the response body with the {@link GetAgendaCBUResponse} if successful,
     * or an error response with details if an exception occurs
     */
    @Override
    public ResponseEntity<?> getAgendaCbu(String document, DocumentTypeEnum documentTypeEnum) {
        String code = "";
        String id = "";
        GetAgendaCBU getAgendaCBU = new GetAgendaCBU();
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setPassword("");
        usuarioDTO.setNroDocumento(document);
        usuarioDTO.setTipoDocumento(documentTypeEnum.getCode());
        getAgendaCBU.setUsuario(usuarioDTO);
        getAgendaCBU.setTerminal(new TerminalDTO());

        try {
            logObjectToSetRequest(getAgendaCBU);
            SoapActionCallback callback = new SoapActionCallback("http://localhost:3003/servicios/transferenciasV2/GetAgendaCBU");

            @SuppressWarnings("unchecked")
            JAXBElement<GetAgendaCBUResponse> jaxbElementResponse =
                    (JAXBElement<GetAgendaCBUResponse>) webServiceTemplate.marshalSendAndReceive(getAgendaCBU, callback);
            List<GetAgendaCBUResponseDTO> getAgendaCBUResponseDTO = managerMapper(jaxbElementResponse, getAgendaCBU);

            if (Objects.isNull(getAgendaCBUResponseDTO)) {
                if (getAgendaCBU != null) {
                    code = getAgendaCBU.getUsuario().getTipoDocumento();
                    id = getAgendaCBU.getUsuario().getNroDocumento();
                }
                return soapErrorHandler.handleSoapErrorLog(new Exception("Response GetAgendaCBUResponse is null"), code, id, "");
            }
            return ResponseEntity.ok(getAgendaCBUResponseDTO);
        } catch (JsonProcessingException e) {
            if (getAgendaCBU != null) {
                code = getAgendaCBU.getUsuario().getTipoDocumento();
                id = getAgendaCBU.getUsuario().getNroDocumento();
            }
            return soapErrorHandler.handleSoapErrorLog(e, code, id, "");
        } catch (Exception ex) {
            if (getAgendaCBU != null) {
                code = getAgendaCBU.getUsuario().getTipoDocumento();
                id = getAgendaCBU.getUsuario().getNroDocumento();
            }
            return soapErrorHandler.handleSoapError(ex, code, id, "");
        }
    }

    /**
     * Maps the response from a SOAP web service to a list of DTOs (Data Transfer Objects) representing
     * the agenda data. If the response is non-null, it will be converted to the corresponding DTO list.
     *
     * @param jaxbElementResponse the response from the SOAP service wrapped in a JAXBElement object
     *                            that contains the GetAgendaCBUResponse.
     * @param getAgendaCBU        the original request object containing the agenda request details,
     *                            which may be used for mapping additional data.
     * @return a List of {@link GetAgendaCBUResponseDTO} containing the mapped response data,
     * or null if the response is empty or null.
     */
    public List<GetAgendaCBUResponseDTO> managerMapper(JAXBElement<GetAgendaCBUResponse> jaxbElementResponse, GetAgendaCBU getAgendaCBU) {
        List<GetAgendaCBUResponseDTO> getAgendaCBUResponseDTO = null;
        if (Objects.nonNull(jaxbElementResponse.getValue())) {
            getAgendaCBUResponseDTO = this.getAgendaCBUResponseMapper.mapResponseToDtoAgenda(jaxbElementResponse.getValue());
        }
        return getAgendaCBUResponseDTO;
    }

    /**
     * Logs the JSON representation of the provided {@link GetAgendaCBU} object.
     * This method serializes the {@link GetAgendaCBU} object into a JSON string
     * and logs it using the logger at the INFO level.
     *
     * @param getAgendaCBU the {@link GetAgendaCBU} object to be serialized and logged
     * @throws JsonProcessingException if there is an error during JSON serialization
     */
    private void logObjectToSetRequest(GetAgendaCBU getAgendaCBU) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = objectMapper.writeValueAsString(getAgendaCBU);
        logger.info("Request JSON: {}", jsonRequest);
    }
}
