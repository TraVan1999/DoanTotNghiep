package testcases.ThanhToan;

import org.testng.annotations.Test;
import pages.ChiTietSanPhamPage;
import pages.DangNhapPage;
import pages.HomePage;
import pages.ThanhToanPage;
import testcases.BaseTest;
import ultilities.PropertiesFile;

public class GioHang extends BaseTest {
    private HomePage homePage;
    private ChiTietSanPhamPage chiTietSanPhamPage;
    private ThanhToanPage thanhToanPage;

    @Test(description = "add một sản phẩm vào giỏ hàng")
    public void addMotSanPhamVaoGioHang() {
        homePage = new HomePage(driver);
        chiTietSanPhamPage = new ChiTietSanPhamPage(driver);
        thanhToanPage = new ThanhToanPage(driver);
        homePage.timKiemSanPham("Đồ Bộ Cho Bé Trai Tay Ngắn In Hình Sành Điệu Size Đại Cồ (5 - 13 tuổi)")
                .moChitietSanPHamDauTien();
        chiTietSanPhamPage.addProductToCart("1");
        thanhToanPage.verifyThongTinSanPham1TrongGio("Đồ Bộ Cho Bé Trai Tay Ngắn In Hình Sành Điệu Size Đại Cồ (5 - 13 tuổi)", "179.000")
                .verifyThongTinTongHoaDon("1", "179.000");
    }

    @Test(description = "add sản phẩm với số lượng 2 vào giỏ hàng")
    public void add2SanPhamVaoGioHang() {
        homePage = new HomePage(driver);
        chiTietSanPhamPage = new ChiTietSanPhamPage(driver);
        thanhToanPage = new ThanhToanPage(driver);
        homePage.timKiemSanPham("Đồ Bộ Cho Bé Trai Tay Ngắn In Hình Sành Điệu Size Đại Cồ (5 - 13 tuổi)")
                .moChitietSanPHamDauTien();
        chiTietSanPhamPage.addProductToCart("2");
        thanhToanPage.verifyThongTinSanPham1TrongGio("Đồ Bộ Cho Bé Trai Tay Ngắn In Hình Sành Điệu Size Đại Cồ (5 - 13 tuổi)", "179.000")
                .verifyThongTinTongHoaDon("2", "358.000");
    }

    @Test(description = "add hai sản phẩm giống nhau vào giỏ hàng")
    public void addSanPham2LanVaoGioHang() {
        homePage = new HomePage(driver);
        chiTietSanPhamPage = new ChiTietSanPhamPage(driver);
        thanhToanPage = new ThanhToanPage(driver);
        homePage.timKiemSanPham("Đồ Bộ Cho Bé Trai Tay Ngắn In Hình Sành Điệu Size Đại Cồ (5 - 13 tuổi)")
                .moChitietSanPHamDauTien();
        chiTietSanPhamPage.addProductToCart("1");
        homePage.veTrangChu()
                .timKiemSanPham("Đồ Bộ Cho Bé Trai Tay Ngắn In Hình Sành Điệu Size Đại Cồ (5 - 13 tuổi)")
                .moChitietSanPHamDauTien();
        chiTietSanPhamPage.addProductToCart("1");
        thanhToanPage.verifyThongTinSanPham1TrongGio("Đồ Bộ Cho Bé Trai Tay Ngắn In Hình Sành Điệu Size Đại Cồ (5 - 13 tuổi)", "179.000")
                .verifyThongTinTongHoaDon("2", "358.000");
    }

    @Test(description = "add hai sản phẩm khác nhau vào giỏ hàng")
    public void add2SanPhamKhacNhauVaoGioHang() {
        homePage = new HomePage(driver);
        chiTietSanPhamPage = new ChiTietSanPhamPage(driver);
        thanhToanPage = new ThanhToanPage(driver);
        homePage.timKiemSanPham("Đồ Bộ Cho Bé Trai Tay Ngắn In Hình Sành Điệu Size Đại Cồ (5 - 13 tuổi)")
                .moChitietSanPHamDauTien();
        chiTietSanPhamPage.addProductToCart("1");
        homePage.veTrangChu()
                .timKiemSanPham("Quần Jean Dài Cho Bé Gái Ống Loe Sành Điệu Size Đại (6 - 11 tuổi)")
                .moChitietSanPHamDauTien();
        chiTietSanPhamPage.addProductToCart("1");
        thanhToanPage.verifyThongTinSanPham2TrongGio("Đồ Bộ Cho Bé Trai Tay Ngắn In Hình Sành Điệu Size Đại Cồ (5 - 13 tuổi)", "179.000")
                .verifyThongTinSanPham1TrongGio("Quần Jean Dài Cho Bé Gái Ống Loe Sành Điệu Size Đại (6 - 11 tuổi)","189.000")
                .verifyThongTinTongHoaDon("2", "368.000");
    }
    @Test(description = "kiểm tra khi giỏ hàng chưa có hàng")
    public void verifyGioHangChuaCoSP() {
        homePage = new HomePage(driver);
        homePage.KiemTraGioHang();
    }
}
