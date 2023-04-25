package com.jay.user.web;

import com.jay.user.pojo.User;
import com.jay.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id, @RequestHeader(value="queshi",required = false) String head) {
        System.out.println(head);
        return userService.queryById(id);
    }
}
