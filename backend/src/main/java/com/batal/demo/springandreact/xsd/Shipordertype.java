//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.10.12 at 11:29:46 AM MSK 
//


package com.batal.demo.springandreact.xsd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for shipordertype complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="shipordertype"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="orderperson" type="{}stringtype"/&gt;
 *         &lt;element name="shipto" type="{}shiptotype"/&gt;
 *         &lt;element name="item" type="{}itemtype" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="orderid" use="required" type="{}orderidtype" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shipordertype", propOrder = {
    "orderperson",
    "shipto",
    "item"
})
public class Shipordertype {

    @XmlElement(required = true)
    protected String orderperson;
    @XmlElement(required = true)
    protected Shiptotype shipto;
    @XmlElement(required = true)
    protected List<Itemtype> item;
    @XmlAttribute(name = "orderid", required = true)
    protected String orderid;

    /**
     * Gets the value of the orderperson property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderperson() {
        return orderperson;
    }

    /**
     * Sets the value of the orderperson property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderperson(String value) {
        this.orderperson = value;
    }

    /**
     * Gets the value of the shipto property.
     * 
     * @return
     *     possible object is
     *     {@link Shiptotype }
     *     
     */
    public Shiptotype getShipto() {
        return shipto;
    }

    /**
     * Sets the value of the shipto property.
     * 
     * @param value
     *     allowed object is
     *     {@link Shiptotype }
     *     
     */
    public void setShipto(Shiptotype value) {
        this.shipto = value;
    }

    /**
     * Gets the value of the item property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Itemtype }
     * 
     * 
     */
    public List<Itemtype> getItem() {
        if (item == null) {
            item = new ArrayList<Itemtype>();
        }
        return this.item;
    }

    /**
     * Gets the value of the orderid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderid() {
        return orderid;
    }

    /**
     * Sets the value of the orderid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderid(String value) {
        this.orderid = value;
    }

}