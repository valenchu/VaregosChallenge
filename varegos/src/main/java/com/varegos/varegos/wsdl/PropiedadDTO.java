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
 * <p>Clase Java para propiedadDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="propiedadDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ws.transferencias.banelco.com/}baseDTO"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ctaCorriente" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="propia" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "propiedadDTO", namespace = "http://ws.transferencias.banelco.com/", propOrder = {
    "ctaCorriente",
    "propia"
})
public class PropiedadDTO
    extends BaseDTO
{

    protected Boolean ctaCorriente;
    protected Boolean propia;

    /**
     * Obtiene el valor de la propiedad ctaCorriente.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCtaCorriente() {
        return ctaCorriente;
    }

    /**
     * Define el valor de la propiedad ctaCorriente.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCtaCorriente(Boolean value) {
        this.ctaCorriente = value;
    }

    /**
     * Obtiene el valor de la propiedad propia.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPropia() {
        return propia;
    }

    /**
     * Define el valor de la propiedad propia.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPropia(Boolean value) {
        this.propia = value;
    }

}
