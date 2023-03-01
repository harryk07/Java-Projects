package StudentMServices;

import java.sql.SQLOutput;
import java.util.Scanner;

class MAAin {
    public static void main(String[] args) {
        StudentDaointerf dao = new StudentDao();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome To Student Management Appl1ication");
        while (true) {
            System.out.println("\n1.Add Student" +
                    "\n2.Show all Students" +
                    "\n3.Show Student Based on RollNum" +
                    "\n4.Delete The Student" +
                    "\n5.Update Student" +
                    "\n6.Exit Application");

            System.out.println("Enter Choice");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Add Student");
                    System.out.println("Enter Student RollNum");
                    int rollNum = sc.nextInt();
                    System.out.println("Enter Student Name");
                    String name = sc.next();
                    System.out.println("Enter Student College Name");
                    String clgName = sc.next();
                    System.out.println("Enter City");
                    String city = sc.next();
                    System.out.println("Enter Percentage");
                    double percentage = sc.nextDouble();
                    student st = new student(name, clgName, city, percentage);
                    Boolean ANS = dao.insertStudent(st);
                    if (ANS) {
                        System.out.println("Record Inserted Successfully");
                    } else {
                        System.out.println("Something Went Wrong");
                    }

                    break;
                case 2:
                    System.out.println("Show all Students");
                    dao.showAllStudents();
                    break;
                case 3:
                    System.out.println("Show Student Based on RollNum");
                    System.out.println("Enter rollNumber: ");
                    int roll = sc.nextInt();
                    boolean f = dao.showStudentById(roll);
                    if (!f){
                        System.out.println("This RollNumber is not Present in our DataBase");
                    }
                    break;
                case 4:
                    System.out.println("Delete The Student");
                    System.out.println("enter roll number to delete");
                    int rollnum =sc.nextInt();
                    boolean ff= dao.delete(rollnum);
                    if (ff)
                        System.out.println(" Record Deleted Successfully...");
                    else
                        System.out.println("Something Went Wrong");
                    break;
                case 5:
                    System.out.println("Update Student");
                    System.out.println("\n1.Update the Name'\n2.Update the clgName");
                    System.out.println("enter Your Choice");
                    int choice=sc.nextInt();
                    if(choice==1){
                        System.out.println("Enter The RollNumber");
                        int rollNo= sc.nextInt();
                        System.out.println("Enter new Name");
                        String sname= sc.next();
                        student std = new student();
                        std.setName(sname);
                        boolean flag = dao.update(rollNo,sname,choice,std);
                        if (flag){
                            System.out.println("Updated successfully....");

                        }else{
                            System.out.println("Something Went Wrong...");
                        }
                    }
                    break;
                case 6:
                    System.out.println("Thank You For Using The Application");
                    System.exit(0);
                default:
                    System.out.println("Please Enter Valid Choice");
            }

        }
    }
}