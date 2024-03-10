class Student
{
	static int enrollmentNumCounter=0;
	static int compsCounter = 0;
	static int elecCounter=0;
	int enrollmentNum;
	int rollNo;
	String name,branch;

	Student(String name,String branch)
	{
		this.name = name;
		this.branch = branch;

		enrollmentNumCounter++;
		enrollmentNum = enrollmentNumCounter;

		if(branch.equalsIgnoreCase("comps"))
		{
			compsCounter++;
			rollNo = compsCounter;
		}
		else
		{
			elecCounter++;
			rollNo = elecCounter;
		}

	}

	void show()
	{
		System.out.println("-------Student-------");
		System.out.println("Name : "+name);
		System.out.println("Branch: "+branch);
		System.out.println("Enrollment no : "+enrollmentNum);
		System.out.println("RollNo : "+rollNo);
	}
}

class FinalDemo
{
	public static void main(String[] args) {
		Student s1 = new Student("a","comps");
		Student s2 = new Student("b","elec");
		Student s3 = new Student("c","comps");
		Student s4 = new Student("d","elec");

		s1.show();
		s2.show();
		s3.show();
		s4.show();
	}
}