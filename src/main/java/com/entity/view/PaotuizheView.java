package com.entity.view;

import com.entity.PaotuizheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 跑腿者
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-30 19:28:31
 */
@TableName("paotuizhe")
public class PaotuizheView  extends PaotuizheEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PaotuizheView(){
	}
 
 	public PaotuizheView(PaotuizheEntity paotuizheEntity){
 	try {
			BeanUtils.copyProperties(this, paotuizheEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
