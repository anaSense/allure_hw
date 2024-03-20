package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebTestStepsLibrary {
    @Step("Open GitHub main page")
    public void openMainPage() {
        open("https://github.com");

    }

    @Step("Search a repository {repo}")
    public void searchRepository(String repo) {
        $(".search-input-container").click();
        $("#query-builder-test").setValue(repo);
        $("#query-builder-test").pressEnter();
    }

    @Step("Choose repository {repo}")
    public void chooseRepository(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Click issue tab")
    public void clickIssueTab() {
        $("#issues-tab").click();
    }

    @Step("Check issue name {name}")
    public void checkIssueName(String name) {
        $(withText(name)).should(Condition.exist);
    }
}
