package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class UsersPage extends BasePage<UsersPage> {

  private static final String USERS_PAGE = "//android.view.View[@content-desc=\"Пользователи\nTab 1 of 2\"]";

  public UsersPage open() {
    Selenide.open();
    return this;
  }

  public UsersPage checkUserPage() {
    $(By.xpath(USERS_PAGE)).shouldBe(Condition.visible);
    return this;
  }


  public UsersPage clickUserPage() {
    $(By.xpath(USERS_PAGE)).click();
    return this;
  }

  public void checkUsersOnUserPage() {
    List<SelenideElement> collect = $$(By.xpath("//android.view.View[contains(@content-desc, '@')]"))
        .asDynamicIterable()
        .stream()
        .collect(Collectors.toList());
    System.out.println("Количество элементов на странице: " + collect.size());

    Random rand = new Random();
    SelenideElement randomElement = collect.get(rand.nextInt(collect.size()));
    randomElement.click();
  }
}
