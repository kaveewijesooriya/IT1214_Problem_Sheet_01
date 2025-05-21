class Student{
    private int StudentId;
    private String name;
    private int DaysAttended;

Student (int StudentId, String name,int DaysAttended){
    this.StudentId=StudentId;
    this.name=name;
    this.DaysAttended = DaysAttended;
}

public int getStudentId(){
    return StudentId;
}

public void setStudentId(int StudentId){
    this.StudentId=StudentId;
}

public String getname(){
    return name;
}

public void setname(String name){
    this.name=name;
}

 public int getDaysAttended() {
     return DaysAttended;
 }

public void setDaysAttended(int DaysAttended) {
    this.DaysAttended = DaysAttended;
 }
}

 class Classroom{
	private Student[] stuarray=new Student[10];
	private int studentcount = 0;
	
	 void addstudent(Student stu){
		if(studentcount < stuarray.length){
			stuarray[studentcount]=stu;
			studentcount++;
		}
		else{
			System.out.println("Classroom is full; can't add more students");
		}
	}
	
	 void updateattends(int studentId, int updates){
		for(int i=0;i<studentcount;i++){
			if(stuarray[i].getStudentId() == studentId){
				stuarray[i].setDaysAttended(updates);
				return;
			}
		}
		System.out.println("Student ID "+studentId+" is not founded. Please enter a valid student id");
	}


 void displayAllStudents() {
        System.out.println("Student Attendance Details:");

        System.out.println( "StudentID  "+"Name  "+"DaysAttended");
        for (int i = 0; i < studentcount; i++)  {
            Student s = stuarray[i];
            System.out.println( s.getStudentId()+"  "+ s.getname()+ "  "+s.getDaysAttended());
        }
    }
}


 class Main{
    public static void main(String[] args){
        Classroom cl=new Classroom();

    cl.addstudent(new Student(101,"Alice Smith",12));
    cl.addstudent(new Student(102,"Bob Jones",15));
    cl.addstudent(new Student(103,"Carol Lee",10));

    cl.updateattends(102, 16);

    cl.updateattends(104, 5);
        
    cl.displayAllStudents();
    }
}