package Controller;
 
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Model.Giohang;
import Model.Monhang;
import Model.Sanpham;
import Model.ShopDB;
 
public class ControllerServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);
            ShopDB db = new ShopDB();
            Giohang giohang = null;
            Object obj = session.getAttribute("giohang");
            if (obj != null) {
                giohang = (Giohang) obj;
            }
            String action = request.getParameter("action");
 
            if (action.equals("muahang")) {
                String msSP = request.getParameter("monhang");//lấy ms sản phẩm được chọn
                int soluong = Integer.parseInt(request.getParameter("soluong"));
                Sanpham sp = db.getSanPham(msSP);//Lấy sản phẩm từ cơ sở dữ liệu
                Monhang mh = new Monhang(sp, soluong);
                if (giohang == null) {//mua lần đầu
                    giohang = new Giohang();
                }
                giohang.ThemMonHang(mh);
            } else if (action.equals("trahang")) {
                String msSP = request.getParameter("mssp");//lấy ms sản phẩm cần xóa
                Monhang mh=new Monhang(new Sanpham(msSP, "", 0f), 0);
                giohang.XoaMonhang(mh);
            } else if (action.equals("checkout")) {
                response.sendRedirect("Checkout.jsp");
            }
 
            session.setAttribute("giohang", giohang);
 
            //chuyển lại trang mua hàng
            response.sendRedirect("Home.jsp");
        } catch (Exception e) {
            response.getWriter().print(e.getMessage());
        }
    }
}