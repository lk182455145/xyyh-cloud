package com.xyyh.cloud.auth.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xyyh.cloud.auth.server.entity.ClientDetailsEntity;

public interface ClientDetailsRepository extends JpaRepository<ClientDetailsEntity, String> {

}
