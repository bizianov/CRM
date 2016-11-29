package project.model.passport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by slava23 on 11/29/2016.
 */

@Entity
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String serialNumber;
    private String issuer;
    private Date issueDate;
    private Date expireDate;

    public Passport() {
    }

    public Passport(String serialNumber, String issuer, Date issueDate, Date expireDate) {
        this.serialNumber = serialNumber;
        this.issuer = issuer;
        this.issueDate = issueDate;
        this.expireDate = expireDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "serialNumber='" + serialNumber + '\'' +
                ", issuer='" + issuer + '\'' +
                ", issueDate=" + issueDate +
                ", expireDate=" + expireDate +
                '}';
    }
}
