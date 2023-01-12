
package com.deceval.mrc.solicitud;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.deceval.mrc.solicitud package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GenerarToken_QNAME = new QName("http://com/deceval/mrc/solicitud", "generarToken");
    private final static QName _GenerarTokenResponse_QNAME = new QName("http://com/deceval/mrc/solicitud", "generarTokenResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.deceval.mrc.solicitud
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GenerarToken }
     * 
     */
    public GenerarToken createGenerarToken() {
        return new GenerarToken();
    }

    /**
     * Create an instance of {@link GenerarTokenResponse }
     * 
     */
    public GenerarTokenResponse createGenerarTokenResponse() {
        return new GenerarTokenResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com/deceval/mrc/solicitud", name = "generarToken")
    public JAXBElement<GenerarToken> createGenerarToken(GenerarToken value) {
        return new JAXBElement<GenerarToken>(_GenerarToken_QNAME, GenerarToken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarTokenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com/deceval/mrc/solicitud", name = "generarTokenResponse")
    public JAXBElement<GenerarTokenResponse> createGenerarTokenResponse(GenerarTokenResponse value) {
        return new JAXBElement<GenerarTokenResponse>(_GenerarTokenResponse_QNAME, GenerarTokenResponse.class, null, value);
    }

}
