package Vti.com.rw41.entity;

import Vti.com.rw41.enumurations.ProductStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(generator = "productIdSeq") // sử dụng seq
    @SequenceGenerator( // khai báo seq
            sequenceName = "productIdSeq",// tên của sequence
            name = "productIdSeq", // tên của sequence
            initialValue = 1, // giá trị đầu tiên
            allocationSize = 2) // bước nhảy
    private Integer id;
    @Column(name = "name")
    private String productName;
    private Double price;
    private LocalDateTime createdDate;
    @Enumerated(EnumType.STRING)
    private ProductStatus statust;

}

