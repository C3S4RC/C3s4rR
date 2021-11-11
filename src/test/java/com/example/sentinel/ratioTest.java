package com.example.sentinel;

import com.example.sentinel.models.StatsResponseModel;
import com.example.sentinel.services.StatsService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ratioTest {

	@Test
	void contextLoads() {
        StatsService service = new StatsService();

        StatsResponseModel result = service.getStats();
        if (result == null || 
            result.getCountHumanDna() == null || 
            result.getCountMutantDna() == null ||
            result.getRation() == null)
        {
            assert(false);
        }
        assert(true);
	}

}




