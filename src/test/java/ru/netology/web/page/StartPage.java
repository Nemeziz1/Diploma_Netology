package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.ExactText;
import ru.netology.web.data.DataHelper;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StartPage {
    private SelenideElement heading = $(byText("Путешествие дня"));
    private SelenideElement paymentGateButton = $(byText("Купить"));
    private SelenideElement creditGateButton = $(byText("Купить в кредит"));

    public StartPage() { heading.shouldBe(Condition.visible); }

    public PaymentGatePage paymentGate() {
        paymentGateButton.click();
        return new PaymentGatePage();
    }

    public CreditGatePage creditGate() {
        creditGateButton.click();
        return new CreditGatePage();
    }
}