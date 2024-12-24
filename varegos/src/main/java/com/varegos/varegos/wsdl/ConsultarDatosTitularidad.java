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
 * <p>Clase Java para consultarDatosTitularidad complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="consultarDatosTitularidad"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="usuario" type="{http://ws.transferencias.banelco.com/}usuarioDTO" minOccurs="0"/&gt;
 *         &lt;element name="terminal" type="{http://ws.transferencias.banelco.com/}terminalDTO" minOccurs="0"/&gt;
 *         &lt;element name="cuentaOrigen" type="{http://ws.transferencias.banelco.com/}cuentaDTO" minOccurs="0"/&gt;
 *         &lt;element name="cbuDestino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarDatosTitularidad", namespace = "http://ws.transferencias.banelco.com/", propOrder = {
    "usuario",
    "terminal",
    "cuentaOrigen",
    "cbuDestino"
})
public class ConsultarDatosTitularidad {

    protected UsuarioDTO usuario;
    protected TerminalDTO terminal;
    protected CuentaDTO cuentaOrigen;
    protected String cbuDestino;

    /**
     * Obtiene el valor de la propiedad usuario.
     * 
     * @return
     *     possible object is
     *     {@link UsuarioDTO }
     *     
     */
    public UsuarioDTO getUsuario() {
        return usuario;
    }

    /**
     * Define el valor de la propiedad usuario.
     * 
     * @param value
     *     allowed object is
     *     {@link UsuarioDTO }
     *     
     */
    public void setUsuario(UsuarioDTO value) {
        this.usuario = value;
    }

    /**
     * Obtiene el valor de la propiedad terminal.
     * 
     * @return
     *     possible object is
     *     {@link TerminalDTO }
     *     
     */
    public TerminalDTO getTerminal() {
        return terminal;
    }

    /**
     * Define el valor de la propiedad terminal.
     * 
     * @param value
     *     allowed object is
     *     {@link TerminalDTO }
     *     
     */
    public void setTerminal(TerminalDTO value) {
        this.terminal = value;
    }

    /**
     * Obtiene el valor de la propiedad cuentaOrigen.
     * 
     * @return
     *     possible object is
     *     {@link CuentaDTO }
     *     
     */
    public CuentaDTO getCuentaOrigen() {
        return cuentaOrigen;
    }

    /**
     * Define el valor de la propiedad cuentaOrigen.
     * 
     * @param value
     *     allowed object is
     *     {@link CuentaDTO }
     *     
     */
    public void setCuentaOrigen(CuentaDTO value) {
        this.cuentaOrigen = value;
    }

    /**
     * Obtiene el valor de la propiedad cbuDestino.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCbuDestino() {
        return cbuDestino;
    }

    /**
     * Define el valor de la propiedad cbuDestino.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCbuDestino(String value) {
        this.cbuDestino = value;
    }

}
