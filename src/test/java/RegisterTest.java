import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

//import static org.testng.Assert.assertEquals;

public class RegisterTest {
    WebDriver webDriver;

    By byBtnDangKy = By.cssSelector("button[type='submit']");

    By byTxtHoVaTen = By.xpath("//input[@id='txtFirstname']");
    By byTxtEmail = By.xpath("//input[@id='txtEmail']");
    By byTxtNhapLaiEmail = By.xpath("//input[@id='txtCEmail']");
    By byTxtMatKhau = By.xpath("//input[@id='txtPassword']");
    By byTxtNhapLaiMatKhau = By.xpath("//input[@id='txtCPassword']");
    By byTxtDienThoai = By.xpath("//input[@id='txtPhone']");

    By byLblHoVaTenError = By.cssSelector("#txtFirstname-error");
    By byLblEmailError = By.cssSelector("#txtEmail-error");
    By byLblNhapLaiEmailError = By.cssSelector("#txtCEmail-error");
    By byLblMatKhauError = By.cssSelector("#txtPassword-error");
    By byLblNhapLaiMatKhauError = By.cssSelector("#txtCPassword-error");
    By byLblDienThoaiError = By.cssSelector("#txtPhone-error");

    @BeforeClass
    public void BeforeClass() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @BeforeMethod
    public void BeforeMethod()
    {
        webDriver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }

    @Test
    public void TC_01_RegisterWithEmptyDataTest() {
        WebElement btnDangKy = webDriver.findElement(byBtnDangKy);
        btnDangKy.click();

        WebElement lblHoVaTenError = webDriver.findElement(byLblHoVaTenError);
        Assert.assertEquals(lblHoVaTenError.getText(), "Vui lòng nhập họ tên");

        WebElement lblEmailError = webDriver.findElement(byLblEmailError);
        Assert.assertEquals(lblEmailError.getText(), "Vui lòng nhập email");

        WebElement lblNhapLaiEmailError = webDriver.findElement(byLblNhapLaiEmailError);
        Assert.assertEquals(lblNhapLaiEmailError.getText(), "Vui lòng nhập lại địa chỉ email");

        WebElement lblMatKhauError = webDriver.findElement(byLblMatKhauError);
        Assert.assertEquals(lblMatKhauError.getText(), "Vui lòng nhập mật khẩu");

        WebElement lblNhapLaiMatKhauError = webDriver.findElement(byLblNhapLaiMatKhauError);
        Assert.assertEquals(lblNhapLaiMatKhauError.getText(), "Vui lòng nhập lại mật khẩu");

        WebElement lblDienThoaiError = webDriver.findElement(byLblDienThoaiError);
        Assert.assertEquals(lblDienThoaiError.getText(), "Vui lòng nhập số điện thoại.");
    }

    @Test
    public void TC_02_RegisterWithInvalidEmailTest(){
        WebElement txtHoVaTen = webDriver.findElement(byTxtHoVaTen);
        txtHoVaTen.sendKeys("Phong Pham");

        WebElement txtEmail = webDriver.findElement(byTxtEmail);
        txtEmail.sendKeys("123@456@789");

        WebElement txtNhapLaiEmail = webDriver.findElement(byTxtNhapLaiEmail);
        txtNhapLaiEmail.sendKeys("123@456@789");

        WebElement txtMatKhau = webDriver.findElement(byTxtMatKhau);
        txtMatKhau.sendKeys("12345678");

        WebElement txtNhapLaiMatKhau = webDriver.findElement(byTxtNhapLaiMatKhau);
        txtNhapLaiMatKhau.sendKeys("12345678");

        WebElement txtDienThoai = webDriver.findElement(byTxtDienThoai);
        txtDienThoai.sendKeys("0983111111");

        WebElement btnDangKy = webDriver.findElement(byBtnDangKy);
        btnDangKy.click();

        WebElement lblEmailError = webDriver.findElement(byLblEmailError);
        Assert.assertEquals(lblEmailError.getText(), "Vui lòng nhập email hợp lệ");

        WebElement lblNhapLaiEmailError = webDriver.findElement(byLblNhapLaiEmailError);
        Assert.assertEquals(lblNhapLaiEmailError.getText(), "Email nhập lại không đúng");
    }

    @AfterClass
    public void AfterClass() {
        webDriver.quit();
    }
}
