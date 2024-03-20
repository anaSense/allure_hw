package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.IssueConstants;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaIssueTest extends TestBase {

    @Test
    @Feature("Issue in repository")
    @Story("Check Issue")
    @Owner("egorovaa")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Check created Issue")
    void checkIssueWithLambda() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open GitHub main page", () -> {
            open("https://github.com");
        });
        step("Search a repository " + IssueConstants.REPOSITORY, () -> {
            $(".search-input-container").click();
            $("#query-builder-test").setValue(IssueConstants.REPOSITORY);
            $("#query-builder-test").pressEnter();
        });
        step("Choose repository " + IssueConstants.REPOSITORY, () -> {
            $(linkText(IssueConstants.REPOSITORY)).click();
        });
        step("Click issue tab", () -> {
            $("#issues-tab").click();
        });
        step("Check issue name " + IssueConstants.ISSUE_NAME, () -> {
            $(withText(IssueConstants.ISSUE_NAME)).should(Condition.exist);
        });
    }
}
