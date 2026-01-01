import java.util.*;
class Patient{
	          Scanner sc=new Scanner(System.in);
              String name,DOB,gender,bloodgroup,email,mobileno,address,treatmentquata,userid,password;
			  static int billno=0;
			  static int patientid=1;
			  String appointment[]=new String [6];
			  static String payment[]=new String[6];
			  void registration(){
				  System.out.println("--------------------Registration form--------------------");
				  System.out.print("enter userid: ");
				  userid=sc.nextLine();
				  System.out.print("enter password(with one capital letter,one special symbol,one number): ");
				  password=sc.nextLine();
				  System.out.print("enter your name: ");
				  name=sc.nextLine();
				  System.out.print("enter your bithdate(dd/mm/year): ");
				  DOB=sc.nextLine();
				  System.out.print("enter your gender: ");
				  gender=sc.nextLine();
				  System.out.print("enter your bloodgroup: ");
				  bloodgroup=sc.nextLine();
				  System.out.print("enter your email(ex:hospital@gmail.com): ");
				  email=sc.nextLine();
				  boolean b=true;
				  do{
				    System.out.print("enter your mobileno(10 digit number): ");
				    mobileno=sc.nextLine();
					if(mobileno.length()==10)
						for(int i=0;i<10;i++){
							if(mobileno.charAt(i)<='9' && mobileno.charAt(i)>='0')
								b=false;
						}
				  }while(b);
				  System.out.print("enter your address: ");
				  address=sc.nextLine();
				  System.out.print("enter treatmentquata(private/CGHS): ");
				  treatmentquata=sc.nextLine();
				  System.out.println();
				  patientid+=1;
				  }
				  
			  
			  void bookappointment(Doctor d[],Patient p[]){
				 boolean b=false;
				 System.out.print("enter department: ");
				 String dep=sc.nextLine();
				 System.out.print("enter doctor name: ");
				 String doc=sc.nextLine();
				 System.out.print("enter date(dd/mm/year): ");
				 String date=sc.nextLine();
				 System.out.print("enter time(h:m(AM/PM)): ");
				 String time=sc.nextLine();
				 for(int i=0;i<main.doctorc;i++){
					 if(d[i].doctor_name.equalsIgnoreCase(doc) && d[i].department.equalsIgnoreCase(dep)){
						boolean b1=true;
						for(int j=0;j<main.patientc;j++){
						 if((p[j].appointment[4]!=null && p[j].appointment[4].equals(date)) && (p[j].appointment[5]!=null && p[j].appointment[5].equals(time))){
							 b1=false;
							 System.out.println("doctor not available");
							 break;
							 
						 }
						}
						if(b1){
						 System.out.println("you have to pay consultant_fee: "+d[i].consultant_fee);
						 System.out.println("Appointment book succesfully");
						 b=true;
						 billno+=1;
						 System.out.println("Payment details");
						 System.out.print("enter card number :");
						 String cardno=sc.nextLine();
						 System.out.print("enter expiry date: ");
						 String expdate=sc.nextLine();
						 System.out.print("enter CVV :");
						 String cvc=sc.nextLine();
						 System.out.println();
						 System.out.println("-----------Bill of appointment--------------");
						 System.out.println();
						 System.out.println("Patient name :"+this.name);
						 System.out.println("mobile no :"+mobileno);
						 System.out.println("Patientid :"+patientid);
						 System.out.println("doctor name :"+d[i].doctor_name);
						 System.out.println("bill no: "+billno);
						 System.out.println("bill date :"+date);
						 System.out.println("bill amount:"+d[i].consultant_fee);
						 System.out.println();
						 System.out.println("------------------THANK YOU-----------------");
						 String pid=Integer.toString(patientid);
						 String bno=Integer.toString(billno);
						 payment[0]=pid;
						 payment[1]=this.name;
						 payment[2]=d[i].doctor_name;
						 payment[3]=bno;
						 payment[4]=d[i].consultant_fee;
						 payment[5]=date;
						 appointment[0]=name;
						 appointment[1]=doc;
						 appointment[2]=dep;
						 appointment[3]=d[i].consultant_fee;
						 appointment[4]=date;
						 appointment[5]=time;
						 main.bookappc++;
						}
					 }
				 }
				 if(b==false){
					 System.out.println("doctor not found");
				 }
			  }
			  
			 void viewappointment(){
					  if(appointment[0]==null && appointment[1]==null && appointment[2]==null && appointment[3]==null && appointment[4]==null && appointment[5]==null){
						  System.out.println("no appointment");
					  }
					  else{
					  System.out.println("patient name"+"    "+"doctor name"+"    "+"department name"+"    "+"consultant_fee"+"    "+"date     "+"    "+"time ");
                      System.out.println("--------------------------------------------------------------------------------------------");
					  System.out.println(appointment[0]+"     "+appointment[1]+"     "+appointment[2]+"     "+appointment[3]+"          "+appointment[4]+"     "+appointment[5]);
				      System.out.println();
					  }
			 }
			  
			  
			  void cancelappointments(){
					  for(int i=0;i<6;i++){
						  appointment[i]=null;
					  }
					  main.cancelappc++;
					  main.bookappc--;
					  System.out.println("appointment cancel successfully"); 
			  }  
				 
			  void profile(){
			    System.out.println("-----------PATIENT PROFILE-------------");
			    System.out.println("id :"+userid);
				System.out.println("patientid :"+patientid);
			    System.out.println("name :"+name);
			    System.out.println("Date of birth :"+DOB);
			    System.out.println("gender :"+gender);
			    System.out.println("blood group :"+bloodgroup);
			    System.out.println("email :"+email);
			    System.out.println("mobile number:"+mobileno);
			    System.out.println("address: "+address);
			    System.out.println("treatment quata(private/CGHS)"+treatmentquata);
				System.out.println();
			  }
			  
			 void update(){
			    System.out.println("what do you want to update");
			    System.out.println("1.to update name");
			    System.out.println("2.to update date of birth");
			    System.out.println("3.to update gender");
			    System.out.println("4.to update blood group");
			    System.out.println("5.to update email");
			    System.out.println("6.to update mobile no");
			    System.out.println("7.to update address");
			    System.out.println("8.to update treatmentquata");
			    int ch=sc.nextInt();
			    sc.nextLine();
			    switch(ch){
			    case 1:
			          System.out.println("enter updated name");
			          name=sc.nextLine();
			          System.out.println("name updated succesfully");
			          break;
			    case 2:
			          System.out.println("enter updated date of birth");
			          DOB=sc.nextLine();
			          System.out.println("date of birth updated succesfully");
			          break;
			    case 3:
			          System.out.println("enter updated gender");
			          gender=sc.nextLine();
			          System.out.println("gender updated succesfully");
			          break;
			    case 4:
			          System.out.println("enter updated bloog group");
			          bloodgroup=sc.nextLine();
			          System.out.println("bloodgroup updated succesfully");
			          break;
			    case 5:
			          System.out.println("enter updated email");
			          email=sc.nextLine();
			          System.out.println("email updated succesfully");
			          break;
			    case 6:
			          System.out.println("enter updated mobile number");
			          mobileno=sc.nextLine();
			          System.out.println("mobile number updated succesfully");
			          break;
			    case 7:
			          System.out.println("enter updated address");
			          address=sc.nextLine();
			          System.out.println("address updated succesfully");
			          break;
			    case 8:
			          System.out.println("enter updated treatmentquata");
			          treatmentquata=sc.nextLine();
			          System.out.println("treatmentquata updated succesfully");
			          break;
			    default:
			          System.out.println("Enter choice betbeen 1 to 8");
			     }
             }
			 
			 void prescription(Doctor d[]){
				boolean b=false;
				for(int i=0;i<main.doctorc;i++){
				  if(name.equalsIgnoreCase(d[i].addprescription[0])){
					  d[i].viewprescription();
					  b=true;
				  }
				}
				if(b==false){
					System.out.println("no prescription");
				}	
			}
}

class Doctor{
	         Scanner sc=new Scanner(System.in);
             String doctor_name;
             String doctor_id;
             String doctor_password;
             int age;
			 String consultant_fee;
             String gender;
             String department;
             double Experiance;
             String Language_spoke;
			 String addprescription[]=new String[5];
			 Doctor(String doctor_name,String doctor_id,String doctor_password,int age,String consultant_fee,String gender,String department,double Experiance,String Language_spoke){
				 this.doctor_name=doctor_name;
				 this.doctor_id=doctor_id;
				 this.doctor_password=doctor_password;
				 this.age=age;
				 this.consultant_fee=consultant_fee;
				 this.gender=gender;
				 this.department=department;
				 this.Experiance=Experiance;
				 this.Language_spoke=Language_spoke;
			 }
			 
			 Doctor(){
			 }
			 
			 void displaydoctor(Doctor d[]){
				 System.out.println("    Doctor name     "+"     "+" Department "+"     "+"consultant_fee");
				 for(int i=0;i<main.doctorc;i++){
					 System.out.println("-------------------------------------------------------------------------");
					 System.out.println("     "+d[i].doctor_name+"            "+d[i].department+"            "+d[i].consultant_fee);
				 }
			 }

             void doctorprofile(){
				System.out.println("--------------DOCTOR PROFILE------------------");
				System.out.println("----------------------------------------------");
				System.out.println("doctor id: "+doctor_id);
                System.out.println("name: "+doctor_name);
				System.out.println("age: "+age);
				System.out.println("gender: "+gender);
				System.out.println("department: "+department);
				System.out.println("experience:"+Experiance);
				System.out.println("languge spoke: "+Language_spoke);
				System.out.println();
			}
			
			void doctorappointment(Patient p[]){
				boolean b=false;
				for(int i=0;i<main.patientc;i++){
				  if(doctor_name.equalsIgnoreCase(p[i].appointment[1])){
					  p[i].viewappointment();
					  b=true;
				  }
				}
				if(b==false){
					System.out.println("no appointment");
				}	
			}
			
			void addprescription(Patient p[]){
				System.out.print("enter patient name: ");
				String pname=sc.nextLine();
				System.out.print("enter treatment name: ");
				String tname=sc.nextLine();
				System.out.print("enter prescription: ");
				String prescription=sc.nextLine();
				System.out.print("enter remark: ");
				String remark=sc.nextLine();
				System.out.print("enter advice: ");
				String advice=sc.nextLine();
				boolean b=false;
				for(int i=0;i<main.patientc;i++){
					if(pname.equalsIgnoreCase(p[i].name)){
						addprescription[0]=pname;
						addprescription[1]=tname;
						addprescription[2]=prescription;
						addprescription[3]=remark;
						addprescription[4]=advice;
						b=true;
					}
				}
				if(b==false){
					System.out.println("patient not found");
				}
			}
			
			void viewprescription(){
				if(addprescription[0]==null && addprescription[1]==null && addprescription[2]==null && addprescription[3]==null && addprescription[4]==null){
						  System.out.println("no prescription");
					  }
			    else{
					 System.out.println("*-*-*-*-*-*-*-*-Prescription-*-*-*-*-*-*-*-*-*");
				     System.out.println("patient name  :  "+addprescription[0]);
					 System.out.println("treatment name:  "+addprescription[1]);
					 System.out.println("prescription  :  "+addprescription[2]);
					 System.out.println("remark        :  "+addprescription[3]);
					 System.out.println("advice        :  "+addprescription[4]);
					 System.out.println();
				}
			}
				
}

class Head extends Doctor{
	      Scanner sc=new Scanner(System.in);
	
	      boolean login(String aid,String apwd){
			  if(aid.equals("Headofappolo") && apwd.equals("Head@123")){
				  return true;
			  }
			  else{
				  return false;
			  }
		  }
		  
		  void adddoctor(Doctor d[]){
			      d[main.doctorc]=new Doctor();
				  System.out.print("enter userid: ");
				  d[main.doctorc].doctor_id=sc.nextLine();
				  System.out.print("enter password(with one capital letter,one special symbol,one number): ");
				  d[main.doctorc].doctor_password=sc.nextLine();
				  System.out.print("enter doctor name: ");
                  d[main.doctorc].doctor_name=sc.nextLine();
				  System.out.print("enter doctor age: ");
				  d[main.doctorc].age=sc.nextInt();
				  sc.nextLine();
				  System.out.print("enter doctor gender: ");
				  d[main.doctorc].gender=sc.nextLine();
				  System.out.print("enter doctor consultant_fee: ");
				  d[main.doctorc].consultant_fee=sc.nextLine();
				  System.out.print("enter doctor department: ");
				  d[main.doctorc].department=sc.nextLine();
				  System.out.print("enter doctor Experiance: ");
				  d[main.doctorc].Experiance=sc.nextDouble();
				  sc.nextLine();
				  System.out.print("enter doctor speak language: ");
				  d[main.doctorc].Language_spoke=sc.nextLine();
				  System.out.println();
				  }
	
	      void updatedoctor(Doctor d[]){
			  System.out.println("enter doctor name that you want to update data");
			  String dname=sc.nextLine();
			  boolean b=false;
			  for(int i=0;i<main.doctorc;i++){
			   if(dname.equalsIgnoreCase(d[i].doctor_name)){
			   System.out.println("1.to update Doctor Name");
			   System.out.println("2.to update Doctor age");
			   System.out.println("3.to update Doctor gender");
			   System.out.println("4.to update Doctor department");
			   System.out.println("5.to update Doctor Experiance");
			   int n=sc.nextInt();
			   sc.nextLine();
			   switch(n){
				   case 1:
				          System.out.println("Enter name for data update");
						  doctor_name=sc.nextLine();
						  break;
				   case 2:
				          System.out.println("Enter age for data update");
						  age=sc.nextInt();
						  System.out.println("age updated successfully");
						  break;
				   case 3:
				          System.out.println("Enter gender for data update");
						  gender=sc.nextLine();
						  System.out.println("gender updated successfully");
						  break;
				    case 4:
					      System.out.println("Enter department for data update");
						  department=sc.nextLine();
						  System.out.println("department updated successfully");
						  break;
					case 5:
					      System.out.println("Enter Experiance for data update");
						  Experiance=sc.nextDouble();
						  System.out.println("experiance updated successfully");
						  break;
					default:
					      System.out.println("Enter choice between 1-5");
			        }
					b=true;
		           }
			     }
				 if(b==false){
					 System.out.println("doctor not found");
				 }
		    }
				
            void deletedoctor(Doctor d[],String doctorname){
			  int index=0;
			  for(int i=0;i<main.doctorc;i++){
				if(d[i].doctor_name.equalsIgnoreCase(doctorname)){
					index=i;
				}
			  }
			  if(index==0){
			  System.out.println("doctor not found");}
			  else{
			   for(int i=0;i<=index;i++){
				if(i==index){
					d[i]=d[i+1];
				}
			   }
			   for(int i=index+1;i<main.doctorc-1;i++){
				 d[i]=d[i+1];
			   }
			   System.out.println("doctor is successfully deleted");
			   main.deletec++;
			   }
	        }				
}
class main{
           static int patientc=0;
		   static int doctorc=7;
		   static int addc=0;
		   static int deletec=0;
		   static int bookappc=0;
		   static int cancelappc=0;
		   public static void main(String args[]){
		   Scanner sc=new Scanner(System.in);
		   Patient p[]=new Patient[50];
		   Doctor d[]=new Doctor[20];
		   p[0]=new Patient();
		   patientc++;
		   p[0].name="Riya Patel";p[0].DOB="10/04/2006";p[0].gender="female";p[0].bloodgroup="A+";p[0].email="riya@gmail.com";p[0].mobileno="9897969594";
		   p[0].address="Ahmedabad";p[0].treatmentquata="private";p[0].userid="riya12";p[0].password="riya@123";
		   d[0]=new Doctor("Priyal ramani","priyal01","priyal@123",30,"700","female","cardiologist",5,"english,hindi & gujarati");
		   d[1]=new Doctor("Diya patel","diya02","diya@123",33,"1000","female","orthopedic",7,"english,hindi & gujarati");
		   d[2]=new Doctor("vasif rajpura","vasif03","vasif@123",25,"750","male","gastrologist",3 ,"english & gujarati");
		   d[3]=new Doctor("sadiya rajpura","sadiya04","sadiya@123",30,"800","female","neurologist",5 ,"english & hindi");
		   d[4]=new Doctor("Rutu rabara","rutu05","rutu@123",27,"1200","female","gynaecologist",4,"english,hindi & gujarati");
		   d[5]=new Doctor("Najib rajpura","najib06","najib@123",30,"700","male","dermatologist",5,"english,hindi & gujarati");
		   d[6]=new Doctor("Naresh soni","naresh07","naresh@123",30,"1500","male","Psychiatrist",5,"english,hindi & gujarati");
		   Head h=new Head();
		   Doctor d1=new Doctor();
		   boolean b=true;
		   do{
		      System.out.println("--------------------------WELCOME TO APOLLO HOSPITAL-----------------------------");
			  System.out.println();
			  System.out.println("1.Patient login");
			  System.out.println("2.doctor login");
			  System.out.println("3.head login");
			  System.out.println("4.exit");
			  System.out.println("enter your choice");
			  int ch=sc.nextInt();
			  sc.nextLine();
			  switch(ch){
			    case 1:
				       System.out.println("1.new Patient");
					   System.out.println("2.old Patient");
					   System.out.print("enter your choice: ");
					   int ch1=sc.nextInt();
					   sc.nextLine();
					   if(ch1==1){
						          p[patientc]=new Patient();
					              p[patientc].registration();
								  System.out.println("press choice 2 and login");
					              ch1=sc.nextInt();
								  sc.nextLine();
								  patientc++;
								  }
					   if(ch1==2){
					              System.out.print("enter userid: ");
				                  String id=sc.nextLine();
				                  System.out.print("enter password(with one capital letter,one special symbol,one number): ");
				                  String pwd=sc.nextLine();
								  boolean l=false;
				                  for(int i=0;i<patientc;i++){
					                 if(p[i].userid.equals(id) && p[i].password.equals(pwd)){
								     boolean a2=true;
									 do{
								       System.out.println("----------------Patient------------------");
									   System.out.println("1.Patient profile");
									   System.out.println("2.view doctor details");
									   System.out.println("3.book appointment");
									   System.out.println("4.view appointment");
									   System.out.println("5.cancel appointment");
									   System.out.println("6.update details");
									   System.out.println("7.show prescription");
									   System.out.println("8.logout");
									   System.out.println("enter your choice");
									   int ch2=sc.nextInt();
									   switch(ch2){
									     case 1:
										        p[i].profile();
												break;
										 case 2:
										        d1.displaydoctor(d);
												break;
										 case 3:
										        p[i].bookappointment(d,p);
												break;
										 case 4:
										        p[i].viewappointment();
												break;
										 case 5:
										        p[i].cancelappointments();
												break;
										 case 6:
										        p[i].update();
												break;
										 case 7:
										        p[i].prescription(d);
												break;
										 case 8:
										        a2=false;
												break;
										 default:
										        System.out.println("enter choice 1-9");
									  }
									 }while(a2);
									 l=true;
								  }}
								  if(l==false){
                                       System.out.println("incorrect password and userid \ntry again");
								  }
						}
						break;		   
				case 2:
				       System.out.print("enter userid: ");
				       String did=sc.nextLine();
				       System.out.print("enter password(with one capital letter,one special symbol,one number): ");
				       String dpwd=sc.nextLine();
				       boolean l2=false;
				       for(int i=0;i<doctorc;i++){
					        if(d[i].doctor_id.equals(did) && d[i].doctor_password.equals(dpwd)){
						      boolean b2=true;
							  do{
								 System.out.println("------------Doctor------------");
								 System.out.println("1.doctor profile");
								 System.out.println("2.doctor appointments");
								 System.out.println("3.add prescription");
								 System.out.println("4.logout");
								 System.out.println("enter your choice");
								 int ch3=sc.nextInt();
								 switch(ch3){
									case 1:
									       d[i].doctorprofile();
										   break;
								    case 2:
									       d[i].doctorappointment(p);
										   break;
									case 3:
									       d[i].addprescription(p);
										   break;
									case 4:
									       b2=false;
										   break;
									default:
									       System.out.println("enter choice 1-4");
								 }
							  }while(b2);
							  l2=true;
							}
					   }
					   if(l2==false){
						   System.out.println("incorrect password and userid \ntry again");
					   } 
					   break;
				case 3:
				       System.out.print("enter userid: ");
				       String aid=sc.nextLine();
				       System.out.print("enter password(with one capital letter,one special symbol,one number): ");
				       String apwd=sc.nextLine();
				       boolean c1=h.login(aid,apwd);
					   if(c1){
						      boolean c2=true;
							  do{
                       			 System.out.println("-------------------ADMIN-------------------");
                                 System.out.println("1.add doctor");								 
                       			 System.out.println("2.update doctor");
								 System.out.println("3.delete doctor");
								 System.out.println("4.patient records");
								 System.out.println("5.payment history of patients");
								 System.out.println("6.hospital records");
								 System.out.println("7.logout");
								 System.out.println("enter your choice");
								 int ch4=sc.nextInt();
								 sc.nextLine();
								 switch(ch4){
									case 1:
									       h.adddoctor(d);
										   doctorc++;
										   addc++;
										   break;
									case 2:
									       h.updatedoctor(d);
										   break;
									case 3:
									       System.out.println("enter doctor name that you want to delete data");
			                               String dname=sc.nextLine();
									       h.deletedoctor(d,dname);
										   break;
									case 4:
									       for(int i=0;i<patientc;i++){
											   System.out.println("patient"+(i+1)+":");
											   System.out.println("~~~~~~~~~~~~~~~~~~");
											   System.out.println("patient name: "+p[i].name);
											   System.out.println("patient mobileno: "+p[i].mobileno);
											   System.out.println("patient emailid: "+p[i].email);
											   System.out.println();
										   }
										   break;
									case 5:
									       for(int i=0;i<patientc;i++){
											    System.out.println("patient"+(i+1)+":");
												System.out.println("------------------");
												if(Patient.payment[0]==null && Patient.payment[1]==null && Patient.payment[2]==null && Patient.payment[3]==null && Patient.payment[4]==null && Patient.payment[5]==null){
						                        System.out.println("no payment history");
					                            }
					                           else{
					                           System.out.println("patient id"+"    "+"patient name"+"    "+"doctor name"+"    "+"bill no"+"    "+"bill amount   "+"    "+"date ");
                                               System.out.println("--------------------------------------------------------------------------------------------");
					                           System.out.println(Patient.payment[0]+"     "+Patient.payment[1]+"     "+Patient.payment[2]+"     "+Patient.payment[3]+"          "+Patient.payment[4]+"     "+Patient.payment[5]);
				                               System.out.println();
					                           }
										   }
									case 6:
									       System.out.println("_____________________Record___________________________");
									       System.out.println("Total patient register: "+patientc);
										   System.out.println("Total doctor register: "+doctorc);
										   System.out.println("total doctor added: "+addc);
										   System.out.println("total doctor deleted: "+deletec);
										   System.out.println("total book appointment: "+bookappc);
										   System.out.println("total appointment cancelled: "+cancelappc);
										   System.out.println();
										   break;
									case 7:
									       c2=false;
										   break;
									default:
									        System.out.println("enter choice 1-6");
								 }
							  }while(c2);
					   }
					   else{
							System.out.println("try again");
						   break;
					   }
					   break;
				case 4:
				       b=false;
					   break;
				default:
				        System.out.println("enter choice 1-4");
			  }
		   }while(b);
		}
}				
                       			 	
                       			 	
                       					   
					   
		   		
			
			
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  