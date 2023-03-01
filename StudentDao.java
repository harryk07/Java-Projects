package StudentMServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao  implements StudentDaointerf{

    @Override
    public boolean StudentDaoInterf(student s) {

        return false;
    }

    @Override
    public boolean delete(int roll) {
        boolean flag = false;
        try
        {
            Connection con =DBConnection.createConnection();
            String query = "delete from student_details where rollNum=" + roll;
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            flag = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return flag ;
    }

    @Override
    public void showAllStudents() {
        try{
            Connection con = DBConnection.createConnection();
            String query= "select* from student_details";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                System.out.println("RollNumber : "+ rs.getInt(1)+"\n"+"Name: "+ rs.getString(2)
                        +"\n"+ "ClgName: "+rs.getString(3)+"\n"+
                        "City: "+rs.getString(4)+ "/n"+
                        "Percentage: "+ rs.getDouble(5));
                System.out.println("----------------------------");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean showStudentById(int roll) {
        try{
            Connection con = DBConnection.createConnection();
            String query= "select* from student_details where rollNum="+roll;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                System.out.println("RollNumber : "+ rs.getInt(1)+"\n"+"Name: "+ rs.getString(2)
                        +"\n"+ "ClgName: "+rs.getString(3)+"\n"+
                        "City: "+rs.getString(4)+ "/n"+
                        "Percentage: "+ rs.getDouble(5));
                System.out.println("----------------------------");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int roll, String update, int ch, student std) {
        int choice;
        choice = ch;
        boolean flag= false;
        try{
            if (choice==1){
                Connection con =  DBConnection.createConnection();
                String query ="update student_details set sname=? where rollNum = ?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1,update);
                pst.setInt(2,roll);
                pst.executeUpdate();
                flag= true;
            }

        }catch (Exception e ){
            e.printStackTrace();
        }


        return flag;
    }

    @Override
    public boolean insertStudent(student s) {
        boolean flag = false;
        try{
            Connection con = DBConnection.createConnection();
            String query = "insert into student_details(sname,clgname,city,percentage) values(?,?,?,?)";
            PreparedStatement pst =con.prepareStatement(query);
            pst.setString(1, s.getName());
            pst.setString(2, s.getClgName());
            pst.setString(3, s.getCity());
            pst.setDouble(4, s.getPercentage());
            pst.executeUpdate();
            flag= true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public StudentDao() {
    }

}
