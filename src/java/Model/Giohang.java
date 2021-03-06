package Model;
 
import java.io.Serializable;
import java.util.ArrayList;

public class Giohang  implements Serializable{
 
    private ArrayList<Monhang> giohang;
 
    public Giohang() {
        giohang = new ArrayList<Monhang>();
    }
 
    /**
     * Thêm một món hàng vào giỏ
     * @param mh món hàng cần thêm
     */
    public void ThemMonHang(Monhang mh) {
        //nếu có món này trong giỏ thì cập nhật lại số lượng
        if (giohang.contains(mh)) {
            Monhang m = giohang.get(giohang.indexOf(mh));
            m.setSoluong(m.getSoluong() + mh.getSoluong());
        } else//nếu chưa có món này trong giỏ thì thêm mới
            giohang.add(mh);
    }
 
    /**
     * Trả món hàng khỏi giỏ
     * @param mh là món hàng muốn trả
     */
    public void XoaMonhang(Monhang mh) {
        if (giohang.contains(mh)) {
            giohang.remove(mh);
        }
    }
 
    /**
     * Lấy giỏ hàng
     * @return
     */
    public ArrayList<Monhang> getGiohang() {
        return giohang;
    }
    /**
     * TÍnh tổng tiền của giò hàng
     * @return số tiền phải trả của giỏ hàng
     */
    public double Tongtien(){
        double tt=0d;
        for(Monhang mh:giohang){
            tt+=mh.getSanpham().getDongia()*mh.getSoluong();
        }
        return tt;
    }
}