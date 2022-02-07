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

    public static OrderItem createOrderItem(Item item, int count){
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setCount(count);
        orderItem.setOrderPrice(item.getPrice());//주문한 아이템, 개수, 아이템의 가격을 저장

        item.removeStock(count); //주문수량만큼 재고수량 감소
        return orderItem;
    }

    public int getTotalPrice(){
        return orderPrice*count; //해당아이템의 가격과 주문수량을 곱하여 전체 가격을 설정
    }

    public void cancel(){
        this.getItem().addStock(count);
    }
}
