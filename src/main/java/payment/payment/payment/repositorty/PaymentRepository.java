package payment.payment.payment.repositorty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import payment.payment.payment.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {

}
