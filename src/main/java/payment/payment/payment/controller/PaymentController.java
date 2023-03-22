package payment.payment.payment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import payment.payment.payment.dto.PaymentDto;
import payment.payment.payment.service.PaymentService;

@Controller
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/payments")
    public ResponseEntity<PaymentDto> paymentPrepare(PaymentDto paymentDto) throws Exception{
        return ResponseEntity.ok(PaymentDto.of(paymentService.executePayment(paymentDto)));
    }
}
