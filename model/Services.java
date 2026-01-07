package CRUD_RESTful_Mecanica.model;

import java.util.List;
import java.sql.Date;

public class Services {
    
    public enum service_Status {
        READY,
        PARTS_ON_ORDER,
        SCHEDULED,
        IN_PROGRESS;
    }

    private String service_id;
    private String description;
    private double value;
    private List<String> parts_used;
    private service_Status status;
    private boolean payment_satus;
    private Date schuduled_date;
    private Date delivered_date;

    public Services () {}

    public Services(String service_id, String description, double value, List<String> parts_used, service_Status status,
                    boolean payment_satus, Date schuduled_date, Date delivered_date) {
        this.service_id = service_id;
        this.description = description;
        this.value = value;
        this.parts_used = parts_used;
        this.status = status;
        this.payment_satus = payment_satus;
        this.schuduled_date = schuduled_date;
        this.delivered_date = delivered_date;
    }

    public String getService_id() {
        return service_id;
    }

    public String getDescription() {
        return description;
    }

    public double getValue() {
        return value;
    }

    public List<String> getParts_used() {
        return parts_used;
    }

    public service_Status getStatus() {
        return status;
    }

    public boolean isPayment_satus() {
        return payment_satus;
    }

    public Date getSchuduled_date() {
        return schuduled_date;
    }

    public Date getDelivered_date() {
        return delivered_date;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setParts_used(List<String> parts_used) {
        this.parts_used = parts_used;
    }

    public void setStatus(service_Status status) {
        this.status = status;
    }

    public void setPayment_satus(boolean payment_satus) {
        this.payment_satus = payment_satus;
    }

    public void setSchuduled_date(Date schuduled_date) {
        this.schuduled_date = schuduled_date;
    }

    public void setDelivered_date(Date delivered_date) {
        this.delivered_date = delivered_date;
    }
}
