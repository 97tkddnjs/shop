package com.example.shop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="item_img")
@Getter @Setter
public class ItemImg extends BaseEntity {

    @Id
    @Column(name="item_img_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String imgName;     // 이미지 파일명

    private String oriImgName; //원본 이미지 파일명

    private String imgUrl;      // 원본 이미지 조회 경로

    private String repimgYn;    // 대표 이미지 첨부

    @ManyToOne(fetch = FetchType.LAZY) // 지연 로딩
    @JoinColumn(name="item_id")
    private Item item;

    public void updateItemImg(String oriImgName, String imgName, String imgUrl){
        this.imgName = imgName;
        this.oriImgName = oriImgName;
        this.imgUrl = imgUrl;
    }

}
