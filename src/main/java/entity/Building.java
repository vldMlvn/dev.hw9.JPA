package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "building")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "address")
    private String address;
    @Column(name = "floors")
    private Byte floors;
    @Column(name = "number_of_apartments")
    private Integer numberOfApartments;

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Byte getFloors() {
        return floors;
    }

    public Integer getNumberOfApartments() {
        return numberOfApartments;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", floors=" + floors +
                ", numberOfApartments=" + numberOfApartments +
                '}';
    }
}