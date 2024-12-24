package com.varegos.varegos.dto.enums;

public enum DocumentTypeEnum {
    DNI("01", "DNI"),
    LE("02", "LE"),
    LC("03", "LC"),
    CUIT("11", "CUIT"),
    CI("101", "CI"),
    PAS("125", "PAS");

    private final String code;
    private final String description;

    // Constructor
    DocumentTypeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    // Método para obtener el tipo de documento por el código
    public static DocumentTypeEnum fromCode(String code) {
        for (DocumentTypeEnum type : DocumentTypeEnum.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Tipo de documento no válido: " + code);
    }

    // Método para validar si el código es un tipo de documento válido
    public static boolean isValid(String code) {
        for (DocumentTypeEnum type : DocumentTypeEnum.values()) {
            if (type.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }
}
