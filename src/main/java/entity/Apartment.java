package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "apartment")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;
    @Column(name = "floor")
    private Byte floor;
    @Column(name = "area")
    private Double area;
    @Column(name = "number_of_rooms")
    private Byte numberOfRooms;

    public Long getId() {
        return id;
    }

    public Building getBuilding() {
        return building;
    }

    public Byte getFloor() {
        return floor;
    }

    public Double getArea() {
        return area;
    }

    public Byte getNumberOfRooms() {
        return numberOfRooms;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", building=" + building.getId() +
                ", floor=" + floor +
                ", area=" + area +
                ", numberOfRooms=" + numberOfRooms +
                '}';
    }
}