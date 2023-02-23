package com.entity.view;

import com.entity.YiwanchengdingdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 已完成订单
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-30 19:28:31
 */
@TableName("yiwanchengdingdan")
public class YiwanchengdingdanView  extends YiwanchengdingdanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YiwanchengdingdanView(){
	}
 
 	public YiwanchengdingdanView(YiwanchengdingdanEntity yiwanchengdingdanEntity){
 	try {
			BeanUtils.copyProperties(this, yiwanchengdingdanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
