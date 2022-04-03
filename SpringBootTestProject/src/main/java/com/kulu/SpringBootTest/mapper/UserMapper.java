package com.kulu.SpringBootTest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.kulu.SpringBootTest.domain.User;

@Mapper // mybatis整合包 動態的將(bean物件)注入Spring容器，但是因為有些IDE工具檢查識別不出來，所以要加上下面的註解
@Repository // 加上這個註解是為了告知IDE工具，已有把對應的物件放到容器裡面
public interface UserMapper {

	public  List<User> findAll();
}
