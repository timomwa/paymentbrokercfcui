
package ug.or.nda.ws.client.payment;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import ug.or.nda.dto.QueryDTO;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ug.or.nda.services package. 
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

    private final static QName _ListPaymentRawLogsResponse_QNAME = new QName("http://services.nda.or.ug", "listPaymentRawLogsResponse");
    private final static QName _ListInvoices_QNAME = new QName("http://services.nda.or.ug", "listInvoices");
    private final static QName _ListInvoicesResponse_QNAME = new QName("http://services.nda.or.ug", "listInvoicesResponse");
    private final static QName _ListPaymentsResponse_QNAME = new QName("http://services.nda.or.ug", "listPaymentsResponse");
    private final static QName _ListPaymentRawLogs_QNAME = new QName("http://services.nda.or.ug", "listPaymentRawLogs");
    private final static QName _ListPayments_QNAME = new QName("http://services.nda.or.ug", "listPayments");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ug.or.nda.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListPaymentRawLogs }
     * 
     */
    public ListPaymentRawLogs createListPaymentRawLogs() {
        return new ListPaymentRawLogs();
    }

    /**
     * Create an instance of {@link QueryDTO }
     * 
     */
    public QueryDTO createQueryDTO() {
        return new QueryDTO();
    }

    /**
     * Create an instance of {@link ListPaymentRawLogsResponse }
     * 
     */
    public ListPaymentRawLogsResponse createListPaymentRawLogsResponse() {
        return new ListPaymentRawLogsResponse();
    }

    /**
     * Create an instance of {@link ListInvoicesResponse }
     * 
     */
    public ListInvoicesResponse createListInvoicesResponse() {
        return new ListInvoicesResponse();
    }

    /**
     * Create an instance of {@link ListInvoices }
     * 
     */
    public ListInvoices createListInvoices() {
        return new ListInvoices();
    }

    /**
     * Create an instance of {@link ListPaymentsResponse }
     * 
     */
    public ListPaymentsResponse createListPaymentsResponse() {
        return new ListPaymentsResponse();
    }

    /**
     * Create an instance of {@link ListPayments }
     * 
     */
    public ListPayments createListPayments() {
        return new ListPayments();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPaymentRawLogsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.nda.or.ug", name = "listPaymentRawLogsResponse")
    public JAXBElement<ListPaymentRawLogsResponse> createListPaymentRawLogsResponse(ListPaymentRawLogsResponse value) {
        return new JAXBElement<ListPaymentRawLogsResponse>(_ListPaymentRawLogsResponse_QNAME, ListPaymentRawLogsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListInvoices }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.nda.or.ug", name = "listInvoices")
    public JAXBElement<ListInvoices> createListInvoices(ListInvoices value) {
        return new JAXBElement<ListInvoices>(_ListInvoices_QNAME, ListInvoices.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListInvoicesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.nda.or.ug", name = "listInvoicesResponse")
    public JAXBElement<ListInvoicesResponse> createListInvoicesResponse(ListInvoicesResponse value) {
        return new JAXBElement<ListInvoicesResponse>(_ListInvoicesResponse_QNAME, ListInvoicesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPaymentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.nda.or.ug", name = "listPaymentsResponse")
    public JAXBElement<ListPaymentsResponse> createListPaymentsResponse(ListPaymentsResponse value) {
        return new JAXBElement<ListPaymentsResponse>(_ListPaymentsResponse_QNAME, ListPaymentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPaymentRawLogs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.nda.or.ug", name = "listPaymentRawLogs")
    public JAXBElement<ListPaymentRawLogs> createListPaymentRawLogs(ListPaymentRawLogs value) {
        return new JAXBElement<ListPaymentRawLogs>(_ListPaymentRawLogs_QNAME, ListPaymentRawLogs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPayments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.nda.or.ug", name = "listPayments")
    public JAXBElement<ListPayments> createListPayments(ListPayments value) {
        return new JAXBElement<ListPayments>(_ListPayments_QNAME, ListPayments.class, null, value);
    }

}
