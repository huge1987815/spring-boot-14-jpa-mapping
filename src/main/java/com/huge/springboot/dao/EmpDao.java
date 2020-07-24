package com.huge.springboot.dao;

import com.huge.springboot.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Desc:
 * @author:huge
 * @create:2020-07-23 23:12
 */
public interface EmpDao extends JpaRepository<Emp,Integer> {
}
