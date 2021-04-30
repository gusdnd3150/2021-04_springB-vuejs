package com.vuejs.content.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vuejs.content.config.JwtTokenProvider;
import com.vuejs.content.dao.APIRepository;
import com.vuejs.content.vo.UserDetailsVO;
import com.vuejs.content.vo.UserVo;

import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
@Service
public class APIService implements UserDetailsService {
	
	@Autowired
	private APIRepository repository;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	//private final JwtTokenProvider jwtTokenProvider;      기본생성자 주입을 원하면 @뤼콰이얼 어노테이션 쓰셈
	private JwtTokenProvider jwtTokenProvider;
	
	
	public APIService(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider =jwtTokenProvider;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetailsVO user = new UserDetailsVO();
		System.out.println("유저 파람정보:"+username);
		user.setUsername("user");
		user.setPassword("123");
		List<String> authoList = new ArrayList<String>();
		authoList.add("ROLE_USER");
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
	
	public String login(UserVo user) {
		UserVo dbUser = repository.selectUserById(user.getUsername());
		List<String> autho = new ArrayList<String>();
		System.out.println(dbUser.toString());
		
		if(!encoder.matches(user.getPassword(), dbUser.getPassword())) {
			throw new IllegalArgumentException();
		}else if(dbUser == null){
			throw new IllegalArgumentException();
		}
		autho.add(dbUser.getRole());
		
		return jwtTokenProvider.createToken(dbUser.getUsername(), autho);
	}
	
	public void testauth(String token) {
		System.out.println("권한 체크"+jwtTokenProvider.validateToken(token));  // true
		System.out.println("유저이름 뽑기"+jwtTokenProvider.getUserPk(token));    // gusdnd
		System.out.println("인증 뽑기"+jwtTokenProvider.getAuthentication(token)); // 인증정보 유처객체,
	}

}
