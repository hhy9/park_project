package com.hhy.web.mappers;

import com.hhy.web.park.ParkDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkMapper {
    public List<ParkDTO> selectParks();
}
