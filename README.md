Project Summary
The aim of the project is to explore JSP/JSTL presentation layer technologies, JDBC database interaction, and to implement the Model-View-Controller (MVC) pattern. JDBC interaction will be used to perform the basic CRUD operations Create, Read, Update and Delete.
I have implemented MVC framework with the built-in request dispatcher to perform the CRUD operations by creating, reading, updating, and deleting the records inserted into the student_table of my database 'llokesh'.
Design
1. I have implemented three packages namely:
a) Model
It contains Student.java class which is a POJO class which declares the variables which are used to fetch the corresponding data from the database.
Student.java It contains the following variables:
studentID(Not null),
firstName(Not null),
lastName,
address. and the corresponding getters and setters for the variables namely getstudentID(), getfirstName(), getlastName(), getaddress(), setstudentID(), setfirstName(), setlastName(), setaddress().
b) Service
It contains the StudentService class which establishes the connection to the database of the MySQL workbench through the JDBC driver by giving the credentials: username and password and then creating a resource pool 'llokeshMp2DS'. It performs all the required validations as per the business requirements. It defines the implementations for the C(Create) ,R(Read), U(Update), D(Delete) operations and sends the results(beans) to the servler(controller). It implements the following methods:
findAll(): It finds all the student records through executing the SQL command "select * from student_table" via the executeQuery() method and stores the results into the corresponding variables defined in the Student.java file.
find(): It finds the student record through executing the SQL command "select * from student_table where studentID=?" via the executeQuery() method and stores the results into the corresponding variables defined in the Student.java file.
create(): It creates a new student record through executing the SQL command "insert into student_table (studentID,firstName,lastName,address) values (?,?,?,?)" via the executeQuery() method and stores the results into the corresponding variables defined in the Student.java file.
update(): It updates the values in the corresponding individual student records, whenever the user clicks on the editURL and updates the values. Update is performed executing the SQL command "update student_table set studentID = ?, address = ?, firstName = ?, lastName= ? where studentID= ?" via the executeQuery() method and stores the results into the corresponding variables defined in the Student.java file.
save(): It saves i.e, updates all the changes made on to the student record values and submits the values to the controller.
delete(): It deletes the individual student record, whenever the user clicks on the deleteURL through executing the SQL command "delete from student_table where studentID=?" via the executeQuery() method and stores the results into the corresponding variables defined in the Student.java file.
c)Controller
It contains the StudentController.java class which defines the URL patterns for the following:
a) "/student": It links to the form.jsp page through which you can create as well as update the details of the student records:
Validations: Must make sure that studentID, First name and Last name must not be null or else it throws an error.
b) "/student/": It links to the show.jsp page which displays all the records of the 'student_table' table.
c) "/student/new": It links to the form.jsp page through which you create a new student.
d)"/student/delete": It links to the show.jsp page which provides a link for deleting the student record beside every individual student record. It accesses the student ID through the find() method which is defined in the StudentService class and deleted the particular student record with the corresponding ID.
e)"/student/edit": It links to the show.jsp page which a link(Student ID) to edit the student record, the student ID(hyperlink) links to the form.jsp through which you can edit the student records. 
The controller(Servlet) stores the beans in request, session, or application scope. It forwards the request to the JSP which extracts the data from the beans and displays it in the output which send the final result to the user.
Flow of the project:
Welcome page: Index.jsp

Its a welcome page which allows you to choose the following links:
1)Display all Students: It links you to the show.jsp page which displays all the student records inserted into the 'student_table' table in the 'llokesh' database. The function of displaying of all the records is performed in the StudentService class of the service module through findAll() method. 

a)Edit: The 'StudentID' of every individual student record contains link to the student/edit URL that is form.jsp page which allows you to update the details of the student records stored in the database and successfully update the changes onto the 'student_table' table. The function of updating the value of each individual record is performed in the StudentService class of the service module through update() method.

After making the necessary changes in the form, by clicking onto the save button it navigates to the show.jsp page which displays the updated student record as shown below.

b) Delete: The 'delete' link URL present beside every student record links you to the delete.jsp page. The function of deleting each record is performed in the StudentService class of the service module through delete() method.

And in the student/ URL, the updated records will be displayed as follows:
                                                                                                                                                                                                     2)Add New Student: It navigates to the form.jsp page which allows to create a new student whose functions are implemented in the StudentService class through create() method.                                       

On clicking the save button , it navigates to the show.jsp page which displays the newly created record as below:

3)To view the javadocs: This URL links to the javadocs.



Development Insights
I learnt about the flow of the MVC framework in the detailed manner, How a model, view, controller classes are created which implements the servlet technology which monitors and controls the data flow between the components and also ensuring the data integration. I learnt to debug many possible errors that occured in the project and learnt more the web development and database management aspects. I had always learnt JAVA, web development and database concepts seperately in my undergrad , but here I learnt on how to integrate these concepts. I have implemented a very basic MVC framework fulfilling the CRUD operations but have learnt a lot during the development of the project as we had to do everything from scratch. Thanks to the professors supplemental video lectures which gave us an insight on how to develop our own MVC framework. It was quite hectic to do the project in a limited time duration but have learnt a lot of new concepts and redefined my understanding of the already learnt concepts.
Requirements (Installation, Compile, Runtime)
The standard installation procedure has to be followed and configuration is made as per the specifications. 
Have used Java 1.8 and MySQL workbench 6.1.
NetBeans IDE 8.0
Class notes by Prof Scott.

Deployment instructions:
1. Unzip the folder with the name : llokeshMVC.
2. Create the database 'llokesh' and table 'student_table' which is mentioned in the createscript by pasting the contents into the SQLworkbench.
createscript:

create table student_table
(
studentID varchar(10) primary key,
firstName varchar(40),
lastName varchar(40),
address varchar(70)
);
insert into student_table values('1','Likitha','Lokesh','Chicago,IL');
select * from student_table;

3. Establish the connection to the MySQLworkbench through username and password and create a new connection pool 'llokeshMP2DS' connecting to the database 'llokesh'.
4. Import the project 'llokeshmp2' to the netbeans and build and run the project which implements the MVC framework.

