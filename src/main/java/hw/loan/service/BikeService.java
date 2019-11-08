package hw.loan.service;

import hw.loan.model.Bike;
import hw.loan.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    public List<Bike> listBike() {
        return bikeRepository.findAll();
    }

    public void deleteBike(long id) {
        bikeRepository.deleteById(id);
    }
}
