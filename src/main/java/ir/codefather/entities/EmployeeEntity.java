package ir.codefather.entities;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;

@Entity(name = "employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer employeeId;

    @Column(name = "EMAIL", unique = false, nullable = false, length = 100)
    private String email;

    @Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
    private String firstName;

    @Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
    private String lastName;

    @OneToMany
    @JoinColumn(name = "empp")
    private List<AccountEntity> accounts;

    @ManyToMany
    @JoinTable(name = "emp_tags", joinColumns = {@JoinColumn(name = "emp_id", referencedColumnName = "ID")}, inverseJoinColumns = {
            @JoinColumn(name = "tag_id", referencedColumnName = "id")
    })
    private List<Tag> tags;


    @NaturalId
    private Integer SSN;


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<AccountEntity> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountEntity> accounts) {
        this.accounts = accounts;
    }

    public Integer getSSN() {
        return SSN;
    }

    public void setSSN(Integer SSN) {
        this.SSN = SSN;
    }
}