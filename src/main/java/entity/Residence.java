package entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "residence")
public class Residence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "resident_id")
    private Resident resident;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_start_stay")
    private Date dateStartStay;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_end_stay")
    private Date dateEndStay;

    public Long getId() {
        return id;
    }

    public Resident getResident() {
        return resident;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public Date getDateStartStay() {
        return dateStartStay;
    }

    public Date getDateEndStay() {
        return dateEndStay;
    }

    @Override
    public String toString() {
        return "\nResidence{" +
                "id=" + id +
                ", resident=" + resident.getId() +
                ", apartment=" + apartment.getId() +
                ", dateStartStay=" + dateStartStay +
                ", dateEndStay=" + dateEndStay +
                "}";
    }
}