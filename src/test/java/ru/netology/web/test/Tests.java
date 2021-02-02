package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.*;
import ru.netology.web.data.DataHelper;
import ru.netology.web.data.SQL;
import ru.netology.web.page.StartPage;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Tests {
    @BeforeAll
    static void setUpAll() throws SQLException {
        SQL.dropTables();
    }

    @BeforeEach
    void setUp() {
        open("http://localhost:8080");
    }

    @Test
    @Order(1)
    void shouldSuccessPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getSuccessPayData();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.successMessage();
        assertEquals("APPROVED", SQL.getCardStatus(SQL.getPayTable()));
    }

    @Test
    @Order(2)
    void shouldFailPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getFailurePayData();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.failureMessage();
    }

    @Test
    @Order(3)
    void shouldSuccessCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getSuccessPayData();
        creditGatePage.cardData(payInfo);
        creditGatePage.successMessage();
    }

    @Test
    @Order(4)
    void shouldFailCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getFailurePayData();
        creditGatePage.cardData(payInfo);
        creditGatePage.failureMessage();
    }

    @Test
    @Order(5)
    void shouldFailMonthMore12SuccessCardPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getInvalidMonthMore12SuccessCard();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.failureMonthOrYear();
    }

    @Test
    @Order(6)
    void shouldFailMonthMore12FailureCardPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getInvalidMonthMore12FailureCard();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.failureMonthOrYear();
    }

    @Test
    @Order(7)
    void shouldFailMonthMore12SuccessCardCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getInvalidMonthMore12SuccessCard();
        creditGatePage.cardData(payInfo);
        creditGatePage.failureMonthOrYear();
    }

    @Test
    @Order(8)
    void shouldFailMonthMore12FailureCardCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getInvalidMonthMore12FailureCard();
        creditGatePage.cardData(payInfo);
        creditGatePage.failureMonthOrYear();
    }

    @Test
    @Order(9)
    void shouldFailMonthLess01SuccessCardPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getInvalidMonthLess01SuccessCard();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.failureMonthOrYear();
    }

    @Test
    @Order(10)
    void shouldFailMonthLess01FailCardPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getInvalidMonthLess01FailureCard();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.failureMonthOrYear();
    }

    @Test
    @Order(11)
    void shouldFailMonthLess01SuccessCardCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getInvalidMonthLess01SuccessCard();
        creditGatePage.cardData(payInfo);
        creditGatePage.failureMonthOrYear();
    }

    @Test
    @Order(12)
    void shouldFailMonthLess01FailureCardCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getInvalidMonthLess01FailureCard();
        creditGatePage.cardData(payInfo);
        creditGatePage.failureMonthOrYear();
    }

    @Test
    @Order(13)
    void shouldFailYearMoreSuccessCardPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getInvalidYearMoreSuccessCard();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.failureMonthOrYear();
    }

    @Test
    @Order(14)
    void shouldFailYearMoreFailureCardPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getInvalidYearMoreFailureCard();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.failureMonthOrYear();
    }

    @Test
    @Order(15)
    void shouldFailYearMoreSuccessCardCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getInvalidYearMoreSuccessCard();
        creditGatePage.cardData(payInfo);
        creditGatePage.failureMonthOrYear();
    }

    @Test
    @Order(16)
    void shouldFailYearMoreFailureCardCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getInvalidYearMoreFailureCard();
        creditGatePage.cardData(payInfo);
        creditGatePage.failureMonthOrYear();
    }

    @Test
    @Order(17)
    void shouldFailYearLessSuccessCardPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getInvalidYearLessSuccessCard();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.failureYearLessNow();
    }

    @Test
    @Order(18)
    void shouldFailYearLessFailureCardPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getInvalidYearLessFailureCard();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.failureYearLessNow();
    }

    @Test
    @Order(19)
    void shouldFailYearLessSuccessCardCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getInvalidYearLessSuccessCard();
        creditGatePage.cardData(payInfo);
        creditGatePage.failureYearLessNow();
    }

    @Test
    @Order(20)
    void shouldFailYearLessFailureCardCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getInvalidYearLessFailureCard();
        creditGatePage.cardData(payInfo);
        creditGatePage.failureYearLessNow();
    }

    @Test
    @Order(21)
    void shouldFailUserSuccessCardPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getInvalidUserSuccessCard();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.failureUser();
    }

    @Test
    @Order(22)
    void shouldFailUserFailureCardPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getInvalidUserFailureCard();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.failureUser();
    }

    @Test
    @Order(23)
    void shouldFailUserSuccessCardCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getInvalidUserSuccessCard();
        creditGatePage.cardData(payInfo);
        creditGatePage.failureUser();
    }

    @Test
    @Order(24)
    void shouldFailUserFailureCardCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getInvalidUserFailureCard();
        creditGatePage.cardData(payInfo);
        creditGatePage.failureUser();
    }

    @Test
    @Order(25)
    void shouldFailCVVSuccessCardPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getInvalidCVVSuccessCard();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.failureCVV();
    }

    @Test
    @Order(26)
    void shouldFailCVVFailureCardPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        val payInfo = DataHelper.getInvalidCVVFailureCard();
        paymentGatePage.cardData(payInfo);
        paymentGatePage.failureCVV();
    }

    @Test
    @Order(27)
    void shouldFailCVVSuccessCardCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getInvalidCVVSuccessCard();
        creditGatePage.cardData(payInfo);
        creditGatePage.failureCVV();
    }

    @Test
    @Order(28)
    void shouldFailCVVFailureCardCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        val payInfo = DataHelper.getInvalidCVVFailureCard();
        creditGatePage.cardData(payInfo);
        creditGatePage.failureCVV();
    }

    @Test
    @Order(29)
    void shouldFailEmptyFieldsPaymentGate() {
        val startPage = new StartPage();
        val paymentGatePage = startPage.paymentGate();
        paymentGatePage.emptyFields();
        paymentGatePage.failureEmptyFields();
    }

    @Test
    @Order(30)
    void shouldFailEmptyFieldsCreditGate() {
        val startPage = new StartPage();
        val creditGatePage = startPage.creditGate();
        creditGatePage.emptyFields();
        creditGatePage.failureEmptyFields();
    }
}
