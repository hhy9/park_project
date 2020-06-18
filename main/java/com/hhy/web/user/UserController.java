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
public Map<?,?> join(
        @RequestBody UserDTO param){
    Map map = new HashMap<>();
        System.out.println("join..");
    System.out.println(param.toString());
    System.out.println(userMapper.selectOne(param.getUserId()));


        if (userMapper.selectOne(param.getUserId()) !=null) {
            map.put("popupResult", "이미 있는 아이디입니다.");
            map.put("result", false);
        } else {
            user = new UserDTO(param.getUserName(), param.getUserId(), param.getPassword());
            userMapper.insertUser(user);
            map.put("popupResult", "가입완료");
            map.put("result", true);
        }
    System.out.println(map.get("popupResult"));
    return map;
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
