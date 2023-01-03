package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.LoginOutHistory;
import ks45team02.ire.admin.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    //  회원가입
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
    public List<LoginOutHistory>getLoginHistory(Map<String,Object> paramMap);
    //로그인이력 전체행의 개수
    public int getLoginHistoryCNT();

}
