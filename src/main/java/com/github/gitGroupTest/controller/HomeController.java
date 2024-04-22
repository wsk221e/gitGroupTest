package com.github.gitGroupTest.controller;

import com.github.gitGroupTest.domain.Member;
import com.github.gitGroupTest.mapper.MemberMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	@Autowired
	private MemberMapper mapper;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/list")
	public String list(Model model) {
		List<Member> m = mapper.getAll();
		model.addAttribute("member", m);

		return "list";
	}

	@GetMapping("/register")
	public String register(Model model) {
		int m_no = mapper.getMemberNo();
		model.addAttribute("m_no", m_no);

		return "register";
	}

	@PostMapping("/register")
	public String register(Member m) {
		mapper.register(m);
		System.out.println("register: " + m);

		return "redirect:/list";
	}

	@GetMapping("/modify")
	public String modify(int m_no, Model model) {
		Member m = mapper.get(m_no);
		model.addAttribute("member", m);

		return "modify";
	}

	@PostMapping("/modify")
	public String modify(Member m) {
		mapper.modify(m);
		System.out.println("modify: " + m);

		return "redirect:/list";
	}

	@GetMapping("/delete")
	public String delete(int m_no) {
		mapper.delete(m_no);

		System.out.println("delete: m_no=" + m_no);
		return "redirect:/list";
	}

}
