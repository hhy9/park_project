package com.hhy.web.user;

import com.hhy.web.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/users")
public class UserController {
        @Autowired UserDTO user;
        @Autowired UserMapper userMapper;

@PostMapping("/{userId}/join")
public void join(@PathVariable String userId,
        @RequestBody UserDTO param){
    System.out.println(userId);
        System.out.println("join..");
    System.out.println(param.toString());
      userMapper.insertUser(param);

    }

@PostMapping("/{userId}/access")
    public Map<?,?> login(@PathVariable String userId,
                          @RequestBody UserDTO params){
    System.out.println(userId);
    Map map = new HashMap<>();
    user = userMapper.login(params);
    if(user!=null){
        System.out.println("로그인 정보"+user.toString());
        map.put("result",true);
    }else{
        map.put("result",false);
    }
    map.put("user",user);
    return map;

}
}
