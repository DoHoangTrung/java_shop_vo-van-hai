package customTag;

import Model.Monhang;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.ShopDB;
import Model.Sanpham;

public class ShowMenuTagHandler extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try {
            ShopDB db = new ShopDB();
            ArrayList<Sanpham> dssp = db.getAllProducts();
            
//            out.println("<form id=\"formMua\" action=\"ControllerServlet\">");
//            out.println("Hãy chọn món hàng cần mua:");
//            out.println("<select name=\"monhang\">");
//            
//            for (Sanpham sp : dssp) {
//                out.println("<option value=\"" + sp.getMsSP() + "\">" + sp.getTenSP() + "</option>");
//            }
//
//            out.println("</select>");
//            out.println("Số lượng<input name=\"soluong\" value=\"0\" id=\"sl\"/>");
//            out.println("<input type=\"hidden\" name=\"action\" value=\"muahang\"/>");
//            out.println("<input type=\"submit\" value=\"Mua hàng\" onclick=\"return kt()\" />");
//            out.println("</form>");

            out.println("<br/>");

            out.println("<table align=\"center\" border=\"0\" width=\"50%\">");
            out.println("<tr>");
            out.println("<th>STT</th>");
            out.println("<th>Tên món hàng</th>");
            out.println("<th>Đơn giá</th>");
            out.println("<th>Số lượng</th>");
            out.println("<th></th>");
            out.println("</tr>");

            int i = 1;
            for (Sanpham sp : dssp) {

                out.println("<tr>");
                out.println("<td>" + i + "</td>");
                ++i;
                out.println("<td>" + sp.getTenSP() + "</td>");
                out.println("<td>" + sp.getDongia() + "</td>");
                out.println("<td><input type=\"text\" value=\"0\" id=\"soLuong"+sp.getMsSP()+"\" style=\"text-align:right;\"></td>");
                out.println("<td><input class=\"muaButton\" type=\"button\" value=\"Mua hang\" data-id=\""+sp.getMsSP()+"\"></td>");
                out.println("");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<br/>");

        } catch (IOException ex) {
            Logger.getLogger(ShowMenuTagHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ShowMenuTagHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
