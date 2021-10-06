package Model;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
 
public class ShopDB {
 
    private Connection con;
 
    public ShopDB() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QuanAn", "sa", "123456");
    }
 
    public Sanpham getSanPham(String ms) throws Exception {
        Sanpham sp = null;
        Statement stmt = con.createStatement();
        String sql = "select * from sanpham where mssp ='" + ms + "'";
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            String mssp = rs.getString("mssp");
            String ten = rs.getString("tenSP");
            float dg = rs.getFloat("dongia");
            sp = new Sanpham(mssp, ten, dg);
        }
        return sp;
    }
 
    /**
     * Lấy tât cả sản phẩm
     * @return danh sách sản phẩm
     * @throws Exception
     */
    public ArrayList<Sanpham> getAllProducts() throws Exception {
        ArrayList<Sanpham> ds = new ArrayList<Sanpham>();
        ResultSet rs = null;
        Statement stmt = con.createStatement();
        String sql = "select * from sanpham";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            String mssp = rs.getString("mssp");
            String ten = rs.getString("tenSP");
            float dg = rs.getFloat("dongia");
            ds.add(new Sanpham(mssp, ten, dg));
        }
        return ds;
    }
}