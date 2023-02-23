package com.dao;

import com.entity.PaotuizheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PaotuizheVO;
import com.entity.view.PaotuizheView;


/**
 * 跑腿者
 * 
 * @author 
 * @email 
 * @date 2021-03-30 19:28:31
 */
public interface PaotuizheDao extends BaseMapper<PaotuizheEntity> {
	
	List<PaotuizheVO> selectListVO(@Param("ew") Wrapper<PaotuizheEntity> wrapper);
	
	PaotuizheVO selectVO(@Param("ew") Wrapper<PaotuizheEntity> wrapper);
	
	List<PaotuizheView> selectListView(@Param("ew") Wrapper<PaotuizheEntity> wrapper);

	List<PaotuizheView> selectListView(Pagination page,@Param("ew") Wrapper<PaotuizheEntity> wrapper);
	
	PaotuizheView selectView(@Param("ew") Wrapper<PaotuizheEntity> wrapper);
	
}
