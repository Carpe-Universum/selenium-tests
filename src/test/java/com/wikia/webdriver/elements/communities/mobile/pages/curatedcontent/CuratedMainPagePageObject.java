package com.wikia.webdriver.elements.communities.mobile.pages.curatedcontent;

import com.wikia.webdriver.common.logging.Log;
import com.wikia.webdriver.pageobjectsfactory.pageobject.BasePageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class CuratedMainPagePageObject extends BasePageObject {

  @FindBy(css = ".main-page-edit")
  private WebElement editMainPageButton;

  public float getElementOffsetTop(String element) {
    return Float.parseFloat(driver.executeScript(
        "var el = document.querySelector(arguments[0]), boundingClientRect = el.getBoundingClientRect(); return boundingClientRect && boundingClientRect.top + document.body.scrollTop;",
        element
    ).toString());
  }

  public boolean isCuratedElementVisible(String element) {
    try {
      wait.forElementVisible(By.cssSelector(element));
    } catch (TimeoutException | ElementNotVisibleException ex) {
      Log.log("Web element " + element + " not visible", ex, true);
      return false;
    }
    return true;
  }

  public EditorHomePageObject editCuratedMainPage() {
    editMainPageButton.click();
    return new EditorHomePageObject();
  }
}