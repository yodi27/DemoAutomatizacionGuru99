package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import pages.HomePage;
import pages.Login;
import pages.NewCustomer;

public class NewCustomerTest {

    //objetos
    static WebDriver driver;
    
    //inicialización de los objetos
    Login objLogin = new Login(driver);
    HomePage objHomePage = new HomePage(driver); 
    NewCustomer objNewCustomer = new NewCustomer(driver); 
    
    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //configura los tiempos implicitos(tiempo de espera para cargar)
    }
    
    @Before
    public void setUp() {
        driver.get("http://demo.guru99.com/V4/");
    }
    
//    @After
//    public void tearDown(){
//        driver.quit();
//    }
//    
    @Test
    public void test_Agregar_Correctamente() {
        
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
        objLogin.login("mgr123", "mgr!23");
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
        objNewCustomer.NewCustomerClass("yoddi", "male", "27/06/1992", "cra69805", "Medellin", "Antioquia", "123456", "123456789", "yoa@gmail.com", "654321");
    }
}
