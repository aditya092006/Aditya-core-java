import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class InvalidBranchName extends Exception {}
class NoStudentFound extends Exception {}
class Student
{
	private String name;
	private int rollNo;
	private float percentage;
	private int enrollNo;
	private String branch;

	private static int enrollCounter;
	private static int rollNoCounterComs;
	private static int rollNoCounterIt;
	private static int rollNoCounterAi;
	static int studentCounter;

	{
		
		branch = new String();
	}

	static
	{
		enrollCounter = 0;
		rollNoCounterComs = 0;
		rollNoCounterIt = 0;
		rollNoCounterAi = 0;
		studentCounter = 0;
	}
	float getPercentage()
	{
		return percentage;
	}
	String getBranch()
	{
		return branch;
	}

	String getName()
	{
		return name;
	}
	int getEnrollment()
	{
		return enrollNo;
	}
	void addStudent(String nameArg,float percentage,String branch) throws InvalidBranchName
	{
		name = new String(nameArg);
		this.percentage = percentage;

		enrollCounter++;
		studentCounter++;

		enrollNo = enrollCounter;

		if(branch.equalsIgnoreCase("ai"))
		{
			rollNoCounterAi++;
			rollNo = rollNoCounterAi;
			
		}
		else if(branch.equalsIgnoreCase("coms"))
		{
			rollNoCounterComs++;
			rollNo = rollNoCounterComs;
		}
		else if(branch.equalsIgnoreCase("it"))
		{
			rollNoCounterIt++;
			rollNo = rollNoCounterIt;
		}
		else
		{
			enrollCounter = enrollCounter-1;
			studentCounter = studentCounter-1;
			System.out.println("Enroll counter : "+enrollCounter);
			throw new InvalidBranchName();
		}
		this.branch = branch;
		
	}


	
	void deleteStudent (int enrollNo,Student obj[]) throws NoStudentFound
	{
		int index;
		StudentDatabase obj1 = new StudentDatabase();
		try
		{
			index = obj1.searchByEnroll(enrollNo,obj);
		}
		catch(NoStudentFound e)
		{
			throw e;
		}
		
		obj[index].display();
		
		for(int i =index;i<studentCounter-1;i++)
		{
			obj[i] = obj[i+1];
		}
		studentCounter = studentCounter-1;
		System.out.println("\nStudent deleted");

		 

	}
	void updateStudent(int enrollNo,Student obj[]) throws NoStudentFound,InvalidBranchName
	{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StudentDatabase obj1 = new StudentDatabase();
		int index;
		try
		{
			index = obj1.searchByEnroll(enrollNo,obj);
		}
		catch(NoStudentFound e)
		{
			throw e;
		}
		String nameTemp;
		float percTemp;
		String branchTemp;

		try
		{
			System.out.println("Enter name to insert : ");
			nameTemp = new String(br.readLine());
			System.out.println("Enter name to percentage : ");
			percTemp = Float.parseFloat(br.readLine());
			System.out.println("Enter name to branch : Ai,It,Coms : ");
			branchTemp = new String(br.readLine());
			obj[index].name = name;
			obj[index].percentage = percTemp;

			if(branchTemp.equalsIgnoreCase("ai")||branchTemp.equalsIgnoreCase("coms")||branchTemp.equalsIgnoreCase("it"))
			{
				obj[index].branch = branchTemp;
			}
			else
			{
				enrollCounter = enrollCounter-1;
				studentCounter = studentCounter-1;
				System.out.println("Enroll counter : "+enrollCounter);
				throw new InvalidBranchName();
			}
			
		}
		catch(IOException e)
		{}
				

		
	}
	void display()
	{
		System.out.println("\nenrollNo : "+enrollNo);
		System.out.println("rollNo : "+rollNo);
		System.out.println("Name : "+name);
		System.out.println("percentage : "+percentage);
		System.out.println("Branch : "+branch+"\n");

	}


	
}


class StudentDatabase
{
	int searchByEnroll (int enrollNo,Student obj[]) throws NoStudentFound
	{
		int index;

		for(int i =0 ; i<Student.studentCounter;i++)
		{
			
			if(obj[i].getEnrollment()==enrollNo)
			{

				index = i;
				return index;
			}
			
		}
		index = -1;
		if(index==-1)
		{
			throw new NoStudentFound();
		}
		return -1;
	}

	void filterByBranch(String branchArg,Student obj[])
	{
		for(int i =0;i<Student.studentCounter;i++)
		{
			
			if(obj[i].getBranch().equalsIgnoreCase(branchArg))
			{
				obj[i].display();
			}

			
			
		}

	}
	void SortByPercentage(Student obj[])
	{
		Student temp;
		int flag;
		for(int i =0;i<(Student.studentCounter)-1;i++)
		{
			flag = 0;
			for(int j=0;j<(Student.studentCounter)-1;j++)
			{
				if(flag==0 && obj[j].getPercentage()>obj[j+1].getPercentage())
				{
					temp =  obj[j+1];
					obj[j+1] = obj[j];
					obj[j] = temp;
					flag =1;
					
				}

			}
			if(flag==0)
			{
				return;
			}
		}
	}
	void SortByEnroll(Student obj[])
	{
		Student temp;
		int flag;
		for(int i =0;i<(Student.studentCounter)-1;i++)
		{
			flag = 0;
			for(int j=0;j<(Student.studentCounter)-1;j++)
			{
				if(flag==0 && obj[j].getEnrollment()>obj[j+1].getEnrollment())
				{
					temp =  obj[j+1];
					obj[j+1] = obj[j];
					obj[j] = temp;
					flag =1;
				}

			}
			if(flag==0)
			{
				return;
			}
		}
	}
	void searchByName (String nameArg,Student obj[]) throws NoStudentFound
	{
		for(int i=0;i<Student.studentCounter;i++)
		{

			if(obj[i].getName().indexOf(nameArg)!=-1)
			{
				obj[i].display();
			}
			
		}
		
	}
	void sortByName(Student obj[])
	{
		Student temp;
		for(int i=0;i<Student.studentCounter-1;i++)
		{
			for(int j=0;j<Student.studentCounter-1;j++)
			{
				
				if(obj[j].getName().compareToIgnoreCase(obj[j+1].getName())>0)
				{
					
					temp = obj[j];
					obj[j] = obj[j+1];
					obj[j+1]= temp;
				}
			}
			
		}

	}
}

class StudentHw
{
	public static void main(String[] args) {
		Student students[] = new Student[100];
		StudentDatabase admin = new StudentDatabase();
		Student monitor = new Student();
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int choice;

		while(true)
		{
			System.out.println("Enter choice : ");
			System.out.println("1 Add stuent");
			System.out.println("2 Delete student");
			System.out.println("3 Search by Enroll");
			System.out.println("4 Search by Name");
			System.out.println("5 Display");
			System.out.println("6 Sort by enroll");
			System.out.println("7 Sort by percentage");
			System.out.println("8 Filter by branch");
			System.out.println("9 Filter by branch");
			System.out.println("10 Filter by branch");
			try
			{
					choice = Integer.parseInt(br.readLine());
			
				if(choice == 1)
				{
					String name;
					float percentage;
					String branch;

				
					try
					{
						System.out.println("Enter name to insert : ");
						name = br.readLine();
						System.out.println("Enter name to percentage : ");
						percentage = Float.parseFloat(br.readLine());
						System.out.println("Enter name to branch : Ai,It,Coms : ");
						branch = br.readLine();
						students[Student.studentCounter] = new Student();
						students[Student.studentCounter].addStudent(name,percentage,branch);
					}
					catch(InvalidBranchName e)
					{

						System.out.println("Only branches available are Coms,It,Ai");
					}
					catch(IOException e)
					{}
				
				}
				else if(choice==2)
				{
					int enrollNo;
					try
					{
						System.out.println("Enter enrollment to delete : ");
						enrollNo = Integer.parseInt(br.readLine());
						monitor.deleteStudent(enrollNo,students);
					}
					catch(NoStudentFound e)
					{
						System.out.println("No student with such enrollment no");
					}
					catch(IOException e)
					{}

				}
				else if(choice==3)
				{
					int index;
					int enrollNo;
					try
					{

						System.out.println("ENTER ENROLLMENT TO SEARCH : ");
						enrollNo = Integer.parseInt(br.readLine());
						index = admin.searchByEnroll(enrollNo,students);
						students[index].display();
					}
					catch(NoStudentFound e)
					{
						System.out.println("No such student exsist : ");
					}
					catch(IOException e)
					{}
				}
				else if(choice==4)
				{
					String name;
					
					try
					{
						name = br.readLine();
						admin.searchByName(name,students);
					}
					catch(NoStudentFound e)
					{
						System.out.println("No student found !!");

					}
					catch(IOException e)
					{}

				}
				else if(choice==5)
				{
					for(int k =0;k<Student.studentCounter;k++)
					{
						students[k].display();
					}
				}
				else if(choice==6)
				{
					admin.SortByEnroll(students);
					for(int k=0;k<Student.studentCounter;k++)
					{						
						students[k].display();
					}
				}
				else if(choice==7)
				{
					admin.SortByPercentage(students);
					for(int k=0;k<Student.studentCounter;k++)
					{
						students[k].display();
					}
				}
				else if(choice==8)
				{
					String branch;
					branch = br.readLine();
					admin.filterByBranch(branch,students);
					
				}
				else if(choice==9)
				{
					int tempEnroll;
					tempEnroll = Integer.parseInt(br.readLine());
					try
					{
						monitor.updateStudent(tempEnroll,students);
					}
					catch(NoStudentFound e)
					{
						System.out.println("No student found after that enrollment ");
					}
					catch(InvalidBranchName e)
					{
						System.out.println("That branch does not exsist");
					}
				}
				else if(choice==10)
				{
					admin.sortByName(students);
					for(int k = 0;k<Student.studentCounter;k++)
					{
						students[k].display();
					}
				}

			}
			catch(IOException e)
			{}
			
			

		}
		
	}
}