package kr.ezen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ezen.bbs.domain.BoardDTO;
import kr.ezen.bbs.mapper.BoardMapper;

//Impl은 인터페이스 구현체라는 의미
@Service
public class BoardServiceImpl implements BoardService{

	@Autowired 		//매퍼객체 호출 / 매퍼 주입받기
	private BoardMapper mapper;

	@Override
	public void register(BoardDTO dto) {
		mapper.insert(dto);
		
	}

	@Override
	public List<BoardDTO> getList() {
		return mapper.getList();
	}

}
