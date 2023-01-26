package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.User;
import ks45team02.ire.admin.dto.UserDor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // 회원가입
    public int addUser(User user);
    //  회원 조회
    public List<User> listUser();
    // 아이디 중복체크
    public int idCheck(String userId);
    // 특정 회원 정보 조회
    public User getUserInfoById(String userId);
    // 회원 수정
    public int modifyUser(User user);
    //로그인 이력조회
    public List<User> getLoginHistory();
    //로그인 이력 추가
    public  int updateLoginHistory(String userId);
    //휴면 회원 조회
    public List<UserDor>listUserDor();
    //탈퇴 회원 조회
    public List<User>listUserDrop();
    //회원 탈퇴처리
    public int deleteUser(User user);

}
