package customTag;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.PageContext;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Giohang;
import Model.Monhang;

public class showBillTagHandler extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException {
        try {
            JspWriter out = getJspContext().getOut();

            Object obj = getJspContext().getAttribute("giohang",PageContext.SESSION_SCOPE);
            if (obj != null) {
                Giohang giohang = (Giohang) obj;
                ArrayList<Monhang> dssp = giohang.getGiohang();

                out.println("<table align=\"center\" border=\"1\" width=\"95%\">");
                out.println("<tr>");
                out.println("<th>STT</th>");
                out.println("<th>Tên món hàng</th>");
                out.println("<th>Số lượng</th>");
                out.println("<th>Đơn giá</th>");
                out.println("<th>Thành tiền</th>");
                out.println("</tr>");

                int i = 1;
                for (Monhang mh : dssp) {
                    String ms = mh.getSanpham().getMsSP();
                    String ten = mh.getSanpham().getTenSP();
                    double dg = mh.getSanpham().getDongia();
                    int sl = mh.getSoluong();
                    out.println("<tr>");
                    out.println("<td>" + i + "</td>");
                    ++i;
                    out.println("<td>" + ten + "</td>");
                    out.println("<td>" + dg + "</td>");
                    out.println("<td>" + sl + "</td>");
                    out.println("<td>" + dg * sl + "</td>");
                    out.println("</tr>");
                }
                out.println("<tr>");
                out.println("<td align=\"right\" colspan=\"5\" ><b>Tổng tiền:"+giohang.Tongtien()+"</b></td>");
                out.println("</tr>");
                out.println("</table>");

            }
        } catch (IOException ex) {
            Logger.getLogger(showBillTagHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
