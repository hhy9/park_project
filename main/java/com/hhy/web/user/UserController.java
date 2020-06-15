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
        UserDTO user = null;
        @Autowired UserMapper userMapper;
        @Autowired UserRepository userRepository;


@PostMapping("/join")
public void join(
        @RequestBody UserDTO param){

        System.out.println("join..");
    System.out.println(param.toString());
    user = new UserDTO(param.getUserName(),param.getUserId(),param.getPassword());
    userMapper.insertUser(user);
   // userMapper.insertUser(param);

   


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


@PostMapping("/delete")
    public void delete(@RequestBody UserDTO params){
    System.out.println(params.toString());
    userMapper.deleteUser(params);
}

@PostMapping("/{userId}/update")
    public void update(@PathVariable String userId,
            @RequestBody UserDTO params){

    System.out.println("userid"+userId);
    user.setUserName(params.getUserName());
    user.setPassword(params.getPassword());
    System.out.println(user.toString());
    userMapper.updateUser(user);
}


}
