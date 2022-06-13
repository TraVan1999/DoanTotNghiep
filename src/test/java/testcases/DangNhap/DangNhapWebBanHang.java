package testcases.DangNhap;

import org.testng.annotations.Test;
import pages.DangNhapPage;
import testcases.BaseTest;
import ultilities.PropertiesFile;

public class DangNhapWebBanHang extends BaseTest {

    private DangNhapPage dangNhap;
    @Test
    public void DangNhapThanhCong(){
        dangNhap=new DangNhapPage(driver);;
        dangNhap.dangNhapTrangBanHangVoiTaiKhoanThuong();
    }
    @Test
    public void DangNhapEmailsai(){
        dangNhap=new DangNhapPage(driver);
        dangNhap.dangNhapVoiThongTin("Abc","travan99")
                .verifyMessageTaiKhoanKhongTonTai();
    }

    @Test
    public void DangNhapPasswordsai(){
        dangNhap=new DangNhapPage(driver);
        dangNhap.dangNhapVoiThongTin("travan99hy@gmail.com","travan")
                .verifyMessageTaiKhoanKhongTonTai();
    }
    @Test
    public void DangNhapKhongEmail(){
        dangNhap=new DangNhapPage(driver);
        dangNhap.dangNhapVoiThongTin("","travan")
                .verifylbldangnhapthieuemail();
    }

    @Test
    public void DangNhapKhongPassword(){
        dangNhap=new DangNhapPage(driver);
        dangNhap.dangNhapVoiThongTin("travan99hy@gmail.com","")
                .verifylbldangnhapthieumk();
    }

}
