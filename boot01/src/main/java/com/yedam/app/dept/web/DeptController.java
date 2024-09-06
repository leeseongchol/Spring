package com.yedam.app.dept.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;


@Controller
public class DeptController {
	private DeptService deptService;

	@Autowired
	public DeptController(DeptService deptService) {
		this.deptService = deptService;
	}

	// 전체조회
	@GetMapping("deptList")
	public String deptList(Model model) {
		List<DeptVO> list = deptService.deptList();
		// 페이지에 전달
		model.addAttribute("depts", list);
		return "dept/list";
		// classpath:/templates/dept/list.html
	}

	// 단건조회
	@GetMapping("deptInfo")
	public String deptInfo(DeptVO deptVO, Model model) {
		DeptVO findVO = deptService.deptinfo(deptVO);
		model.addAttribute("dept", findVO);

		return "dept/info";
		// classpath:/templates/dept/info.html => 실제경로
	}
	
	// 등록 - 페이지
	@GetMapping("deptInsert")
	public String deptInsertForm() {
		return "dept/insert";
	}

	// 등록 - 처리
	@PostMapping("deptInsert")
	public String deptInsertProcess(DeptVO deptVO) {
		int did = deptService.deptinsert(deptVO);
		String url = null;
		if (did > -1) {
			// 정상적으로 등록된 경우
			url = "redirect:deptInfo?departmentId=" + did;
			// redirect: 가 가능한경우 GetMapping
		} else {
			// 등록되지 않은 경우
			url = "redirect:deptList";

		}
		return url;
	}

	// 수정 - 페이지
	@GetMapping("deptUpdate") // deptUpdate?departmentId=value
	public String deptUpdateForm(DeptVO deptVO, Model model) {
		DeptVO findVO = deptService.deptinfo(deptVO);
		model.addAttribute("dept", findVO);
		return "dept/update";
	}

	// 수정 - 처리 : JSON
	@PostMapping("deptUpdate")
	@ResponseBody // AJAX
	public Map<String, Object> deptUpdateAJAXJSON(@RequestBody DeptVO deptVO) {
		return deptService.deptUpdate(deptVO);
	}

	// 삭제 - 처리 deptDelete?departmentId=value
	@GetMapping("deptDelete") 
	public String deptDelete(Integer departmentId) {
		deptService.deptDelete(departmentId);
		return "redirect:deptList";
	}
}
