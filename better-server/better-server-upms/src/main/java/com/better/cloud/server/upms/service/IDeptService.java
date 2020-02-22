package com.better.cloud.server.upms.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.upms.Dept;

import java.util.List;
import java.util.Map;

public interface IDeptService extends IService<Dept> {

    Map<String, Object> findDepts(QueryRequest request, Dept dept);

    List<Dept> findDepts(Dept dept, QueryRequest request);

    void createDept(Dept dept);

    void updateDept(Dept dept);

    void deleteDepts(String[] deptIds);
}
