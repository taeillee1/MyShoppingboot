package com.shop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
@Getter
@Setter
public class CartItem extends BaseEntity{

    @Id
    @Column(name = "cart_item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) //하나의 장바구니에는 여러개의 아이템이 담길수있기때문에 다대일로 설정
    @JoinColumn(name="cart_id")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY) //장바구니에 들어가는것도 결국 리스트로 뿌려진 item에 속해있는 것들이기 떄문에 매핑을 해주고 하나의 item은 cart_item_id를 가지고 여러군데에 존재가능하기떄문에 이렇게 설정정
    @JoinColumn(name = "item_id")
    private Item item;

    private int count; //같은 상품을 장바구니에 몇개 담을지 설정하기위한 count
}
