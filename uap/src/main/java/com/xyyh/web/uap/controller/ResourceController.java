package com.xyyh.web.uap.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xyyh.web.common.uap.dto.ResourceDto;
import com.xyyh.web.uap.converter.ResourceConverter;
import com.xyyh.web.uap.entity.Resource;
import com.xyyh.web.uap.services.ResourceService;

@RestController
@RequestMapping("resource")
public class ResourceController {
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private ResourceConverter resourceConverter;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public List<ResourceDto> resouces() {
		List<ResourceDto> result = new ArrayList<ResourceDto>();
		List<Resource> resources = resourceService.listAll();
		if (CollectionUtils.isNotEmpty(resources)) {
			for (Resource resource : resources) {
				result.add(resourceConverter.toDto(resource));
			}
		}
		return result;
	}
}