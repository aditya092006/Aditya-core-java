class Student
{
	private int rollNo;
	private String name;

	Student(int rollNo,String name)
	{
		this.rollNo = rollNo;
		this.name = name;
	}
	void display()
	{
		System.out.println("Roll No : "+rollNo);
		System.out.println("Nmae : "+name);
	}
}

public class ArrayOfObjects
{
	public static void main(String[] args) {
		String names[] = {"Name 1","Name 2","Name 3","Name 4"};
		Student students[] = new Student[names.length];

		for(int i =0;i<students.length;i++)
		{
			students[i]= new Student(i+1,names[i]);
		}
		for(Student student : students)
		{
			student.display();
		}
	}
}