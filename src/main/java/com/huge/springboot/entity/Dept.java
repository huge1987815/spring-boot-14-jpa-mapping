package com.huge.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Desc:
 * @author:huge
 * @create:2020-07-23 22:51
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_dept")
public class Dept implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "did")
    private Integer did;
    @Column(name = "dname")
    private String dname;
    @OneToMany(mappedBy = "dept",fetch = FetchType.EAGER)
    private Set<Emp> empSet=new HashSet<>();
}
