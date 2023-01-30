package ks45team02.ire.admin.service;

import ks45team02.ire.admin.dto.User;
import ks45team02.ire.admin.dto.UserDor;
import ks45team02.ire.admin.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        return result;
    }
    public int idCheck(String userId){
        // 중복 회원 아이디 체크
        int result = userMapper.idCheck(userId);
        return result;
    }
    public List<User> listUser( ){
        //  회원 조회
        List<User>listUser=userMapper.listUser();
        return listUser;
    }
    public User getUserInfoById(String userId){
        // 특정회원 조회
        User userInfo= userMapper.getUserInfoById(userId);
        System.out.println(userId+"무슨 아이디?");
        System.out.println(userInfo+"인포서비스");
        return userInfo;
    }
    public int modifyUser(User user){
        //회원 수정
        int result = userMapper.modifyUser(user);
        return result;
    }
    public Map<String,Object> checkPwByMemberId(String userId, String memberPw){
        //회원 정보 확인
        Map<String,Object> resultMap=new HashMap<String,Object>();

        boolean result = false;
        User user = userMapper.getUserInfoById(userId);

        if(user !=null){
            String checkPw=user.getUserPw();
            if(memberPw.equals(checkPw)){
                result=true;
            }
        }
        resultMap.put("result",result);
        resultMap.put("userInfo",user);
        return resultMap;
    }
    public int updateLoginHistory(String userId){
        //로그인 이력 추가
        return userMapper.updateLoginHistory(userId);
    }
    public List<User>getLoginHistory(){
        //로그인 이력 조회
        List<User> loginHistory=userMapper.getLoginHistory();
        return  loginHistory;
    }
    public List<UserDor>userDorList(){
        //휴면 회원조회
        return userMapper.listUserDor();
    }
    public List<User>userDropList(){
        //탈퇴 회원 조회
        return userMapper.listUserDrop();
    }
    public int deleteUser(User user){
        //회원탈퇴=변경
        return userMapper.deleteUser(user);
    }
    public int logoutHistory(String userId){
        //로그아웃시 시간 기록
        return userMapper.logoutHistory(userId);
    }

}
