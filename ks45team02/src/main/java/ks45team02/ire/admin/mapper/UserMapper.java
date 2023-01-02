package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // 김재범 - 회원가입
    public int addUser(User user);
    // 김재범 - 회원 조회
    public List<User> listUser();


}
