package criteria;

public class ResidentInfo {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private Long buildingId;
    private String buildingAddress;
    private Long apartmentId;
    private Double area;

    public ResidentInfo(Long id, String name, String lastname, String email, String phone,
                        Long buildingId, String buildingAddress, Long apartmentId, Double area) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.buildingId = buildingId;
        this.buildingAddress = buildingAddress;
        this.apartmentId = apartmentId;
        this.area = area;
    }

    @Override
    public String toString() {
        return "\nID: " + id +
                "\nName: " + name +
                "\nLastname: " + lastname +
                "\nEmail: " + email +
                "\nPhone: " + phone +
                "\nBuilding ID: " + buildingId +
                "\nAddress: " + buildingAddress +
                "\nApartment ID: " + apartmentId +
                "\nArea: " + area + "\n";
    }
}