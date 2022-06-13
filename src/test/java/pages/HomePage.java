package pages;

import helpers.WebUI;
import org.openqa.selenium.By;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ultilities.PropertiesFile;

import java.util.Properties;

public class HomePage extends WebUI {


    public HomePage(WebDriver driver1){
        this.driver= driver1;
    }

    private By TRANG_CHU_BTN = By.xpath("//div[@class='ty-logo-container']//img");

    private By SEARCH_TXT =  By.id("search_input");

    private By GIO_HANG_BTN = By.xpath("//div[contains(@class,'babi-cart')]");
    private By BTN_SAN_PHAM_DAU_TIEN = By.xpath("(//form[contains(@name,'product_form')]/div[1])[1]");
    private By LABEL_THONG_BAO_GIO_HANG_NULL= By.xpath("//div[@class='ty-cart-items']/div");
    private By SEARCH_KTDB = By.xpath("//p[@class='ty-no-items']");
    private By LBL_KO_SEARCH = By.id("products_search_total_found_11");

    //các hành động ta thao tác trene trang web
    @Step("tìm kiếm thông tin sản phẩm: {0}")
    public HomePage timKiemSanPham(String tenSanPham)
    {
        setTextThenEnter(SEARCH_TXT,tenSanPham);
        return this;
    }
    @Step("mở chi tiết sản phẩm đầu tiên")
    public HomePage moChitietSanPHamDauTien( )
    {
        clickElement(BTN_SAN_PHAM_DAU_TIEN);
        return this;
    }
    @Step("Về trang chủ")
    public HomePage veTrangChu( )
    {
        clickElement(TRANG_CHU_BTN);
        return this;
    }
    public HomePage KiemTraGioHang()
    {
        clickElement(GIO_HANG_BTN);
        verifyElementText(LABEL_THONG_BAO_GIO_HANG_NULL,"Bạn chưa thêm sản phẩm vào Giỏ");
        return this;
    }
    public HomePage Searchkytudacbiet( )
    {
        clickElement(SEARCH_KTDB);
        return this;
    }
    public HomePage Khongnhapgitimkiem( )
    {
        clickElement(LBL_KO_SEARCH);
        return this;
    }
}
