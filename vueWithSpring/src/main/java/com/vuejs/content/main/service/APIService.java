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

	// private final JwtTokenProvider jwtTokenProvider; 기본생성자 주입을 원하면 @뤼콰이얼 어노테이션 쓰셈
	private final JwtTokenProvider jwtTokenProvider;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetailsVO user = new UserDetailsVO();
		List<String> authoList = new ArrayList<String>();
		UserVo dbUser = repository.selectUserById(username);
		authoList.add(dbUser.getRole());
		user.setAuthorities(authoList);
		System.out.println("검사한다~");
		return user;
	}

	public int joinUser(UserVo user) {
		UserVo insertVo = new UserVo();
		insertVo.setUsername(user.getUsername());
		insertVo.setPassword(encoder.encode(user.getPassword()));
		insertVo.setRole("ROLE_USER");
		return repository.joinUser(insertVo);
	}

	public UserVo login(UserVo user) {
		UserVo dbUser = repository.selectUserById(user.getUsername());
		UserVo login = new UserVo();
		List<String> autho = new ArrayList<String>();

		if (!encoder.matches(user.getPassword(), dbUser.getPassword())) {
			//throw new IllegalArgumentException();
			return null;
		} else if (dbUser == null) {
			//throw new IllegalArgumentException();
			return null;
		}
		System.out.println("로그인 성공");
		autho.add(dbUser.getRole());
		
		login.setRole(dbUser.getRole());
		login.setToken(jwtTokenProvider.createToken(dbUser.getUsername(), autho));
		login.setUsername(dbUser.getUsername());
		
		System.out.println(login.toString());
		
		return login;
	}

	public void testauth(String token) {
		System.out.println("권한 체크" + jwtTokenProvider.validateToken(token)); // true
		System.out.println("유저이름 뽑기" + jwtTokenProvider.getUserPk(token)); // gusdnd
		System.out.println("인증 뽑기" + jwtTokenProvider.getAuthentication(token)); // 인증정보 유처객체,
	}

}
