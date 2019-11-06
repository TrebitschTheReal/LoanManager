package hw.loan.service;

import hw.loan.model.Bike;
import hw.loan.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewBikeService {

    @Autowired
    private BikeRepository bikeRepository;

    public void uploadNewBike(Bike newBike){
        bikeRepository.save(newBike);
    }
}
