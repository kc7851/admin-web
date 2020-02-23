package com.skc.adminweb.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer price;

    private String contents;

    // Lazy = SELECT * FROM item where id = ? 따로 메소드를 호출하지 않은 이상 연관관계가 설정된 테이블에 대해서 select를 하지 않는다.
    // 연관관계가 있는 경우 Lazy 사용
    // EAGER = 연관관계가 있는 모든 테이블에 대해서 join이 일어난다. 데이터가 많이 걸려있으면 모든 데이터를 가져와서 성능의 저하가 있을 수 있다.
    // 연관관계가 1:1인 경우 EAGER 사용

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;
}
