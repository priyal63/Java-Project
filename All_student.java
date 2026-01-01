import java.util.Scanner;
class All_student{
		String name;
		int roll_num;
		int java_t1t2;
		static String clg_name="LJIET";
		
		void setData(){
			Scanner sc=new Scanner(System.in); 
			System.out.println("Enter a name");
			name=sc.nextLine();
			System.out.println("Enter a rollnumber");
			roll_num=sc.nextInt();
			System.out.println("Enter a javaT1T2 marks");
			java_t1t2=sc.nextInt();
			System.out.println("university name="+clg_name);
		}
		
		void printData(){
			System.out.println("Name="+name);
			System.out.println("Roll number="+roll_num);
			System.out.println("Java t1 and t2 marks="+java_t1t2);
			System.out.println("university name="+clg_name);
		}
		
		void searchData(All_student a[]){
			Scanner sc=new Scanner(System.in);
			boolean c=true;
			System.out.println("Enter a roll number to search");
			int r=sc.nextInt();
			for(int i=0; i<a.length; i++){
				if(r==a[i].roll_num){
					c=false;
					System.out.println("Data found");
					a[i].printData();
				}
				if(c){
					System.out.println("Data not found");
				
				}
			}
		}
		
		
		void updateData(All_student a[]){ 
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter roll number for update marks");
			int r=sc.nextInt();
			for(int i=0; i<a.length; i++){
				if(r==a[i].roll_num){
					System.out.println("Enter updated marks");
					a[i].java_t1t2=sc.nextInt();
					System.out.println("marks updated successfully");
				}
			}
		}
		
		void sortData(All_student a[]){
			All_student m=new All_student();
			for(int i=0;i<a.length; i++){
				for(int j=i+1; j<a.length; j++){
					if(a[i].roll_num>a[j].roll_num){
						 m=a[i];
						a[i]=a[j];
						a[j]=m;
					}
				}
			}
		}
			
		void homeVisit(All_student a[]){
			for(int i=0;i<a.length;i++){
				if(a[i].java_t1t2<18){
					System.out.println("name="+a[i].name);
				}
			}
		}
		
		void highestNum(All_student a[]){
			int max=a[0].java_t1t2;
			for(int i=1; i<a.length; i++){
				
				if (a[0].java_t1t2<a[i].java_t1t2){
					max=a[i].java_t1t2;
				}
			}
			System.out.println(max);
		}
}

				



class Main{
		public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number of student");
		int n=sc.nextInt();
		
		All_student a[]=new All_student[n];
		for(int i=0;i<n;i++){
		  a[i]=new All_student();
		  a[i].setData();
		}
		boolean b=true;
			do{
		        System.out.println("1.To display Data of all students");
				System.out.println("2.To Search student by roll number");
				System.out.println("3.To Update Marks");
				System.out.println("4.To sort array in accending order");
				System.out.println("5.To Display Highest Marks in JAVAT1T2");
				System.out.println("6.To Display Home Visit Data");
				System.out.println("7.Exit");
				int x=sc.nextInt();
				
				switch(x){
					
					case 1:
					    System.out.println(" data");
						for(int i=0;i<n;i++){
						a[i].printData();
						}
						break;
					case 2:
						System.out.println("search data");
						a[0].searchData(a);
						break;
					case 3:
						System.out.println("update marks");
						a[0].updateData(a);
						break;
					case 4:
						System.out.println("sort by roll number");
						a[0].sortData(a);
						break;
					case 5:
						System.out.println("Highest number");
						a[0].highestNum(a);
						break;
					case 6:
						System.out.println("Home visit names");
						a[0].homeVisit(a);
						break;
					case 7:
					    System.out.println("Exit");
						b=false;
						break;
			    }
			}while(b);
		}
}		