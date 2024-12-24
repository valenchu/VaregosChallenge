//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.12.14 a las 12:15:27 PM ART 
//


package com.varegos.varegos.wsdl;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para getUltimasTransferenciasResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="getUltimasTransferenciasResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ultimasTransferencias" type="{http://ws.transferencias.banelco.com/}ticketDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUltimasTransferenciasResponse", namespace = "http://ws.transferencias.banelco.com/", propOrder = {
    "ultimasTransferencias"
})
public class GetUltimasTransferenciasResponse {

    protected List<TicketDTO> ultimasTransferencias;

    /**
     * Gets the value of the ultimasTransferencias property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the ultimasTransferencias property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUltimasTransferencias().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TicketDTO }
     * 
     * 
     */
    public List<TicketDTO> getUltimasTransferencias() {
        if (ultimasTransferencias == null) {
            ultimasTransferencias = new ArrayList<TicketDTO>();
        }
        return this.ultimasTransferencias;
    }

}
