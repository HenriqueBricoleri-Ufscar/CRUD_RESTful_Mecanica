package CRUD_RESTful_Mecanica.main.model;

import java.util.List;
import java.sql.Date;

public class Services {
    
    public enum service_Status {
        READY,
        PARTS_ON_ORDER,
        SCHEDULED,
        IN_PROGRESS;
    }

    private String users_id;
    private String service_id;
    private String description;
    private double value;
    private List<String> parts_used;
    private service_Status status;
    private boolean paymentStatus;
    private Date schuduledDate;
    private Date deliveredDate;

    public Services () {}

    public Services(String service_id, String description, double value, List<String> parts_used, service_Status status,
                    String users_id, boolean payment_satus, Date schuduled_date, Date delivered_date) {
        this.users_id = users_id;
        this.service_id = service_id;
        this.description = description;
        this.value = value;
        this.parts_used = parts_used;
        this.status = status;
        this.paymentStatus = payment_satus;
        this.schuduledDate = schuduled_date;
        this.deliveredDate = delivered_date;
    }

    public String getUsers_id() {
        return users_id;
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

    public boolean Payment_satus() {
        return paymentStatus;
    }

    public Date getSchuduled_date() {
        return schuduledDate;
    }

    public Date getDelivered_date() {
        return deliveredDate;
    }

    public void setUsers_id(String users_id) {
        this.users_id = users_id;
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

    public void setPayment_satus(boolean payment_status) {
        this.paymentStatus = payment_status;
    }

    public void setSchuduled_date(Date schuduled_date) {
        this.schuduledDate = schuduled_date;
    }

    public void setDelivered_date(Date delivered_date) {
        this.deliveredDate = delivered_date;
    }
}
