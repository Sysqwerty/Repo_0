package net.ukr.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	final String URL = "https://mail.ukr.net/classic/login";
	
	@FindBy(id="login")		// �����
	public WebElement login;
	@FindBy(id="password")	// ������
	public WebElement password;
	@FindBy(xpath="//button[@type='submit']")	// ������ "�����"
	public WebElement submit;
	
	public LoginPage(WebDriver driver) {		// ����������� ������ (@param = driver)
		PageFactory.initElements(driver, this);	// ������������� ��������� ��������, ��������� � ������� ��������� PageFactory
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public void open() {	// ������� �������� (� ����� ���� ��������)
		driver.get(URL);
	}

	public void close() {	// ������� �������� (���� ����, �� �������)
		driver.close();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
}
