package com.hhy.web.mappers;

import com.hhy.web.user.User;
import com.hhy.web.user.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
        public void insertUser(UserDTO user);
        public UserDTO login(UserDTO user);
        public void deleteUser(UserDTO user);
        public void updateUser(UserDTO user);
        public List<UserDTO> list();
        public UserDTO selectOne(String userId);
}
