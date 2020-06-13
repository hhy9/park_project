package com.hhy.web.park;

import com.hhy.web.mappers.ParkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("")
public class ParkController {
    @Autowired ParkMapper parkMapper;
    @Autowired ParkDTO park;

    @GetMapping("/list")
    public List<ParkDTO> list(){
      return null;
    }

    @GetMapping("/{search}/search")
    public Map<?,?> search(@PathVariable String search){
        Map map=new HashMap<>();

        System.out.println(search);

        if(search.equals("null")){
            System.out.println("검색어가없음");
            park.setSearch("");
        }else{
            System.out.println("검색어"+search);
            park.setSearch(search);
        }


        Function<ParkDTO,List<ParkDTO>> f= p->parkMapper.selectParks(p);
        List<ParkDTO> list = f.apply(park);
        map.put("list",list);

        return map;

    }
}
