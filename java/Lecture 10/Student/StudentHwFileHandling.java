import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
class InvalidBranchName extends Exception {}
class NoStudentFound extends Exception {}

class Student
{

	private String name;
	private int rollNo;
	private float percentage;
	private final Integer enrollNo;
	private String branch;

	private static int enrollCounter;
	private static int rollNoCounterComs;
	private static int rollNoCounterIt;
	private static int rollNoCounterAi;
	static int studentCounter;

	Student(int enroll)
	{
		enrollNo = new Integer(enroll);
	}
	Student()
	{
		enrollCounter++;
		enrollNo = enrollCounter;

	}

	{
		name = new String();
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
	int getRollNo()
	{
		return rollNo;
	}
	int getEnrollCounter()
	{
		return enrollCounter;
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
	int getRollNoCounterComs()
	{
		return rollNoCounterComs;
	}

	int getRollNoCounterAi()
	{
		return rollNoCounterAi;
	}

	int getRollNoCounterIt()
	{
		return rollNoCounterIt;
	}
	static void setEnrollCounter(int enrollCount)
	{
		enrollCounter = enrollCount;
	}
	void setName(String nameArg)
	{
		name = nameArg; 
	}

	void setBranch(String branchArg)
	{
		branch = branchArg;
	}
	void setPercentage(float perc)
	{
		percentage = perc;
	}
	void setRollNo(int roll)
	{
		rollNo = roll;
	}
	static void setRollNoCounterComs(int count)
	{
		rollNoCounterComs = count;
	}
	static void setRollNoCounterAi(int count)
	{
		rollNoCounterAi = count;
	}
	static void setRollNoCounterIt(int count)
	{
		rollNoCounterIt = count;
	}
	void setStudentCounter(int count)
	{
		studentCounter = count;
	}

	void addStudent(String nameArg,float percentage,String branch) throws InvalidBranchName
	{
		name = nameArg;
		this.percentage = percentage;

		
		studentCounter++;

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


	
	void deleteStudent (int index,Student obj[])
	{
		obj[index].display();
		
		for(int i =index;i<studentCounter-1;i++)
		{
			obj[i] = obj[i+1];
		}
		studentCounter = studentCounter-1;
		System.out.println("\nStudent deleted");

		 

	}
	void updateStudent() throws NoStudentFound,InvalidBranchName
	{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

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
			name = nameTemp;
			percentage = percTemp;

			if(branchTemp.equalsIgnoreCase(branch))
			{
				branch = branchTemp;
				return;
			}
			else if(branchTemp.equalsIgnoreCase("ai")||branchTemp.equalsIgnoreCase("coms")||branchTemp.equalsIgnoreCase("it"))
			{
				branch = branchTemp;
			}
			else
			{
				enrollCounter = enrollCounter-1;
				studentCounter = studentCounter-1;
				System.out.println("Enroll counter : "+enrollCounter);
				throw new InvalidBranchName();
			}

			if(branch.equalsIgnoreCase("ai"))
			{
				rollNoCounterAi = rollNoCounterAi+1;
				rollNo = rollNoCounterAi;
				
			}
			
			else if(branch.equalsIgnoreCase("coms"))
			{
				rollNoCounterComs = rollNoCounterComs+1;
				rollNo = rollNoCounterComs;
				

			}

			else if(branch.equalsIgnoreCase("it"))
			{
				rollNoCounterIt = rollNoCounterIt+1;
				rollNo = rollNoCounterIt;
				
			}
			else
			{
				throw new InvalidBranchName();
			}
		}
		catch(IOException e)
		{

		}
				

		
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
	Student students[] = new Student[100];
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	void callAddStudent()
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
		catch(IOException e) {}
	}

	void callDeleteStudent()
	{
		int enrollNo;
		int index = -1;
		try
		{
			System.out.println("Enter enrollment to delete : ");
			enrollNo = Integer.parseInt(br.readLine());
			index = searchByEnroll(enrollNo);
			students[0].deleteStudent(index,students);
		}
		catch(IOException e){}
		catch (NoStudentFound e)
		{
			System.out.println("NO STUDENT FOUND");
		}

	}

	void callDisplaySpecific(int index)
	{
		students[index].display();
	}
	void callDisplayAll()
	{
		for(int k =0;k<Student.studentCounter;k++)
		{
			students[k].display();
		}
	}

	void callUpdate()
	{
		int tempEnroll = 0;
		int index=-1;
		try
		{
			tempEnroll = Integer.parseInt(br.readLine());
			index = searchByEnroll(tempEnroll);
			students[index].updateStudent();
		}
		catch(NoStudentFound e)
		{
			System.out.println("No student found after that enrollment ");
		}
		catch(InvalidBranchName e)
		{
			students[0].deleteStudent(index,students);
		}
		catch(IOException e) {}
	}
	
	int searchByEnroll (int enrollNo) throws NoStudentFound
	{
		int index;

		for(int i =0 ; i<Student.studentCounter;i++)
		{
			
			if(students[i].getEnrollment()==enrollNo)
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

	void filterByBranch(String branchArg)
	{
		for(int i =0;i<Student.studentCounter;i++)
		{
			
			if(students[i].getBranch().equalsIgnoreCase(branchArg))
			{
				students[i].display();
			}

			
			
		}

	}
	void SortByPercentage()
	{
		Student temp;
		for(int i =0;i<Student.studentCounter-1;i++)
		{
			
			for(int j=0;j<Student.studentCounter-i-1;j++)
			{
				if(students[j].getPercentage()>students[j+1].getPercentage())
				{
					temp =  students[j+1];
					students[j+1] = students[j];
					students[j] = temp;
					
				}

			}
		}
	}
	void SortByEnroll()
	{
		Student temp;
		int flag;
		for(int i =0;i<(Student.studentCounter)-1;i++)
		{
			flag = 0;
			for(int j=0;j<(Student.studentCounter)-1;j++)
			{
				if(flag==0 && students[j].getEnrollment()>students[j+1].getEnrollment())
				{
					temp =  students[j+1];
					students[j+1] = students[j];
					students[j] = temp;
					flag =1;
				}

			}
			if(flag==0)
			{
				return;
			}
		}
	}
	void searchByName (String nameArg) throws NoStudentFound
	{
		for(int i=0;i<Student.studentCounter;i++)
		{

			if(students[i].getName().indexOf(nameArg)!=-1)
			{
				students[i].display();
			}
			
		}
		
	}
	void sortByName()
	{
		Student temp;
		for(int i=0;i<Student.studentCounter-1;i++)
		{
			for(int j=0;j<Student.studentCounter-1;j++)
			{
				
				if(students[j].getName().compareToIgnoreCase(students[j+1].getName())>0)
				{
					
					temp = students[j];
					students[j] = students[j+1];
					students[j+1]= temp;
				}
			}	
		}
	}

	void callSaveFile()
	{
		StudentFile file = new StudentFile();
		file.saveFile(students);
	}
	void callReadFile()
	{
		StudentFile file = new StudentFile();
		file.readFile(students);
	}
}

class StudentFile
{
	static private int key = 9;
	void saveFile(Student obj[])
	{
		boolean isCounterNotSaved = true;
		File f = new File("database1.sdb");
		FileOutputStream fout = null;
		try
		{
			fout = new FileOutputStream(f,false);

			for(int i=0;i<Student.studentCounter;i++)
			{
				Float fperc = new Float(obj[i].getPercentage());
				Integer intRollNo = new Integer(obj[i].getRollNo());
				Integer intEnroll = new Integer(obj[i].getEnrollment());
				Integer intEnrollCounter = new Integer(obj[i].getEnrollCounter());
				Integer intRollNoCounterAi = new Integer(obj[i].getRollNoCounterAi());
				Integer intRollNoCounterComs = new Integer(obj[i].getRollNoCounterComs());
				Integer intRollNoCounterIt = new Integer(obj[i].getRollNoCounterIt());
				
				if(isCounterNotSaved)
				{
					byte bEnrollCounter[] = intEnrollCounter.toString().concat("\n").getBytes();
					encrypt(bEnrollCounter);

					byte bRollNoCounterAi[] = intRollNoCounterAi.toString().concat("\n").getBytes();
					encrypt(bRollNoCounterAi);


					byte bRollNoCounterComs[] = intRollNoCounterComs.toString().concat("\n").getBytes();
					encrypt(bRollNoCounterComs);


					byte bRollNoCounterIt[] = intRollNoCounterIt.toString().concat("\n").getBytes();
					encrypt(bRollNoCounterIt);

					fout.write(bEnrollCounter);
					fout.write(bRollNoCounterAi);
					fout.write(bRollNoCounterComs);
					fout.write(bRollNoCounterIt);
					
					isCounterNotSaved = false;
				}
				byte benroll[] = intEnroll.toString().concat("\n").getBytes();
				encrypt(benroll);

				byte broll[] = intRollNo.toString().concat("\n").getBytes();
				encrypt(broll);

				byte bname[] = obj[i].getName().concat("\n").getBytes();
				encrypt(bname);

				byte bpercentage[] =  fperc.toString().concat("\n").getBytes();
				encrypt(bpercentage);

				byte bbranch[] = obj[i].getBranch().concat("\n").getBytes();
				encrypt(bbranch);


				
				fout.write(benroll);
				fout.write(broll);
				fout.write(bname);
				fout.write(bpercentage);
				fout.write(bbranch);
			}
		}
		catch(IOException e) {}

	}

	private void encrypt(byte arr[])
	{
		for(int j =0;j<arr.length;j++)
		{
			arr[j] = (byte)(arr[j]+key);
		}

	}

	private void decryptFile()
	{
		File f = new File("database1.sdb");
		FileInputStream fin = null;
		FileInputStream fileCount = null;
		FileOutputStream fout = null;
		try
		{
			fin = new FileInputStream(f);
			fileCount = new FileInputStream(f);

			int input;
			int count=0;
			while(fileCount.read()!=-1)
			{
				++count;
			}
			byte bFile[] = new byte[count];
			count =0;
			while((input=fin.read())!=-1)
			{
				bFile[count] = (byte)(input-key);
				++count; 
			}
			fout = new FileOutputStream(f);
			fout.write(bFile);
		}
		catch(IOException e)
		{
			
		}
		finally
		{
			try
			{
				if(fout!=null)
					fout.close();

				if(fin!=null)
					fin.close();
			}
			catch(IOException e){}
		} 
	}
	void readFile(Student obj[])
	{
		decryptFile();
		File f = new File("database1.sdb");
		FileInputStream fin = null;
		BufferedReader brFile = null;
		String line;
		int totalStudent = 0;
		
		try
		{
			fin = new FileInputStream(f);
			brFile = new BufferedReader(new InputStreamReader(fin));
			int operationStatus =1;
			
			while((line = brFile.readLine())!=null)
			{
				
				if(operationStatus==1)
				{
					Student.setEnrollCounter(Integer.parseInt(line));
					++operationStatus;

				}
				else if(operationStatus==2)
				{
					Student.setRollNoCounterAi(Integer.parseInt(line));
					++operationStatus;
				}
				else if(operationStatus==3)
				{
					Student.setRollNoCounterComs(Integer.parseInt(line));
					++operationStatus;
				}
				else if(operationStatus==4)
				{
					Student.setRollNoCounterIt(Integer.parseInt(line));
					++operationStatus;
				}
				else if(operationStatus==5)
				{
					obj[totalStudent] = new Student(Integer.parseInt(line));
					++operationStatus;

				}
				else if(operationStatus==6)
				{
					obj[totalStudent].setRollNo(Integer.parseInt(line));
					++operationStatus;
				}
				else if(operationStatus==7)
				{
					obj[totalStudent].setName(line);
					++operationStatus;
				}
				else if(operationStatus==8)
				{
					obj[totalStudent].setPercentage(Float.parseFloat(line));
					++operationStatus;
				}
				else if(operationStatus==9)
				{
					obj[totalStudent].setBranch(line);
					operationStatus = 5;
					++totalStudent;

				}
			}
			Student.studentCounter = totalStudent;
		}
		catch(IOException e)
		{
		}
		finally
		{
			try
			{
				if(fin!=null)
					fin.close();
			}
			catch(IOException e) {}
		}
	 }
}

class StudentHwFileHandling
{
	public static void main(String[] args) {
		
		StudentDatabase admin = new StudentDatabase();
		admin.callReadFile();
		

		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int choice=0;

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
			System.out.println("9 Update student");
			System.out.println("10 sort By Name");
			System.out.println("11 Exit");
			try
			{
				choice = Integer.parseInt(br.readLine());
			
			
				if(choice == 1)
				{
					admin.callAddStudent();	
				}
				else if(choice==2)
				{
					admin.callDeleteStudent();
				}
				else if(choice==3)
				{
					int index;
					int enrollNo;
					try
					{
						System.out.println("ENTER ENROLLMENT TO SEARCH : ");
						enrollNo = Integer.parseInt(br.readLine());
						index = admin.searchByEnroll(enrollNo);
						admin.callDisplaySpecific(index);
						
					}
					catch(NoStudentFound e)
					{
						System.out.println("No such student exsist : ");
					}
					
				}
				else if(choice==4)
				{
					String name;
					try
					{
						name = br.readLine();
						admin.searchByName(name);
					}
					catch(NoStudentFound e)
					{
						System.out.println("No student found !!");
					}
					
				}
				else if(choice==5)
				{
					admin.callDisplayAll();

				}
				else if(choice==6)
				{
					admin.SortByEnroll();
					admin.callDisplayAll();
				}
				else if(choice==7)
				{
					admin.SortByPercentage();
					admin.callDisplayAll();
				}
				else if(choice==8)
				{
					String branch=null;
					branch = br.readLine();
					admin.filterByBranch(branch);		
				}
				else if(choice==9)
				{
					admin.callUpdate();
				}
				else if(choice==10)
				{
					admin.sortByName();
					admin.callDisplayAll();
				}		
				else if(choice==11)
				{
				break;
				}
			}
			catch(IOException e)
			{

			}
			finally
			{

				admin.callSaveFile();
			}
		}
		
	}
}