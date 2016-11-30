package project.model.tourist;

import com.google.common.base.MoreObjects;
import project.model.passport.Passport;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created by slava23 on 11/30/2016.
 */

/*@Entity*/
public class Tourist {

   /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)*/
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Date birthday;
    /*@OneToMany(targetEntity = Passport.class, mappedBy = "tourist")*/
    private Collection<Passport> passports;
    @Enumerated(EnumType.STRING)
    private Source source;

    public Tourist() {
    }

    public Tourist(String firstName, String lastName, String phone, String email, Date birthday, Collection<Passport> passports, Source source) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.passports = passports;
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("firstName", firstName)
                .add("lastName", lastName)
                .add("phone", phone)
                .add("email", email)
                .add("birthday", birthday)
                .add("source", source)
                .toString();
    }
}
