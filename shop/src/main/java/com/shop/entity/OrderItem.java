package com.shop.entity;

import com.shop.constant.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class OrderItem extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)//필요할때만 매핑을 해서 들고오겠다 라는 지연로딩 방식 즉시로딩방식을 사용하면 사용하지않는곳에서도 다가져오기때문에 성능이 나빠질수있다.
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice;

    private int count;

//    private LocalDateTime regTime;
//
//    private LocalDateTime updateTime;
}
