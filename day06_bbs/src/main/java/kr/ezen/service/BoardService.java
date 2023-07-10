package kr.ezen.service;

import java.util.List;

import kr.ezen.bbs.domain.BoardDTO;

public interface BoardService {
	// 게시글 등록
	void register(BoardDTO dto);
	
	// 게시판 리스트
	public List<BoardDTO> getList();
	// 보통은 이름을 다르게 하는데 같아도 상관은 없음.
}
