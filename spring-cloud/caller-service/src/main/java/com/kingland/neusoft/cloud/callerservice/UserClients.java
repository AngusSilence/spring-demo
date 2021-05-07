package com.kingland.neusoft.cloud.callerservice;

import com.kingland.neusoft.cloud.callerservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@FeignClient("called-service")
public interface UserClients {
    @GetMapping("/user/all")
    List<User> getAllUserList();

    @PostMapping("/user")
    User addUser(@RequestBody User user);

    @GetMapping("/user/{userId}")
    User getUserById(@PathVariable int userId);
}
