package testcases.DangKy;
import org.testng.annotations.Test;
import pages.DangKyPage;
import pages.HomePage;
import testcases.BaseTest;

public class DangKy extends BaseTest {

    private DangKyPage dangKyPage;

    @Test(description = "Đăng ký thành công")
    public void Dangkythanhcong() {
        dangKyPage = new DangKyPage(driver);
        dangKyPage.dangKythanhcong("j@gmail.com", "travan99", "travan99")
                .verifylbldangkysucess();
    }

    @Test(description = "Đăng ký thiếu email")
    public void Dangkythieuemail() {
        dangKyPage = new DangKyPage(driver);
        dangKyPage.dangKythanhcong("", "travan99", "travan99")
                .verifylblthieuemail();
    }
    @Test(description = "Đăng ký thiếu mật khẩu")
    public void Dangkythieumatkhau() {
        dangKyPage = new DangKyPage(driver);
        dangKyPage.dangKythanhcong("o@gmail.com", "", "travan99")
                .verifylblthieumatkhau();
    }

    @Test(description = "Đăng ký thiếu nhập lại mật khẩu")
    public void Dangkythieunlmatkhau() {
        dangKyPage = new DangKyPage(driver);
        dangKyPage.dangKythanhcong("l@gmail.com", "travan99", "")
                .verifylblthieunlmatkhau();
    }
    @Test(description = "Đăng ký nhập lại mật khẩu không khớp")
    public void Dangkynhaplaimatkhausai() {
        dangKyPage = new DangKyPage(driver);
        dangKyPage.dangKythanhcong("l@gmail.com", "travan99", "travan")
                .verifylblnlmatkhausai();
    }
}
