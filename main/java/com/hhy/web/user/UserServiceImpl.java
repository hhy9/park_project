package com.hhy.web.user;

import com.hhy.web.mappers.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
        public UserMapper userMapper;
    @Override
    public void join(User user) {
                userMapper.insertUser(user);
    }

    @Override
    public UserDTO login(UserDTO user) {
        return userMapper.login(user);
    }
}
