package com.example.sentinel.services;

import org.springframework.stereotype.Service;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.sentinel.models.StatsResponseModel;
import com.example.sentinel.repository.SentinelRepository;

@Service
public class StatsService {
    
    Logger logger = Logger.getLogger(StatsService.class.getName());
    
    public StatsResponseModel getStats(){
        logger.log(Level.INFO, "getStats Starts");
        StatsResponseModel result = new StatsResponseModel(
            SentinelRepository.getInstance().getCantMutants(),
            SentinelRepository.getInstance().getCantHumans()
            );
        logger.log(Level.INFO, "getStats End");
        return result;
    }
}
