package hw.loan.repository;

import hw.loan.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> {
    List<Bike> deleteById(long id);
    List<Bike> findByUnderRepair(long id);
    List<Bike> findByRentable(long id);

}