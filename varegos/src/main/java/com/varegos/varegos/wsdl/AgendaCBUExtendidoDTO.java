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
 * <p>Clase Java para agendaCBUExtendidoDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="agendaCBUExtendidoDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="alias" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cuitCuil" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nroCBU" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="propiedadDTO" type="{http://ws.transferencias.banelco.com/}propiedadDTO" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "agendaCBUExtendidoDTO", namespace = "http://ws.transferencias.banelco.com/", propOrder = {
    "alias",
    "cuitCuil",
    "descripcion",
    "nroCBU",
    "propiedadDTO"
})
public class AgendaCBUExtendidoDTO {

    protected String alias;
    protected String cuitCuil;
    protected String descripcion;
    protected String nroCBU;
    protected PropiedadDTO propiedadDTO;

    /**
     * Obtiene el valor de la propiedad alias.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Define el valor de la propiedad alias.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlias(String value) {
        this.alias = value;
    }

    /**
     * Obtiene el valor de la propiedad cuitCuil.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuitCuil() {
        return cuitCuil;
    }

    /**
     * Define el valor de la propiedad cuitCuil.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuitCuil(String value) {
        this.cuitCuil = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad nroCBU.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNroCBU() {
        return nroCBU;
    }

    /**
     * Define el valor de la propiedad nroCBU.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNroCBU(String value) {
        this.nroCBU = value;
    }

    /**
     * Obtiene el valor de la propiedad propiedadDTO.
     * 
     * @return
     *     possible object is
     *     {@link PropiedadDTO }
     *     
     */
    public PropiedadDTO getPropiedadDTO() {
        return propiedadDTO;
    }

    /**
     * Define el valor de la propiedad propiedadDTO.
     * 
     * @param value
     *     allowed object is
     *     {@link PropiedadDTO }
     *     
     */
    public void setPropiedadDTO(PropiedadDTO value) {
        this.propiedadDTO = value;
    }

}
