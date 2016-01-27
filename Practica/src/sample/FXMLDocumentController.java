package sample;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

/**
 *
 * @author Usuario
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ComboBox box;
    @FXML
    private ListView list;

    @FXML
    private void changeBox(ActionEvent event) {
        cargarDiario(box.getValue().toString().substring(0, 3));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection con=getConnection();
            Statement sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT codProf, nombre FROM profesor;");
            while(rs.next()){
                box.getItems().add(rs.getString(1)+" - "+rs.getString(2));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AppJefatura.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/Horario", "root", "root");

    }

    private void cargarDiario(String id) {
        try {
            Connection con=getConnection();
            SimpleDateFormat dia=new SimpleDateFormat("E");
            String sql="SELECT h.CodTramo,r.CodOe, r.CodCurso, h.CodAsignatura FROM horario h, reparto r where h.codAsignatura=r.codAsignatura and r.CodOe=h.codOe and r.codCurso=h.codCurso and codProf=? and h.codTramo like ?;";
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1, id);
            sentencia.setString(2, dia.format(new Date()).charAt(0)+"%");
            ResultSet rs = sentencia.executeQuery();
            list.getItems().clear();
            while(rs.next()){
                list.getItems().add(String.format("%s %s %s %s",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AppJefatura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
