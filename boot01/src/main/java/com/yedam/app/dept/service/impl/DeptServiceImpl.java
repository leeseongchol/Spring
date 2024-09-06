package com.yedam.app.dept.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;
@Service
public class DeptServiceImpl implements DeptService {
	private DeptMapper deptMapper;
	
	DeptServiceImpl(DeptMapper deptMapper){
		this.deptMapper = deptMapper;
	}
	
	@Override
	public List<DeptVO> deptList() {
		return deptMapper.selectDeptAll();
	}

	@Override
	public DeptVO deptinfo(DeptVO deptVO) {
		// TODO Auto-generated method stub
		return deptMapper.selectDeptInfo(deptVO);
	}

	@Override
	public int deptinsert(DeptVO deptVO) {
		int result = deptMapper.insertDeptInfo(deptVO);
		return result ==1 ? deptVO.getDepartmentId() : -1;
	}

	@Override
	public Map<String, Object> deptUpdate(DeptVO deptVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		
		int result
		= deptMapper.updateDeptInfo(deptVO.getDepartmentId(), deptVO);
		
		if(result ==1) {
			isSuccessed = true;
		}
		map.put("result", isSuccessed);
		map.put("target", deptVO);
		
		return map;
	}

	@Override
	public Map<String, Object> deptDelete(int deptId) {
		Map<String, Object> map = new HashMap<>();
		//삭제가 안될 경우 : {}
		//삭제가 될 경우 : {"employeeId", 104}
		
		int result = deptMapper.deleteDeptInfo(deptId);
		
		if(result ==1) {
			map.put("departmentId", deptId);
		}
		
		return map;
	}

}
