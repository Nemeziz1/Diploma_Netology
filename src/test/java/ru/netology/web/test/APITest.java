package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;

import static ru.netology.web.api.API.*;

public class APITest {
    @Test
    void paymentGateApprovedCard() {
        val approvedCard = DataHelper.getAPISuccessCardData();
        val apiResult = APIPaymentGateApprovedCard(approvedCard);
        Assertions.assertTrue(apiResult.contains("APPROVED"));
    }

    @Test
    void paymentGateDeclinedCard() {
        val declinedCard = DataHelper.getAPIFailCardData();
        val apiResult = APICreditGateDeclinedCard(declinedCard);
        Assertions.assertTrue(apiResult.contains("DECLINED"));
    }

    @Test
    void creditGateApprovedCard() {
        val approvedCard = DataHelper.getAPISuccessCardData();
        val apiResult = APICreditGateApprovedCard(approvedCard);
        Assertions.assertTrue(apiResult.contains("APPROVED"));
    }

    @Test
    void creditGateDeclinedCard() {
        val declinedCard = DataHelper.getAPIFailCardData();
        val apiResult = APICreditGateDeclinedCard(declinedCard);
        Assertions.assertTrue(apiResult.contains("DECLINED"));
    }
}
