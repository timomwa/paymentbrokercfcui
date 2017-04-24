package ug.or.nda.wsi;

public enum InvoiceStatus {
	
	PAID,
    UNPAID,
    EXPIRED,
    PENDING_VERIFICATION;

    public String value() {
        return name();
    }

    public static InvoiceStatus fromValue(String v) {
        return valueOf(v);
    }

}
