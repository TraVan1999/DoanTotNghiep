package testcases.TimKiem;

import org.testng.annotations.Test;
import pages.ChiTietSanPhamPage;
import pages.HomePage;
import pages.ThanhToanPage;
import testcases.BaseTest;

public class Timkiem extends BaseTest {

    private HomePage homePage;


    @Test(description = "Tìm kiếm đúng")
    public void Timkiemdung() {
        homePage = new HomePage(driver);
        homePage.timKiemSanPham("Đồ Bộ Cho Bé Trai Tay Ngắn In Hình Sành Điệu Size Đại Cồ (5 - 13 tuổi)")
                .moChitietSanPHamDauTien();

    }

    @Test(description = "Tìm kiếm gần đúng")
    public void Timkiemgandung() {
        homePage = new HomePage(driver);
        homePage.timKiemSanPham("áo bé gái")
                .moChitietSanPHamDauTien();

    }

    @Test(description = "Tìm kiếm có ký tự đặc biệt")
    public void Timkiemkytudacbiet() {
        homePage = new HomePage(driver);
        homePage.timKiemSanPham("!@#$")
                .Searchkytudacbiet();

    }

    @Test(description = "Tìm kiếm")
    public void Timkiem() {
        homePage = new HomePage(driver);
        homePage.timKiemSanPham("")
                .Khongnhapgitimkiem();

    }
}
