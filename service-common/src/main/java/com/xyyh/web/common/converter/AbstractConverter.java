package com.xyyh.web.common.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.xyyh.web.common.dto.Dto;

/**
 * 定义了一个从Model到DTO对象的转换器。
 * 
 * @author LiDong
 *
 * @param <E>
 *            实体对象类型
 * @param <DTO>
 *            数据传输对象类型
 */
public abstract class AbstractConverter<E, DTO extends Dto> {
	/**
	 * 将一个@Entity对象转换一个DTO对象
	 * 
	 * @param model
	 * @return
	 */
	public abstract DTO toDto(E model);

	/**
	 * 将一个DTO对象的值，复制到一个@Entity对象
	 * 
	 * @param dest
	 * @param source
	 */
	public abstract void copyProperties(E dest, DTO source);

	/**
	 * 将一批model转换为dto
	 * 
	 * @param entity
	 * @return
	 */
	public List<DTO> toDto(List<E> entity) {
		if (CollectionUtils.isNotEmpty(entity)) {
			List<DTO> result = new ArrayList<DTO>();
			for (E e : entity) {
				result.add(toDto(e));
			}
			return result;
		} else {
			return null;
		}
	}

}
