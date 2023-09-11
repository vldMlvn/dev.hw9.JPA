package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "resident_ownership")
public class ResidentOwnership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "resident_id")
    private Resident resident;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    public Long getId() {
        return id;
    }

    public Resident getResident() {
        return resident;
    }

    public Apartment getApartment() {
        return apartment;
    }

    @Override
    public String toString() {
        return "\nOwnership{" +
                "id=" + id +
                ", resident=" + resident.getId() +
                ", apartment=" + apartment.getId() +
                '}';
    }
}