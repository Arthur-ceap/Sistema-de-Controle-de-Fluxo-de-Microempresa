package Model;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class GerarPDF_DAO {
    public String servidor = "localhost";
    public String banco = "mercado";
    public static String url = "jdbc:mysql://localhost/mercado";
    public static String usuario = "root";
    public static String senhaBanco = "ceap";
    
    public static int codCompra = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o código da Compra"));
    public static long cpf = 0;
    public static String cliente = "";
    public static String prod = "";
    public static double precoInd = 0.0;
    public static int qtde = 0;
    public static String data = "";
    public static double total = 0.0;
    
    public static void ConsultaDados(){
        try{
            Controller.Conecta_BD.carregaDriver();
            try {
                Connection con = DriverManager.getConnection(url, usuario, senhaBanco);
                String sql = "SELECT cpf_com, cli_com, prod_com, preco_ind, qtde_com, DATE_FORMAT(data_com, '%d/%m/%Y') as data_com, preco_fin FROM compra WHERE id_com =" + codCompra;
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql);

                int i = 0;

                while (rs.next()) {
                    cpf = Long.valueOf(rs.getString("cpf_com"));
                    cliente = rs.getString("cli_com");
                    prod = rs.getString("prod_com");
                    precoInd = Double.parseDouble(rs.getString("preco_ind"));
                    qtde = Integer.parseInt(rs.getString("qtde_com"));
                    data = rs.getString("data_com");
                    total = Double.parseDouble(rs.getString("preco_fin"));
                    i++;
                }

                if (i == 0) {
                    JOptionPane.showMessageDialog(null,"Dado não cadastrado","Resultado",-1);
                }

                con.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Erro ao conectar com o servidor","ERRO!",0);
            }

        } catch(NumberFormatException erro) {
            JOptionPane.showMessageDialog(null,"Digite o código corretamente","ERRO",0);
        }
    }
    
    public static void GeraNota() throws FileNotFoundException, IOException, DocumentException {
        Document doc = null;
        OutputStream os = null;
        
        try {
            doc = new Document(PageSize.A4, 72, 72, 72, 72);
            os = new FileOutputStream("C:\\Users\\arthu\\Documents\\NetBeansProjects\\Mercado\\src\\Notas_Fiscais\\notaFiscal.pdf");
            PdfWriter.getInstance(doc, os);
            doc.open();

            Font f = FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD);
            Paragraph titulo = new Paragraph("NOTA FISCAL", f);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            Paragraph cpf3 = new Paragraph("CPF: " + cpf + Font.BOLD);
            Paragraph cliente3 = new Paragraph("Cliente: " + cliente);
            Paragraph item3 = new Paragraph("Item da Compra: " + prod);
            Paragraph qtde3 = new Paragraph("Quantidade: " + qtde);
            Paragraph precoInd3 = new Paragraph("Preço(UN): R$" + precoInd);
            Paragraph data3 = new Paragraph("Data da Compra: " + data);
            Paragraph formaPag = new Paragraph("Forma de Pagamento: " + View.VisuCompra_GUI.forma);
            Paragraph total3 = new Paragraph("Total: R$" + total);
            cpf3.setSpacingAfter(20);
            cliente3.setSpacingAfter(20);
            item3.setSpacingAfter(20);
            qtde3.setSpacingAfter(20);
            precoInd3.setSpacingAfter(20);
            data3.setSpacingAfter(20);
            formaPag.setSpacingAfter(20);
            total3.setSpacingAfter(20);
            doc.add(titulo);
            doc.add(cpf3);
            doc.add(cliente3);
            doc.add(item3);
            doc.add(qtde3);
            doc.add(precoInd3);
            doc.add(data3);
            doc.add(formaPag);
            doc.add(total3);

        } finally {
            if (doc != null) {
                doc.close();
            }

            if (os != null) {
                os.close();
            }
        }
        
        Desktop.getDesktop().open(new File("C:\\Users\\arthu\\Documents\\NetBeansProjects\\Mercado\\src\\Notas_Fiscais\\notaFiscal.pdf"));
    }
}
