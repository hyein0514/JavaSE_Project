package mylab.student.control;

import mylab.exception.InvalidGradeException;
import mylab.student.entity.Student;

public class StudentTest {
	public static void main(String[] args) {
		Student s = new Student();
		
		s.setName("김민수");
		s.setMajor("컴퓨터공학");
		
		try {
			s.setGrade(3);
            System.out.println(s.getName() + " / " + s.getMajor() + " / " + s.getGrade() + "학년");

            System.out.println("5학년으로 변경");

            s.setGrade(5);
			
		} catch (InvalidGradeException e) {
			System.out.println(e.getMessage());
		}
	}

}
