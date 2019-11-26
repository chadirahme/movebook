package com.khaled;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.*;

@Controller
public class MoveController {

    //private final String connString;
    public  String connString;

    @Autowired
    GlobalProperties globalProperties;

    @FXML
    private TextField txtBookCode;
    @FXML
    private TextField txtBookId;
    @FXML
    private TextField txtBookName;

    @FXML
    Button btnMoveBook;


//    public MoveController(String conn) {
//        this.connString = conn ;
//    }

    @FXML
    private void initialize() {
        //this.connURL=connString;
        // myWebView.getEngine().load(myUrl);
        //txtBookCode.setText(this.connString);
        btnMoveBook.setOnAction(e->moveBook());
//
//        btnMoveBook.setOnAction(new EventHandler<ActionEvent>() {
//            @Override public void handle(ActionEvent e) {
//                txtBookName.setText("Accepted");
//            }
//        });
    }

    @FXML
    private void searchBook(){
        String bookCode=txtBookCode.getText();
        boolean bookFound=false;
        ResultSet resultSet = null;
        txtBookName.setText("");
        txtBookId.setText("");
        btnMoveBook.setDisable(false);
        try (Connection connection = DriverManager.getConnection(this.connString);)
        {
            Statement statement = connection.createStatement();
            String selectSql = "select bo_id,bo_code,bo_title_ar,bo_title_fg from p_books where bo_com_id=1 and bo_code='"+bookCode+"'";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                bookFound=true;
                System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
                txtBookId.setText(resultSet.getString(1));
                txtBookName.setText(resultSet.getString(4));
            }

            if(!bookFound){
                btnMoveBook.setDisable(true);
                AlertBox.display("Book Code not found", "Book code not found!");
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
            AlertBox.display("Connection Error !!", e.getMessage());
        }
    }

    @FXML
    private void moveBook(){
        String bookCode=txtBookCode.getText();
        boolean bookFound=false;
        ResultSet resultSet = null;
        //check if book already moved to comp=2
        try (Connection connection = DriverManager.getConnection(this.connString);)
        {
            Statement statement = connection.createStatement();
            String selectSql = "select bo_id,bo_code,bo_title_ar,bo_title_fg from p_books where bo_com_id=2 and bo_code='"+bookCode+"'";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                bookFound=true;
                AlertBox.display("Book can't moved !!", "Book already moved to DAR AL KALAM");
                btnMoveBook.setDisable(true);
                return;
            }

            if(!bookFound){
                String sql="select * into #Temp from p_books where bo_id=" + txtBookId.getText();
                statement.executeUpdate(sql);

                sql="update #TEMP set bo_subtitle2_fg='test',bo_com_id=2";
                statement.executeUpdate(sql);

                sql="select bo_com_id,bo_subtitle2_fg, * from #Temp";
                resultSet = statement.executeQuery(sql);
                // Print results from select statement
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
                }

                PreparedStatement prepsInsertProduct = connection.prepareStatement(SQLDataQuery.insertBook(), Statement.RETURN_GENERATED_KEYS);

                prepsInsertProduct.execute();
                // Retrieve the generated key from the insert.
                resultSet = prepsInsertProduct.getGeneratedKeys();
                int newBookID=0;
                // Print the ID of the inserted row.
                while (resultSet.next()) {
                    newBookID=resultSet.getInt(1);
                    System.out.println("Generated: " + resultSet.getString(1));
                }

                if(newBookID>0){
                    sql="INSERT INTO p_adjustment ([adj_type]\n" +
                            "           ,[adj_date]\n" +
                            "           ,[adj_book_id]\n" +
                            "           ,[adj_book_desc]\n" +
                            "           ,[adj_qty_ori]\n" +
                            "           ,[adj_qty_plus]\n" +
                            "           ,[adj_qty_min]\n" +
                            "           ,[adj_qty]\n" +
                            "           ,[adj_desc])" +
                            " VALUES ('ADJ' , getdate(), %d , %s , 0 , 0 ,0,0,'Close Arkam' " +
                            " ) ";
                    statement.executeUpdate(String.format(sql,newBookID,"'"+txtBookName.getText().replace("'","''")+"'"));
                }

                AlertBox.display("Book is successfully moved !!", "Book is successfully moved to DAR AL KALAM.");

            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
            AlertBox.display("Connection Error !!", e.getMessage());
        }

    }
}
