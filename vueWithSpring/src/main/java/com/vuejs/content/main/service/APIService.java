package com.vuejs.content.main.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vuejs.content.config.JwtTokenProvider;
import com.vuejs.content.main.dao.APIRepository;
import com.vuejs.content.vo.UserDetailsVO;
import com.vuejs.content.vo.UserVo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class APIService implements UserDetailsService {

	@Autowired
	private APIRepository repository;

	@Autowired
	BCryptPasswordEncoder encoder;

	private final JwtTokenProvider jwtTokenProvider;

	//회원가입
	public int joinUser(Map<String,Object> user) {
		user.put("user_pwd", encoder.encode((String) user.get("user_pwd")));
		user.put("auth", "ROLE_USER");
		return repository.joinUser(user);
	}
	
	
	// 시큐리티 로그인   [request 의 header 의 값으 추출할 때에 사용된다.]
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetailsVO user = new UserDetailsVO();
		List<String> authoList = new ArrayList<String>();
		UserVo dbUser = repository.selectUserById(username);
		authoList.add(dbUser.getUser_auth());
		user.setAuthorities(authoList);
		user.setUsername(dbUser.getUser_id());
		System.out.println("검사한다~");
		return user;
	}


	//로그인  [토큰 발급용]
	public Map<String,Object> login(Map<String,Object> user) {
		Map<String,Object> loginUser =  new HashMap<String, Object>();
		
		String userId = user.get("user_id").toString();
		String userPwd = user.get("user_pwd").toString();
		
		UserVo dbUser = repository.selectUserById(userId);
		UserVo login = new UserVo();
		List<String> autho = new ArrayList<String>();

		try {
			//if (!encoder.matches(user.getUser_pwd(), dbUser.getUser_pwd()) || dbUser == null) {
			if (!userPwd.equals(dbUser.getUser_pwd()) || dbUser == null) {
				System.out.println("로그인 실패");
				return loginUser;
			}else {
				System.out.println("로그인 성공");
				
				autho.add(dbUser.getUser_auth());
				//권한
				loginUser.put("user_auth", dbUser.getUser_auth());
				//토큰
				loginUser.put("user_token", jwtTokenProvider.createToken(dbUser.getUser_id(), autho));
				//아이디
				loginUser.put("user_id", dbUser.getUser_id());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginUser;
	}

	//아이디 중복체크
	public String dupCheck(Map<String,Object> param) {
		boolean result = repository.dupCheck(param);
		if(result) {return "false";}
		return "true";
	}

}
