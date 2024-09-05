package com.yedam.app.dept.mapper;

import java.util.List;

import com.yedam.app.dept.service.DeptVO;


public interface DeptMapper {

	// 전체조회
	public List<DeptVO> selectDeptAll();
	// 단건조회
	public DeptVO selectEmpInfo(DeptVO deptVO);
	// 등록

	// 수정

	// 삭제
}
