package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.IssueConstants;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class SelenideIssueTest extends TestBase {

    @Test
    @Feature("Issue in repository")
    @Story("Check Issue")
    @Owner("egorovaa")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Check created Issue")
    void checkIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".search-input-container").click();
        $("#query-builder-test").setValue(IssueConstants.REPOSITORY);
        $("#query-builder-test").pressEnter();

        $(linkText(IssueConstants.REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText(IssueConstants.ISSUE_NAME)).should(Condition.exist);
    }
}
