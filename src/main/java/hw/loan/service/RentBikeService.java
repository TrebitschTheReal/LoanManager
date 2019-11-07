package hw.loan.service;

import hw.loan.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentBikeService {
    @Autowired
    private BikeRepository bikeRepository;




}
