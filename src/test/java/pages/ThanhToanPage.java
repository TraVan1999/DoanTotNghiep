package pages;

import helpers.WebUI;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThanhToanPage extends WebUI {
    public ThanhToanPage(WebDriver driver){
        this.driver= driver;
    }
    private By LABEL_TEN_SP_1 = By.xpath("(//li[contains(@class,'ty-order-products__item')]/a[1])[1]");
    private By LABEL_TEN_SP_2 = By.xpath("(//li[contains(@class,'ty-order-products__item')]/a[1])[2]");
    private By LABEL_GIA_SANPHAM_1 = By.xpath("(//li[contains(@class,'ty-order-products__item')]/div/span)[1]");
    private By LABEL_GIA_SANPHAM_2 = By.xpath("(//li[contains(@class,'ty-order-products__item')]/div/span)[2]");
    private By LABEL_TONG_SL_SP = By.xpath("//tbody/tr/td[contains(text(),'sản phẩm')]");
    private By LABEL_TONG_GIA_TRI_HANG_HOA = By.xpath("//tbody/tr/td[contains(text(),'sản phẩm')]/following-sibling::td/span/span");
    @Step("so sánh thông tin sản phẩm {0} và giá {1}")
    public ThanhToanPage verifyThongTinSanPham1TrongGio(String tenSanPham, String gia)
    {
        verifyElementText(LABEL_TEN_SP_1,tenSanPham);
        verifyElementText(LABEL_GIA_SANPHAM_1,gia);
        return this;
    }
    @Step("so sánh thông tin sản phẩm {0} và giá {1}")
    public ThanhToanPage verifyThongTinSanPham2TrongGio(String tenSanPham, String gia)
    {
        verifyElementText(LABEL_TEN_SP_2,tenSanPham);
        verifyElementText(LABEL_GIA_SANPHAM_2,gia);
        return this;
    }
    @Step("so sánh thông tin sản phẩm {0} và giá {1}")
    public ThanhToanPage verifyThongTinTongHoaDon(String soLuong, String tongTien)
    {
        verifyElementText(LABEL_TONG_SL_SP,soLuong+" sản phẩm");
        verifyElementText(LABEL_TONG_GIA_TRI_HANG_HOA,tongTien);
        return this;
    }
}
