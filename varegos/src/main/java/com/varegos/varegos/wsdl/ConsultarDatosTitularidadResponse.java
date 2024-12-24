//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.12.14 a las 12:15:27 PM ART 
//


package com.varegos.varegos.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para consultarDatosTitularidadResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="consultarDatosTitularidadResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="titularidad" type="{http://ws.transferencias.banelco.com/}titularidadDTO" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarDatosTitularidadResponse", namespace = "http://ws.transferencias.banelco.com/", propOrder = {
    "titularidad"
})
public class ConsultarDatosTitularidadResponse {

    protected TitularidadDTO titularidad;

    /**
     * Obtiene el valor de la propiedad titularidad.
     * 
     * @return
     *     possible object is
     *     {@link TitularidadDTO }
     *     
     */
    public TitularidadDTO getTitularidad() {
        return titularidad;
    }

    /**
     * Define el valor de la propiedad titularidad.
     * 
     * @param value
     *     allowed object is
     *     {@link TitularidadDTO }
     *     
     */
    public void setTitularidad(TitularidadDTO value) {
        this.titularidad = value;
    }

}
