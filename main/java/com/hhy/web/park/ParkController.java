package com.hhy.web.park;

import com.hhy.web.mappers.ParkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("")
public class ParkController {
    @Autowired ParkMapper parkMapper;

    @GetMapping("/list")
    public List<ParkDTO> list(){
        return parkMapper.selectParks();
    }
}
