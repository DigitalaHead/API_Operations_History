package ru.netology.MihailMokhov.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.MihailMokhov.OperationHistoryApiApplicationTest;
import ru.netology.MihailMokhov.domain.Currency;
import ru.netology.MihailMokhov.domain.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatementServiceTest extends OperationHistoryApiApplicationTest {
    @Autowired
    private StatementService statementService;

    @Test
    public void saveInStatementServiceTest() {
        int operationId = 2;
        int operationSum = 200;
        Currency operationCurrency = Currency.RUB;
        String operationMerchant = "Watershop";
        int customerId = 3;
        Operation operation = new Operation(operationId, operationSum, operationCurrency, operationMerchant, customerId);
        statementService.setOperation(customerId, operation);
        Operation operationOfService = statementService.getOperation(customerId, 0);

        assertEquals(operationId, operationOfService.getId());
        assertEquals(operationSum, operationOfService.getSum());
        assertEquals(operationMerchant, operationOfService.getMerchant());
        assertEquals(operationCurrency, operationOfService.getCurrency());
        assertEquals(operation, operationOfService);
        assertEquals(customerId, operationOfService.getCustomerId());
    }
}
