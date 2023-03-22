package payment.payment.payment.dto;

import com.sun.istack.NotNull;
import lombok.*;
import payment.payment.payment.Payment;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PaymentDto {

    @NotNull
    private String imp_uid;
    private String merchant_uid;
    private Integer price;
    private String status;

    public static PaymentDto of(Payment payment){
        return PaymentDto.builder()
                .imp_uid(payment.getImp_uid())
                .merchant_uid(payment.getMerchant_uid())
                .price(payment.getPrice()).build();
    }

    public static List<PaymentDto> of(List<Payment> payments) {
        return payments.stream().map(PaymentDto::of).collect(Collectors.toList());
    }
}
