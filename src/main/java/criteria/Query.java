package criteria;

import entity.Apartment;
import entity.Building;
import entity.Resident;
import entity.ResidentOwnership;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class Query {
    private Query() {
    }

    public static List<ResidentInfo> getResidentsWithCriteria(EntityManager entityManager) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        jakarta.persistence.criteria.CriteriaQuery<ResidentInfo> criteriaQuery = criteriaBuilder.createQuery(ResidentInfo.class);
        Root<Resident> residentRoot = criteriaQuery.from(Resident.class);

        Join<Resident, ResidentOwnership> residentOwnershipJoin = residentRoot.join("ownerships");
        Join<ResidentOwnership, Apartment> apartmentJoin = residentOwnershipJoin.join("apartment");
        Join<Apartment, Building> buildingJoin = apartmentJoin.join("building");

        criteriaQuery.select(criteriaBuilder.construct(
                ResidentInfo.class,
                residentRoot.get("id"),
                residentRoot.get("name"),
                residentRoot.get("lastname"),
                residentRoot.get("email"),
                residentRoot.get("phone"),
                buildingJoin.get("id"),
                buildingJoin.get("address"),
                apartmentJoin.get("id"),
                apartmentJoin.get("area")
        ));

        Predicate carAccessPredicate = criteriaBuilder.equal(residentRoot.get("carAccess"), false);
        Predicate ownershipCountPredicate = criteriaBuilder.lessThan(
                criteriaBuilder.size(residentRoot.get("ownerships")), 2);

        criteriaQuery.where(criteriaBuilder.and(carAccessPredicate, ownershipCountPredicate));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}