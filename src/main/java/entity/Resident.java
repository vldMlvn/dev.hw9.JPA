package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "resident")
public class Resident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "car_access")
    private boolean carAccess;

    @OneToMany(mappedBy = "resident")
    private List<Residence> residences;

    @OneToMany(mappedBy = "resident")
    private List<ResidentOwnership> ownerships;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public boolean isCarAccess() {
        return carAccess;
    }

    public List<Residence> getResidences() {
        return residences;
    }

    public List<ResidentOwnership> getOwnerships() {
        return ownerships;
    }

    @Override
    public String toString() {
        return "\nResident:" +
                "\nID: " + id +
                "\nName: " + name +
                "\nLastname: " + lastname +
                "\nPhone: " + phone +
                "\nEmail: " + email +
                "\nCar Access: " + carAccess +
                "\nResidences: " + residences +
                "\nOwnerships: " + ownerships +
                "\n";
    }
}