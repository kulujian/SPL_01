package com.kulu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.kulu.domain.SystemUser;

/* 這邊的介面，實作方式為透過Mybatis實現
 * 
 * ★這邊宣告的抽象方法，記得要添加到resouces對應路徑的.xml裡面
 */

@Mapper // mybatis整合包 動態的將(bean物件)注入Spring容器，但是因為有些IDE工具檢查識別不出來，所以要加上下面的註解
@Repository // 加上這個註解是為了告知IDE工具，已有把對應的物件放到容器裡面
public interface SystemUserMapper {

	SystemUser login(SystemUser user);
}
