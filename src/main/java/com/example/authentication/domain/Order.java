package com.example.authentication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tblorder")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Column(name = "STATUS_NAME")
    private String statusName;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "ORDER_SUB_TYPE_ID")
    private Long orderSubTypeId;

    @Column(name = "MSISDN", unique = true)
    private Long msisdn;

    @Column(name = "ORDER_SUB_TYPE_NAME")
    private String orderSubTypeName;

    @Column(name = "ACTION")
    private String action;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_ID")
    private int productId;

    @Column(name = "STATUS_CONTEXT")
    private String statusContext;

    @Column(name = "DISCONNECT_REASON")
    private String disconnectReason;

    @Column(name = "CHANNEL_NAME")
    private String channelName;

    public Order(String statusName, Long orderSubTypeId, Long msisdn, String orderSubTypeName, String action, String productName, int productId, String statusContext, String disconnectReason, String channelName) {
        this.statusName = statusName;
        this.orderSubTypeId = orderSubTypeId;
        this.msisdn = msisdn;
        this.orderSubTypeName = orderSubTypeName;
        this.action = action;
        this.productName = productName;
        this.productId = productId;
        this.statusContext = statusContext;
        this.disconnectReason = disconnectReason;
        this.channelName = channelName;
    }
}
