package ks45team02.ire.admin.service;

import ks45team02.ire.admin.dto.LoginOutHistory;
import ks45team02.ire.admin.dto.User;
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
        System.out.println(result);
        System.out.println("올릴려고 적음");
        System.out.println(user);
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
    public Map<String,Object>getLoginHistory(int currentPage){
        //보여질 행의 개수
        int rowPerPage=10;
        // 로그인 이력 테이블의 보여질 행의 시작점
        int startRowNum=(currentPage-1)*rowPerPage;

        // 마지막 페이지
        // 1.로그인 이력테이블의 전체 행의 갯수
        double rowCnt= userMapper.getLoginHistoryCNT();

        // 2.마지막 페이지
        int lastPage=(int) Math.ceil(rowCnt/rowPerPage);

        //보여질 페이지 번호 구현
        //보여질 페이지 번호 초기화
        int startPageNum=1;
        int endPageNum=10;

        //동적 페이지 번호 구현
        if(currentPage>6 && lastPage>9){
            startPageNum=currentPage - 5;
            endPageNum=currentPage + 4;
            if(endPageNum>lastPage){
                startPageNum=lastPage - (lastPage-1);
                endPageNum=lastPage;
            }
        }
        //로그인 이력조회시 Limit 인수 파라미터 셋팅
        Map<String,Object>paramMap=new HashMap<String,Object>();
        paramMap.put("startRowNum",startRowNum);
        paramMap.put("rowPerPage",rowPerPage);

        //로그인 이력 data
        List<LoginOutHistory> loginHistory=userMapper.getLoginHistory(paramMap);

        //controller에 전달하기 위한 파라미터 셋팅
        paramMap.put("loginHistory",loginHistory);
        paramMap.put("lastPage",lastPage);
        paramMap.put("startPageNum",startPageNum);
        paramMap.put("endPageNum",endPageNum);

        return paramMap;
    }
}
