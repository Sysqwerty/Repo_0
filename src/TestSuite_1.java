import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import net.ukr.pages.LoginPage;

public class TestSuite_1 {
	// открываем FireFox браузер
	LoginPage loginPage = new LoginPage(new FirefoxDriver());
	// динамическая информация относительно тестов на странице логина
	String mainPageURL = "https://mail.ukr.net/desktop#msglist/f0/p0";
	String loginData = "stage0";
	String passwordData = "111111";
	String loginDataFalse = "false";
	String passwordDataFalse = "false";
	
	@Before // нужно юзать TestNG
	public void open() {
		loginPage.open();
	}
	
	@After
	public void close() {
		loginPage.close();
	}
	
	// 00001: проверочный тест - ввод логин+пасс+сабмит / проверка = заголовок содержит имя пользователя
	@Test
	public void testLoginCheckTitle() {
	loginPage.login.sendKeys(loginData);
	loginPage.password.sendKeys(passwordData);
	loginPage.submit.click();
	Assert.assertTrue("Test 00001 Error: Title doesn't contains login name", loginPage.getTitle().contains(loginData));
	}
	
	// 00002: ввод некорректных данных / проверка = зало
	@Test
	public void incorrectLoginDataEntered() {
		loginPage.login.sendKeys(loginData);
		loginPage.password.sendKeys(passwordDataFalse);
		loginPage.submit.click();
		Assert.assertFalse("Test 00002 Error: URL check false", loginPage.getTitle()==mainPageURL);
	}
	
}
