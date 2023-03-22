package payment.payment.payment;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Payment {
    @Id
    private Integer id;
    @Column
    private String imp_uid;
    @Column
    private String merchant_uid;
    @Column
    private Integer price;
}
