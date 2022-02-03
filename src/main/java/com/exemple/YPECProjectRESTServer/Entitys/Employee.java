package com.exemple.YPECProjectRESTServer.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table (catalog = "Test",schema = "dbo",name = "Employee")
public class Employee {
    @Id
    @Column (name = "email",unique = true,nullable = false)
    private String email;
    @Column (name = "first_name",nullable = false)
    private String firstName;
    @Column (name = "last_name",nullable = false)
    private String lastName;
    @Column (name = "password",nullable = false)
    private String password;
    @Column (name = "phone",nullable = false)
    private String phone;
    @Column (name = "date_of_birthday")
    private Date dateOfBirthday;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name="id_type"),name = "id_type",nullable = false)
    private TypeEmployee typeEmployee;
    @OneToMany(targetEntity = CabinetWithPrinter.class,fetch =FetchType.LAZY,mappedBy = "employee",cascade = CascadeType.ALL)
    @JsonIgnore
    List<CabinetWithPrinter> cabinetWithPrinterList;
    @OneToMany(targetEntity = Artifact.class,fetch =FetchType.LAZY,mappedBy = "employee",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Artifact> artifactList;

    public Employee() {}

    public Employee(String email, String firstName, String lastName
                    , String password, String phone, Date dateOfBirthday
                    , TypeEmployee typeEmployee) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
        this.dateOfBirthday = dateOfBirthday;
        this.typeEmployee = typeEmployee;
    }

    public List<Artifact> getArtifactList() {
        return artifactList;
    }

    public void setArtifactList(List<Artifact> artifactList) {
        this.artifactList = artifactList;
    }

    public List<CabinetWithPrinter> getCabinetWithPrinterList() {
        return cabinetWithPrinterList;
    }

    public void setCabinetWithPrinterList(List<CabinetWithPrinter> cabinetWithPrinterList) {
        this.cabinetWithPrinterList = cabinetWithPrinterList;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(Date dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public TypeEmployee getTypeEmployee() {
        return typeEmployee;
    }

    public void setTypeEmployee(TypeEmployee typeEmployee) {
        this.typeEmployee = typeEmployee;
    }
}
