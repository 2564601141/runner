package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PaotuizheEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PaotuizheVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PaotuizheView;


/**
 * 跑腿者
 *
 * @author 
 * @email 
 * @date 2021-03-30 19:28:31
 */
public interface PaotuizheService extends IService<PaotuizheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PaotuizheVO> selectListVO(Wrapper<PaotuizheEntity> wrapper);
   	
   	PaotuizheVO selectVO(@Param("ew") Wrapper<PaotuizheEntity> wrapper);
   	
   	List<PaotuizheView> selectListView(Wrapper<PaotuizheEntity> wrapper);
   	
   	PaotuizheView selectView(@Param("ew") Wrapper<PaotuizheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PaotuizheEntity> wrapper);
   	
}

