package com.vuejs.content.main.service;

import java.util.ArrayList;
import java.util.List;

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
	public int joinUser(UserVo user) {
		UserVo insertVo = new UserVo();
		insertVo.setUser_id(user.getUser_id());
		insertVo.setUser_pwd(encoder.encode(user.getUser_pwd()));
		insertVo.setUser_auth("ROLE_USER");
		return repository.joinUser(insertVo);
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
	public UserVo login(UserVo user) {
		System.out.print("로그인파람:"+user.toString());
		
		UserVo dbUser = repository.selectUserById(user.getUser_id());
		UserVo login = new UserVo();
		List<String> autho = new ArrayList<String>();

		try {
			//if (!encoder.matches(user.getUser_pwd(), dbUser.getUser_pwd()) || dbUser == null) {
			if (!user.getUser_pwd().equals(dbUser.getUser_pwd()) || dbUser == null) {
				System.out.println("로그인 실패");
				return login;
			}else {
				System.out.println("로그인 성공");
				autho.add(dbUser.getUser_auth());
				login.setUser_auth(dbUser.getUser_auth());          //권한 set
				login.setToken(jwtTokenProvider.createToken(dbUser.getUser_id(), autho)); // 토큰 set
				login.setUser_id(dbUser.getUser_id());           // 아이디 set
				System.out.println(login.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return login;
	}

	public void testauth(String token) {
		System.out.println("권한 체크" + jwtTokenProvider.validateToken(token)); // true
		System.out.println("유저이름 뽑기" + jwtTokenProvider.getUserPk(token)); // gusdnd
		System.out.println("인증 뽑기" + jwtTokenProvider.getAuthentication(token)); // 인증정보 유처객체,
	}

}
