package ks45team02.ire.admin.service;

import ks45team02.ire.admin.dto.User;
<<<<<<< HEAD
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void addUser(User user) {
=======
import ks45team02.ire.admin.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    private static final Logger log= LoggerFactory.getLogger(UserService.class);
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    public int addUser(User user){
        // 김재범 -회원가입 처리
        int result=userMapper.addUser(user);
        System.out.println(result);
        System.out.println("올릴려고 적음");
        System.out.println(user);
        return result;
>>>>>>> b604be1355a7a8911d27e0ce7ac6c8b08b8ae178
    }
}
