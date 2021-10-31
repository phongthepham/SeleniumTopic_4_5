import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import static org.testng.Assert.assertEquals;

public class RegisterTest {
    WebDriver webDriver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
    }

    @Test
    public void registerWithEmptyDataTest() {
        webDriver.get("https://alada.vn/tai-khoan/dang-ky.html");
        WebElement btnDangKy = webDriver.findElement(By.cssSelector("button[type='submit']"));
        btnDangKy.click();

        WebElement lblHoVaTenError = webDriver.findElement(By.cssSelector("#txtFirstname-error"));
        Assert.assertEquals(lblHoVaTenError.getText(), "Vui lòng nhập họ tên");

        WebElement lblEmailError = webDriver.findElement(By.cssSelector("#txtEmail-error"));
        Assert.assertEquals(lblEmailError.getText(),"Vui lòng nhập email");

        WebElement lblCEmailError = webDriver.findElement(By.cssSelector("#txtCEmail-error"));
        Assert.assertEquals(lblCEmailError.getText(), "Vui lòng nhập lại địa chỉ email");

        WebElement lblMatKhauError = webDriver.findElement(By.cssSelector("#txtPassword-error"));
        Assert.assertEquals(lblMatKhauError.getText(), "Vui lòng nhập mật khẩu");

        WebElement lblNhapLaiMatKhauError = webDriver.findElement(By.cssSelector("#txtCPassword-error"));
        Assert.assertEquals(lblNhapLaiMatKhauError, "Vui lòng nhập lại mật khẩu");

        WebElement lblDienThoaiError = webDriver.findElement(By.cssSelector("txtPhone-error"));
        Assert.assertEquals(lblDienThoaiError.getText(), "Vui lòng nhập số điện thoại.");
    }

    @AfterClass
    public void afterClass() {
        webDriver.quit();
    }
}
