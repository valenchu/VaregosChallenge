package com.varegos.varegos.dto;

public class GetAgendaCBUResponseDTO {
    private String cuit;
    private String cbu;
    private PropiedadDtoResum propiedadDTO;

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public PropiedadDtoResum getPropiedadDTO() {
        return propiedadDTO;
    }

    public void setPropiedadDTO(PropiedadDtoResum propiedadDTO) {
        this.propiedadDTO = propiedadDTO;
    }
}
