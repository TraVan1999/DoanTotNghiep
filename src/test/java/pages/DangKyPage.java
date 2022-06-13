package pages;

import helpers.WebUI;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DangKyPage extends WebUI {

    public DangKyPage(WebDriver driver1){this.driver= driver1;}

    private By TAI_KHOAN_BTN =  By.id("sw_dropdown_3");

    private By DANG_KY_BTN = By.xpath("//div[contains(@class,'user-register')]/a[contains(text(),'Đăng ký')]");

    private By EMAIL_DK_TXT = By.id("email");

    private By PASSWORD_DK_TXT = By.id("password1");

    private By NL_PASSWORD_DK_TXT = By.id("password2");

    private By XN_DANG_KY_BTN = By.xpath("//button[@name='dispatch[profiles.update]']");

    private By DK_SUCCESS_LBL = By.xpath("//h1[@class='ty-mainbox-title']");

    private By DK_MISS_EMAIL = By.xpath("//span[@id='email_error_message']//p");

    private By DK_MISS_PASSWORD = By.xpath("//span[@id='password1_error_message']//p");

    private By DK_MISS_NLPASSWORD = By.xpath("//span[@id='password2_error_message']//p");

    @Step("Đăng ký thành công")
    public DangKyPage dangKythanhcong(String Email, String Password, String NLPassword)
    {
        clickElement(TAI_KHOAN_BTN);
        clickElement(DANG_KY_BTN);
        setText(EMAIL_DK_TXT, Email );
        setText(PASSWORD_DK_TXT, Password);
        setText(NL_PASSWORD_DK_TXT, NLPassword);
        clickElement(XN_DANG_KY_BTN);
        return this;
    }

    public DangKyPage verifylbldangkysucess()
    {
        verifyElementText(DK_SUCCESS_LBL,"Đăng ký thành công");
        return this;
    }

    public DangKyPage verifylblthieuemail()
    {
        verifyElementText(DK_MISS_EMAIL, "Địa chỉ email trong mục Email là không hợp lệ.");
        return this;
    }
    public DangKyPage verifylblthieumatkhau()
    {
        verifyElementText(DK_MISS_PASSWORD, "Vui lòng nhập Mật khẩu.");
        return this;
    }
    public DangKyPage verifylblthieunlmatkhau()
    {
        verifyElementText(DK_MISS_NLPASSWORD, "Vui lòng nhập Xác nhận mật khẩu.");
        return this;
    }
    public DangKyPage verifylblnlmatkhausai()
    {
        verifyElementText(DK_MISS_NLPASSWORD, "Mật khẩu trong các mục Mật khẩu và Xác nhận mật khẩu không khớp.");
        return this;
    }

}
