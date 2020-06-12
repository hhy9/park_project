package com.hhy.web.user;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface UserService {
    public void join(User user);
    public UserDTO login(UserDTO user);
}
