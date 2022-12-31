package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    // 김재범 -회원가입
    public int addUser(User user);
    public void test();

}
