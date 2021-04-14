package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.UserVO;


public interface LottoMapper {
	
	public List<UserVO> getList(UserVO vo);
	
	public void insertLotto(UserVO vo);
	
}