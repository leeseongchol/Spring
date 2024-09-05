package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest
class Boot01ApplicationTests {

	@Autowired // 필드주입
	private EmpMapper empMapper;

	@Test
	void empList() {
		// 전체조회 : 입력 x -> 출력, 1건이상
		List<EmpVO> list = empMapper.selectEmpAllList();
		assertTrue(!list.isEmpty());

	}

	@Test
	void empInfo() {
		// 단건조회 : 입력, 사원번호(100) -> 출력, 사원이름(king)
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);

		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		assertEquals(findVO.getLastName(), "King");
	}

	// @Test
	void empInsert() throws ParseException {
		// 사원등록 : 입력, 사원이름, 이메일, 업무
		// -> 출력, 1

		EmpVO empVO = new EmpVO();
		empVO.setLastName("Lee");
		empVO.setEmail("hihi@naver.com");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date today = sdf.parse("2024-08-15");
		empVO.setHireDate(today);
		empVO.setJobId("IT_PROG");
		empVO.setSalary(15000.0);

		int result = empMapper.insertEmpInfo(empVO);
		assertEquals(result, 1);

	}

	// @Test
	void empDelete() {
		int result = empMapper.deleteEmpInfo(212);
		assertEquals(result, 1);
	}

	@Test
	void empUpdate() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(207);
		empVO.setLastName("Si");
		empVO.setJobId("AC_MGR");

		int result = empMapper.updateEmpInfo(empVO.getEmployeeId(), empVO);
		assertEquals(result, 1);
	}
}