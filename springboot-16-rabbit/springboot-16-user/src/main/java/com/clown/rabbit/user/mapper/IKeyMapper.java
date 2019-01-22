package com.clown.rabbit.user.mapper;

import com.clown.rabbit.user.model.AccessKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IKeyMapper extends JpaRepository<AccessKey,String>, JpaSpecificationExecutor<AccessKey> {
}
