package sample;
import java.sql.*;

public class DBinteract {
    /**
     *<h1>Class DBinteract</h1>
     *
     * This class handles alll interactions with the database:connecting,updating and reading data.
     */

    public void update (String acc,String amt){
        /**
         *<h2>Method update</h2>
         * This method updates the balance in the respective account.
         *
         * @param acc,the account to which the money is to be deposited in.
         * @param amt,amount which is to be updated.
         *
         */
        int acc1 = Integer.parseInt(acc);
        int amt1=Integer.parseInt(amt);

      //  boolean status= false;
            try (Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/bank", "root", "122448")) {

                conn.setAutoCommit(false);

               if( authenticate(acc1)==false){
                   Alert a2 = new Alert();
                   a2.display("Error","The Account number you entered is incorrect,try again.");
               }else{

                   String UpdateQuery = " UPDATE users SET balance = balance +"+amt1+" WHERE acc_no ="+acc1+";";
                   Statement stmt = conn.createStatement();
                   stmt.executeUpdate(UpdateQuery);

                   Commit c1= new Commit();
                   Alert a3 = new Alert();

                   if(c1.display(acc,amt)==true){

                       conn.commit();

                       a3.display("Success","Deposit successful,new balance is ksh "+ read(acc1)+".");

                   }else{

                       conn.rollback();
                       a3.display("Message!","Deposit cancelled successfully,balance is still ksh "+ read(acc1)+".");

                   }
                    conn.close();

               }

            } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }

        //return status;
    }

    private boolean authenticate (int acc){
        /**
         * <h2>Method Authenticate</h2>
         * Method is to authenticate whether account number entered is valid.
         *
         * @param acc,account number to be validated.
         */
        boolean authenticate=false;
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/bank", "root", "122448")) {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from users WHERE acc_no="+acc+";");

            if (rs.next() == false) {
                System.out.println("ResultSet in empty in Java");
                authenticate=false;
            }else{
                authenticate=true;
            }

            conn.close();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }



        return authenticate;
    }

    private int read(int acc){
        /**
         * <h2>Method read</h2>
         *Reads the current balance.
         *
         * @param acc,account from which data is to be read from.
         */
        int curBal=0;

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/bank", "root", "122448")) {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT balance from users WHERE acc_no="+acc+";");

            while(rs.next()){
                curBal=rs.getInt("balance");
            }


            conn.close();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }




        return curBal;
    }


    
}
