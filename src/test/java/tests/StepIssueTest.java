package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.IssueConstants;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StepIssueTest extends TestBase {

    @Test
    @Feature("Issue in repository")
    @Story("Check Issue")
    @Owner("egorovaa")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Check created Issue")
    void checkIssueWithLambda() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        WebTestStepsLibrary steps = new WebTestStepsLibrary();

        steps.openMainPage();
        steps.searchRepository(IssueConstants.REPOSITORY);
        steps.chooseRepository(IssueConstants.REPOSITORY);
        steps.clickIssueTab();
        steps.checkIssueName(IssueConstants.ISSUE_NAME);
    }
}
