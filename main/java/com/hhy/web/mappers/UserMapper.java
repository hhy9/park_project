package com.hhy.web.mappers;

import com.hhy.web.user.User;
import com.hhy.web.user.UserDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
        public void insertUser(User user);
        public UserDTO login(UserDTO user);
}
