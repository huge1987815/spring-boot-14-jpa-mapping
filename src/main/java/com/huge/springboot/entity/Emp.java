package com.huge.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Desc:
 * @author:huge
 * @create:2020-07-22 7:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_emp")
public class Emp implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eid")
    private Integer eid;
    @Column(name = "ename")
    private String ename;
    @Column(name = "sex")
    private String sex;
    @Column(name = "age")
    private Integer age;
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "did")
    private Dept dept;

}
