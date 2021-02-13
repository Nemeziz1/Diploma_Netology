package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import static ru.netology.web.api.API.APIPaymentGateApprovedCard;

public class APITest {
    @Test
    void paymentGateApprovedCard() {
        val approvedCard = DataHelper.getSuccessPayData();
        val apiResult = APIPaymentGateApprovedCard(approvedCard);
        Assertions.assertTrue(apiResult.contains("APPROVED"));
    }
}
