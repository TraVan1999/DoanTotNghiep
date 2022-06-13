package pages;

import helpers.WebUI;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ultilities.PropertiesFile;

public class DangNhapPage extends WebUI {
    
    public DangNhapPage(WebDriver driver1){this.driver= driver1;}

    private By TAI_KHOAN_BTN =  By.id("sw_dropdown_3");
    
    private By DANG_NHAP_BTN = By.xpath("//div[contains(@class,'user-register')]/a[contains(text(),'Đăng nhập')]");

    private By EMAIL_DN_TXT =  By.id("login_popup3");

    private By PASSWORD_DN_TXT =  By.id("psw_popup3");

    private By XN_DANG_NHAP_BTN =  By.xpath("//button[contains(@class,'ty-btn__login ty-btn__secondary ty-btn')]");

    private By LABEL_TB_TK_KHONG_HOP_LE= By.id("login_popup3_error_message");

    private By LABEL_MISS_EMAIL= By.id("//span[@id='login_popup3_error_message']//p");

    private By LABEL_MISS_PASSWORD=By.id("//span[@id='psw_popup3_error_message']//p");

    @Step("Đăng nhập thành công")
    public DangNhapPage dangNhapTrangBanHangVoiTaiKhoanThuong( )
    {
        clickElement(TAI_KHOAN_BTN);
        clickElement(DANG_NHAP_BTN);
        setText(EMAIL_DN_TXT, PropertiesFile.getPropValue("email"));
        setText(PASSWORD_DN_TXT,PropertiesFile.getPropValue("password"));
        clickElement(XN_DANG_NHAP_BTN);
        return this;
    }
    @Step("Đăng nhập với tài khoản {0} và mật khẩu {1}")
    public DangNhapPage dangNhapVoiThongTin(String taiKhoan, String matKhau)
    {
        clickElement(TAI_KHOAN_BTN);
        clickElement(DANG_NHAP_BTN);
        setText(EMAIL_DN_TXT, taiKhoan);
        setText(PASSWORD_DN_TXT,matKhau);
        clickElement(XN_DANG_NHAP_BTN);
        return this;
    }
    public DangNhapPage verifyMessageTaiKhoanKhongTonTai()
    {
        verifyElementText(LABEL_TB_TK_KHONG_HOP_LE,"Địa chỉ email trong mục Email là không hợp lệ.");//Địa chỉ email trong mục Email là không hợp lệ.
        return this;
    }

    public DangNhapPage verifylbldangnhapthieuemail()
    {
        verifyElementText(LABEL_MISS_EMAIL,"Địa chỉ email trong mục Email là không hợp lệ.");
        return this;
    }

    public DangNhapPage verifylbldangnhapthieumk()
    {
        verifyElementText(LABEL_MISS_PASSWORD,"Vui lòng nhập Mật khẩu.");
        return this;
    }
}
