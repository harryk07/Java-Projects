package StudentMServices;




public interface StudentDaointerf {
    public boolean insertStudent(student s);
    public boolean StudentDaoInterf(student s);
    public boolean delete(int roll);
    public boolean update(int roll, String update, int ch, student std);
    public void showAllStudents();
    public boolean showStudentById(int roll);


}
