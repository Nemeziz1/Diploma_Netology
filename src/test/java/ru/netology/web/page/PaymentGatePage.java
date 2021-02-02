package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentGatePage {
    private SelenideElement heading = $(byText("Оплата по карте"));
    private SelenideElement cardNumberField = $("input[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthField = $("input[placeholder='08']");
    private SelenideElement yearField = $("input[placeholder='22']");
    private ElementsCollection userField = $$(".input__control");
    private SelenideElement cardUser = userField.get(3);
    private SelenideElement cvvField = $("[placeholder='999']");
    private SelenideElement continueButton = $(byText("Продолжить"));
    private SelenideElement success = $(byText("Операция одобрена Банком."));
    private SelenideElement failure = $(byText("Ошибка! Банк отказал в проведении операции."));
    private SelenideElement invalidDates = $(byText("Неверно указан срок действия карты"));
    private SelenideElement invalidDatesLessNow = $(byText("Истёк срок действия карты"));
    private SelenideElement invalidUser = $(byText("Владелец на найден"));
    private SelenideElement invalidCVV = $(byText("Неверный формат"));
    private SelenideElement requiredField = $(byText("Поле обязательно для заполнения"));

    public PaymentGatePage() {
        heading.shouldBe(Condition.visible);
    }

    public void cardData(DataHelper.PayInfo info) {
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getCardFinalMonth());
        yearField.setValue(info.getCardFinalYear());
        cardUser.setValue(info.getUser());
        cvvField.setValue(info.getCvvCode());
        continueButton.click();
    }

    public void successMessage() {
        success.waitUntil(Condition.visible, 100000);
    }

    public void failureMessage() {
        failure.waitUntil(Condition.visible, 10000);
    }

    public void failureMonthOrYear() {
        invalidDates.shouldBe(Condition.visible);
    }

    public void failureYearLessNow() {
        invalidDatesLessNow.shouldBe(Condition.visible);
    }

    public void failureUser() {
        invalidUser.shouldBe(Condition.visible);
    }

    public void failureCVV() {
        invalidCVV.shouldBe(Condition.visible);
    }

    public void emptyFields() {
        continueButton.click();
    }

    public void failureEmptyFields() {
        invalidCVV.shouldBe(Condition.visible);
        requiredField.shouldBe(Condition.visible);
    }
}
