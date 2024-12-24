package com.varegos.varegos.dto.mappers;

import com.varegos.varegos.dto.GetAgendaCBUResponseDTO;
import com.varegos.varegos.dto.PropiedadDtoResum;
import com.varegos.varegos.wsdl.GetAgendaCBU;
import com.varegos.varegos.wsdl.GetAgendaCBUResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetAgendaCBUResponseMapper {
    /**
     * Maps the data from a SOAP response into a list of {@link GetAgendaCBUResponseDTO} objects.
     * It filters the agenda data based on the document number and type, and maps the relevant
     * details into a DTO for further processing.
     *
     * @param value        the {@link GetAgendaCBUResponse} object containing the agenda data to be mapped.
     * @param getAgendaCBU the original request object containing the user’s document details,
     *                     used for filtering the agenda data.
     * @return a List of {@link GetAgendaCBUResponseDTO} containing the mapped agenda data.
     * @throws RuntimeException if no agenda data matches the provided document type and number.
     */
    public List<GetAgendaCBUResponseDTO> mapResponseToDtoAgenda(GetAgendaCBUResponse value, GetAgendaCBU getAgendaCBU) {
        List<GetAgendaCBUResponseDTO> getAgendaCBUResponseDTO = new ArrayList<>();
        value.getAgendaCBU().stream()
                .filter(agendaFilter -> agendaFilter.getCuitCuil().trim().equals(getAgendaCBU.getUsuario().getNroDocumento())
                        && agendaFilter.getPropiedadDTO().getCodigo().equals(getAgendaCBU.getUsuario().getTipoDocumento())).
                forEach(agenda -> {
                    GetAgendaCBUResponseDTO agendaCBUResponseDTO = new GetAgendaCBUResponseDTO();
                    PropiedadDtoResum propiedadDtoResum = new PropiedadDtoResum();
                    agendaCBUResponseDTO.setCbu(agenda.getNroCBU());
                    agendaCBUResponseDTO.setCuit(agenda.getCuitCuil());
                    propiedadDtoResum.setCode(Integer.valueOf(agenda.getPropiedadDTO().getCodigo()));
                    propiedadDtoResum.setDescription(agenda.getPropiedadDTO().getDescripcion());
                    propiedadDtoResum.setCurrent(agenda.getPropiedadDTO().isCtaCorriente());
                    agendaCBUResponseDTO.setPropiedadDTO(propiedadDtoResum);
                    getAgendaCBUResponseDTO.add(agendaCBUResponseDTO);
                });
        if (getAgendaCBUResponseDTO.isEmpty()) {
            throw new RuntimeException(String.format("Not exist data with type document %s and number document %s", getAgendaCBU.getUsuario().getTipoDocumento(), getAgendaCBU.getUsuario().getNroDocumento()));
        }
        return getAgendaCBUResponseDTO;
    }

    /**
     * Maps the data from a SOAP response into a list of {@link GetAgendaCBUResponseDTO} objects.
     * Unlike the other mapping method, this method does not filter the agenda data based on
     * the document type and number. It maps all the agenda data into DTOs for further processing.
     *
     * @param value the {@link GetAgendaCBUResponse} object containing the agenda data to be mapped.
     * @return a List of {@link GetAgendaCBUResponseDTO} containing the mapped agenda data, or
     * {@code null} if no data is found in the response.
     */
    public List<GetAgendaCBUResponseDTO> mapResponseToDtoAgenda(GetAgendaCBUResponse value) {
        List<GetAgendaCBUResponseDTO> getAgendaCBUResponseDTO = new ArrayList<>();
        value.getAgendaCBU().stream().
                forEach(agenda -> {
                    GetAgendaCBUResponseDTO agendaCBUResponseDTO = new GetAgendaCBUResponseDTO();
                    PropiedadDtoResum propiedadDtoResum = new PropiedadDtoResum();
                    agendaCBUResponseDTO.setCbu(agenda.getNroCBU());
                    agendaCBUResponseDTO.setCuit(agenda.getCuitCuil());
                    propiedadDtoResum.setCode(Integer.valueOf(agenda.getPropiedadDTO().getCodigo()));
                    propiedadDtoResum.setDescription(agenda.getPropiedadDTO().getDescripcion());
                    propiedadDtoResum.setCurrent(agenda.getPropiedadDTO().isCtaCorriente());
                    agendaCBUResponseDTO.setPropiedadDTO(propiedadDtoResum);
                    getAgendaCBUResponseDTO.add(agendaCBUResponseDTO);
                });
        if (getAgendaCBUResponseDTO.isEmpty()) {
            return null;
        }
        return getAgendaCBUResponseDTO;
    }
}
