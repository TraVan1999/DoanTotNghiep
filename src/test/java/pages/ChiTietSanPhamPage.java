package pages;

import helpers.WebUI;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChiTietSanPhamPage extends WebUI {
    public ChiTietSanPhamPage(WebDriver driver){
        this.driver= driver;
    }
    private By SELECT_SOLUONG = By.xpath("//div[contains(@class,'choice-quantity')]//select");
    private By BTN_MUA_NGAY = By.xpath("//div[contains(@class,'add-cart-button')]//button");
    private By LABEL_GIA_SAN_PHAM = By.xpath("(//div[contains(@class,'prices')]//span[contains(@class,'ty-price') and contains(@id,'line')]/span)[1]");

    @Step("thêm sản phẩm vào giỏ hàng với số lượng {0}")
    public ChiTietSanPhamPage addProductToCart(String soLuong)
    {
        selectOptionByText(SELECT_SOLUONG,soLuong);
        clickElement(BTN_MUA_NGAY);
        return this;
    }
}
