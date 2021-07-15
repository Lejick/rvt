import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Counter {
    public static void main(String[] args) {
        List<Transaction> outcomingTransferMoneyTransactions = List.of(new Transaction(UUID.randomUUID(), BigDecimal.ONE),
                new Transaction(UUID.randomUUID(), BigDecimal.TEN));
        BigDecimal totalPayments =
                outcomingTransferMoneyTransactions.stream()
                        .map(Transaction::getPayment)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(totalPayments);
    }
}

@Getter
@AllArgsConstructor
class Transaction {
    UUID id;
    BigDecimal payment;
}

