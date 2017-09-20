package com.xyyh.web.common.uap.dto;

import java.util.List;

import com.xyyh.web.common.dto.Dto;

import lombok.Data;

/**
 * 资源数据传输对象
 * 
 * @author LiDong
 *
 */
@Data
public class ResourceDto implements Dto {

	private static final long serialVersionUID = 6859447335992834215L;
	private Long id;
	private String url;
	private String method;

	private List<RoleDto> roles;

}
