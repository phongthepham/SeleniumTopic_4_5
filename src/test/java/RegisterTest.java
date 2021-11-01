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
    public void BeforeMethod() {
        webDriver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }

    @Test
    public void TC_01_RegisterWithEmptyData() {
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
    public void TC_02_RegisterWithInvalidEmail() {
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

    @Test
    public void TC_03_RegisterWithIncorrectConfirmEmail() {
        WebElement txtHoVaTen = webDriver.findElement(byTxtHoVaTen);
        txtHoVaTen.sendKeys("Phong Pham");

        WebElement txtEmail = webDriver.findElement(byTxtEmail);
        txtEmail.sendKeys("abc@gmail.com");

        WebElement txtNhapLaiEmail = webDriver.findElement(byTxtNhapLaiEmail);
        txtNhapLaiEmail.sendKeys("abc@yahoo.com");

        WebElement txtMatKhau = webDriver.findElement(byTxtMatKhau);
        txtMatKhau.sendKeys("12345678");

        WebElement txtNhapLaiMatKhau = webDriver.findElement(byTxtNhapLaiMatKhau);
        txtNhapLaiMatKhau.sendKeys("12345678");

        WebElement txtDienThoai = webDriver.findElement(byTxtDienThoai);
        txtDienThoai.sendKeys("0983111111");

        WebElement btnDangKy = webDriver.findElement(byBtnDangKy);
        btnDangKy.click();

        WebElement lblNhapLaiEmailError = webDriver.findElement(byLblNhapLaiEmailError);
        Assert.assertEquals(lblNhapLaiEmailError.getText(), "Email nhập lại không đúng");
    }

    @Test
    public void TC_04_RegisterWithPasswordLessThan6Characters() {
        WebElement txtHoVaTen = webDriver.findElement(byTxtHoVaTen);
        txtHoVaTen.sendKeys("Phong Pham");

        WebElement txtEmail = webDriver.findElement(byTxtEmail);
        txtEmail.sendKeys("abc@gmail.com");

        WebElement txtNhapLaiEmail = webDriver.findElement(byTxtNhapLaiEmail);
        txtNhapLaiEmail.sendKeys("abc@gmail.com");

        WebElement txtMatKhau = webDriver.findElement(byTxtMatKhau);
        txtMatKhau.sendKeys("12345");

        WebElement txtNhapLaiMatKhau = webDriver.findElement(byTxtNhapLaiMatKhau);
        txtNhapLaiMatKhau.sendKeys("12345");

        WebElement txtDienThoai = webDriver.findElement(byTxtDienThoai);
        txtDienThoai.sendKeys("0983111111");

        WebElement btnDangKy = webDriver.findElement(byBtnDangKy);
        btnDangKy.click();

        WebElement lblMatKhauError = webDriver.findElement(byLblMatKhauError);
        Assert.assertEquals(lblMatKhauError.getText(), "Mật khẩu phải có ít nhất 6 ký tự");

        WebElement lblNhapLaiMatKhauError = webDriver.findElement(byLblNhapLaiMatKhauError);
        Assert.assertEquals(lblNhapLaiMatKhauError.getText(), "Mật khẩu phải có ít nhất 6 ký tự");
    }

    @Test
    public void TC_05_RegisterWithIncorrectConfirmPassword(){
        WebElement txtHoVaTen = webDriver.findElement(byTxtHoVaTen);
        txtHoVaTen.sendKeys("Phong Pham");

        WebElement txtEmail = webDriver.findElement(byTxtEmail);
        txtEmail.sendKeys("abc@gmail.com");

        WebElement txtNhapLaiEmail = webDriver.findElement(byTxtNhapLaiEmail);
        txtNhapLaiEmail.sendKeys("abc@gmail.com");

        WebElement txtMatKhau = webDriver.findElement(byTxtMatKhau);
        txtMatKhau.sendKeys("1234567");

        WebElement txtNhapLaiMatKhau = webDriver.findElement(byTxtNhapLaiMatKhau);
        txtNhapLaiMatKhau.sendKeys("12345678");

        WebElement txtDienThoai = webDriver.findElement(byTxtDienThoai);
        txtDienThoai.sendKeys("0983111111");

        WebElement btnDangKy = webDriver.findElement(byBtnDangKy);
        btnDangKy.click();

        WebElement lblNhapLaiMatKhauError = webDriver.findElement(byLblNhapLaiMatKhauError);
        Assert.assertEquals(lblNhapLaiMatKhauError.getText(), "Mật khẩu bạn nhập không khớp");
    }

    @Test
    public void TC_06_RegisterWithInvalidPhoneNumber(){
        WebElement txtHoVaTen = webDriver.findElement(byTxtHoVaTen);
        txtHoVaTen.sendKeys("Phong Pham");

        WebElement txtEmail = webDriver.findElement(byTxtEmail);
        txtEmail.sendKeys("abc@gmail.com");

        WebElement txtNhapLaiEmail = webDriver.findElement(byTxtNhapLaiEmail);
        txtNhapLaiEmail.sendKeys("abc@gmail.com");

        WebElement txtMatKhau = webDriver.findElement(byTxtMatKhau);
        txtMatKhau.sendKeys("12345678");

        WebElement txtNhapLaiMatKhau = webDriver.findElement(byTxtNhapLaiMatKhau);
        txtNhapLaiMatKhau.sendKeys("12345678");

        WebElement txtDienThoai = webDriver.findElement(byTxtDienThoai);
        txtDienThoai.sendKeys("098123456");

        WebElement btnDangKy = webDriver.findElement(byBtnDangKy);
        btnDangKy.click();

        WebElement lblDienThoaiError = webDriver.findElement(byLblDienThoaiError);
        Assert.assertEquals(lblDienThoaiError.getText(), "Số điện thoại phải từ 10-11 số.");

        txtDienThoai = webDriver.findElement(byTxtDienThoai);
        txtDienThoai.clear();
        txtDienThoai.sendKeys("1234567890");

        btnDangKy = webDriver.findElement(byBtnDangKy);
        btnDangKy.click();

        lblDienThoaiError = webDriver.findElement(byLblDienThoaiError);
        Assert.assertEquals(lblDienThoaiError.getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019");
    }

    @AfterClass
    public void AfterClass() {
        webDriver.quit();
    }
}
