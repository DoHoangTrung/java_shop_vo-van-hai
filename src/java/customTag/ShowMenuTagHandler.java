package customTag;

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
            out.println("<form action=\"ControllerServlet\">");
            out.println("Hãy chọn món hàng cần mua:");
            out.println("<select name=\"monhang\">");

            ShopDB db = new ShopDB();
            ArrayList<Sanpham> dssp = db.getAllProducts();
            for (Sanpham sp : dssp) {
                out.println("<option value=\""+sp.getMsSP()+ "\">"+sp.getTenSP()+"</option>");
            }
            
            out.println("</select>");
            out.println("Số lượng<input name=\"soluong\" value=\"0\" id=\"sl\"/>");
            out.println("<input type=\"hidden\" name=\"action\" value=\"muahang\"/>");
            out.println("<input type=\"submit\" value=\"Mua hàng\" onclick=\"return kt()\"/>");

        } catch (IOException ex) {
            Logger.getLogger(ShowMenuTagHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ShowMenuTagHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}