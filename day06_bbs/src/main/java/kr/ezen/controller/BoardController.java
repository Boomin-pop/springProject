package kr.ezen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ezen.bbs.domain.BoardDTO;
import kr.ezen.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/register.do")
	public String register() {
		
		return "board/register";		
	}
	
	// 여기서는 입력된 값을 보내야 함
	@PostMapping("/register.do")
	public String register(BoardDTO dto) {
		service.register(dto);
		return "redirect:/board/list.do";
	}
	
	// 이제 여기서는 리스트를 가져와야 함
	@RequestMapping("/list.do")
	public String list(Model model) {
		// List속성의 list로 서비스로부터 받아옴.
		List<BoardDTO> list = service.getList();
		
		//리스트 매개변수안에 선언한 Model객체 안에 받아온 리스트를 넣음.
		model.addAttribute("list", list);
		// 넣은 모델을 뷰단에 넘김
		
		return "board/boardList";
	}
	
	
}
