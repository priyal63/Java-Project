import java.util.Scanner;
class Bookinfo{
	String book_title;
	String book_authername;
	String book_publication;
	long book_isban_num;
	double book_price;
	int book_pages,n;
	void setData(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Title of book");
		book_title=sc.nextLine();
		System.out.println("Enter auther name of book");
		book_authername=sc.nextLine();
		System.out.println("Enter publication of book");
		book_publication=sc.nextLine();
		System.out.println("Enter isbn of book");
		book_isban_num=sc.nextLong();
		System.out.println("Enter price of book");
		book_price=sc.nextInt();
		System.out.println("Enter pages of book");
		book_pages=sc.nextInt();
	}
	
	
	
		void searchBytitle(Bookinfo a[],String title){
		for(int i=0;i<n;i++){
		if(a[i].book_title.equalsIgnoreCase(title)){
			System.out.println("Book is found in a recoard");
		a[i].setData();}
			else
				System.out.println("Book is not found in a recoard");
		
		}
	}
	
		void searchByAuther(Bookinfo a[],String authername){
		for(int i=0;i<n;i++){
		if(a[i].book_authername.equalsIgnoreCase(authername)){
			System.out.println("Book is found in a recoard");
		a[i].setData();}
			else
				System.out.println("Book is not found in a recoard");
		
		}
	}
	
		void searchByIsbn(Bookinfo a[],long isbn){
		for(int i=0;i<n;i++){
		if(a[i].book_isban_num==isbn){
			System.out.println("Book is found in a recoard");
			a[i].setData();}
			else
				System.out.println("Book is not found in a recoard");
		
		}
	}
	
	void searchBypublication(Bookinfo a[],String pub_date){
		for(int i=0;i<n;i++){
		if(a[i].book_publication.equalsIgnoreCase(pub_date)){
			System.out.println("Book is found in a recoard");
		a[i].setData();}
			else
				System.out.println("Book is not found in a recoard");
		
		}
	}
	
	void printData(){
         System.out.println("title:"+book_title);
		 System.out.println("Auther name:"+book_authername);
		 System.out.println("publication:"+book_publication);
		 System.out.println("Isbn:"+book_isban_num);
		 System.out.println("Price:"+book_price);
		 System.out.println("Pages"+book_pages);

		}
}
	
class Main{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		
		
		System.out.println("enter a number of books");
		int n=sc.nextInt();
		Bookinfo a[]=new Bookinfo[n];
		for(int i=0;i<n;i++){
			a[i]=new Bookinfo();
			a[i].setData();
		}
		
		System.out.println("1.search By title");
		System.out.println("2.search By auther");
		System.out.println("3.search By Isbn");
		System.out.println("4.search By publication data");
		int m=sc.nextInt();
		
		switch(m){
			case 1:			
				Bookinfo a1=new Bookinfo();
				System.out.println("Enetr a Title of Book");
				String title=sc.nextLine();
				a1.searchBytitle(a,title);
				break;
			case 2:
				Bookinfo a2=new Bookinfo();
				System.out.println("Enetr a Auther of Book");
				String authername=sc.nextLine();
				a2.searchByAuther(a,authername);
				break;
			case 3:
				Bookinfo a3=new Bookinfo();
				System.out.println("Enetr a Isbn of Book");
				long isbn=sc.nextLong();
				a3.searchByIsbn(a,isbn);
				break;
		    case 4:
				Bookinfo a4=new Bookinfo();
				System.out.println("Enetr a publication of Book");
				String pub_date=sc.nextLine();
				a4.searchByAuther(a,pub_date);
				break;
			case 5:
			System.out.println("please enter valid number");
			    break;
				
		}
		for(int i=0;i<0;i++){
			a[i].printData();
		}
	}
}
	
