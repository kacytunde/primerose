================================
 ÀKURA 2.7 Readme
 April 24, 2013
================================
 
This document is meant to guide the user through the ÀKURA system  
installation procedure. It has been created by the QA engineers at Virtusa  
with the intent of helping new users to setup and run the system.
 
This document contains the information and instructions required to  
prepare for installation, run the setup program(s) and verify whether  
the installation is successful.  It also contains a section on  
troubleshooting and provides answers to users’ most frequent queries.
 
 
 
Table of Contents
=================
1.  Setting up Environment
    1.1. Pre-requisites
    1.2. Installation Requirements
2.  Installation Instructions
    2.1. Pre-installation Verification
    2.2. Database setup
    2.3. Change the configuration files
    2.4. Deploy the ÀKURA system
3.  Obtaining the Source Code
4.  Additional Information
5.  Licensing Information
 
 
1. Setting up Environment
=========================
 
The following sections describe the hardware/software required to install the Àkura School Management System.
 
1.1 Pre-requisites:
This section lists all the software and fonts that must be installed and configured prior to installation.
 
Software
    • JDK 1.6.0_21 - http://www.oracle.com/technetwork/java/javase/downloads/index.html
    • MySQL 5.5    - http://dev.mysql.com/downloads/mysql/
    • Tomcat 7     - http://tomcat.apache.org/download-70.cgi  
    • PDF Reader
 
Fonts
    • Sansserif
    • TimesNew Roman
 
1.2 Installation Requirements:
This section lists the hardware/software components needed for the installation process.
 
Minimum System Requirements:
 
Operating System
Windows
•    Windows 7
•    Windows XP
•    Windows server 2003 sp1
      
Linux
•    Ubuntu version 11.04 or higher
•    Debian 6 or higher
 
Server
•    2 GHz or higher
•    2 GB or higher
•    100 MB minimum. However, it is suggested to have a minimum of 250 MB of free disk space.  
     Additional space is required depending on the amount of spatial data that you expect to upload into the database.
 
Supported Browsers
•    Chrome 16.0.1+ (Fully tested)
•    Internet Explorer 8+
•    Firefox 10+


2. Installation Instructions
============================
 
This section contains instructions on how to install the ÀKURA System.  
 
2.1 Pre-installation Verification
Make sure of the following:
•   JDK 1.6.0_21 is installed and set the environment variables  
    (JAVA_HOME and append $JAVA_HOME\bin to the $PATH) accordingly.
•    MySQL Server is installed and run as a service.
•    Tomcat server is installed and run as a service.
 
2.2 Database Setup
Pre-Requisites
•    MySQL Server 5.5
•    MySQL Workbench CE 5.X (optional)
 
To set up the database execute the following SQL  scripts for existing  Àkura users (ÀKURA-2.6)

    • ÀKURA-Schema: akura-2.7/dbScripts/EXECUTER_AKURA_2.6_USER.sql


To set up the database execute the following SQL scripts for new users.
 
    • ÀKURA-Schema: akura-2.7/dbScripts/EXECUTER_NEW_USER.sql  
 
 
Notes:  Follow the execution order as specified above. The user should have full privileges to MySQL server to execute the scripts.
      
        In the Db Executors paths are configured relative to the 'akura-2.7/dbScripts' folder, therefore you have to execute the EXECUTOR according to the given path.

	Most of the default data is specific to Sri Lanka. 

	If you have questions, please refer to the attached FAQ document.
 
2.3 Changing the Configuration Files
2.3.1. Change the Database Configurations (akura/WEB-INF/classes/spring-beans/akura-dataSource-bean.xml) 
    Find the `dataSource` bean element and change following properties.
    • <property name="url">
        <value>jdbc:mysql://yourhostname:3306/akura</value>
    </property>
    • <property name="username">
        <value>akura</value>
    </property>
    • <property name="password">
        <value>akura</value>
    </property>
 
 
2.3.2.	Change the System Config Properties (akura/WEB-INF/classes/systemConfig.properties) 
    • appserver.home : set your tomcat home folder location (e.g: appserver.home=C:/apache-tomcat-7.0.16)
    • imageFile.size  : max size of profile image (in KB).
    • imageFile.width : profile image width.
    • imageFile.height : profile image height.
    • color.green.upper :defines the upper limit of green color for student term marks.
    • color.green.lower : defines the lower limit of green color for student term marks.
    • color.yellow.upper : defines the upper limit of yellow color for student term marks.
    • color.yellow.lower : defines the lower limit of yellow color for student term marks.
    • color.red.upper : defines the upper limit of red color for student term marks.
    • color.red.lower : defines the lower limit of red color for student term marks.
    • attendance.progressbar.display : In Student Profile you can configure to display or not `attendance progressbar` by setting this key to on/off. 
    • academiclife.progressbar.display : In Student Profile you can configure to display or not `academiclife progressbar` by setting this key to on/off.
    • religiousactivities.progressbar.display : In Student Profile you can configure to display or not `religiousactivities progressbar` by setting this key to on/off.
 
 
2.3.3. Change Email configurations (akura/WEB-INF/classes/email.properties) 
    Change the following key values.
    • email.host : set your email server host-name or ip (e.g: email.host=localhost/10.21.32.66)
    • email.port : set your email server SMTP port. Default SMTP port is 25.
    • email.username : set your email server user name.
    • email.password : set your email server password.
    • admin.email : set system administrator's email address.

Note: You must change the e-mail address of  the 'admin' user (default user) to an actual e-mail address. A dummy e-mail addres (admin@email.com) is created as default. If the e-mail address of  the 'admin' user is not verified, e-mails will not be sent.	

2.3.4 School Customizations
    • Changing the School Name in the Application
    Change the following keys in the application properties file (akura/WEB-INF/classes/application.properties) :
     		APPLICATION.NAME : This is the application name displayed in the Title-bar.
    		SCHOOL.NAME : Set your school name.
    	 	SCHOOL.TRACKER : Set your school tracker name.
 
Note: The 'application.properties' file contains most of the labels used in the web pages. You can change any label by changing these values.
      
    	E.g,. staff.leave.title key holds title of the Staff Module -> Leave page title. By  default, this is `Staff Leave`. If required, you can change this to `Staff Leave Details`.

    • Changing the School Name in the Reports
    Change the following key in the Report Template Properties file (akura/WEB-INF/classes/reportTemplate.properties) :
		REPORT.SCHOOL.NAME : set your school name.

    • Changing the School Logo
    You can change the school logo by replacing following images (akura/resources/images/) :
    	 	imagesschool_logo.jpg: small logo (size:79 x 90 pixels).
    	 	logo_large.jpg: large logo (size:136 x 156 pixels).

 
2.3.5. Configuring the Sync-Up Scheduler 
Create an Excel file in the following format and add it to the paths mentioned in the 'systemConfig.properties' file..
 
    • Sync-up scheduler format - Excel document (only .xls)
        Staff Reg/ Student admission No. , Date/Month/Year , Time In / Time Out (HH:MM:SS) , Time In/ Time Status (1 or 0), Reader ID
 
    • Locations of data files.
 
         schedular.excel.staff.folder : Location of Staff attendance excel files.
         schedular.excel.student.folder : Location of Student's attendance excel files.
 
    • Configure Scheduler job timings (Cron-expression). (akura/WEB-INF/classes/spring-beans/akura-attendance-scheduler-beans.xml)
 
        <task:scheduled-tasks scheduler="taskScheduler">
            <!--A cron-based trigger.  -->
            <task:scheduled ref="fixedDelayTask" method="extract"
                cron="Sec Min Hour Date-Of-Month Month Day-Of-Week" />
            <task:scheduled ref="fixedDelayTask" method="transform"
                cron="Sec Min Hour Date-Of-Month Month Day-Of-Week" />
            <task:scheduled ref="fixedDelayTask" method="load"
                cron="Sec Min Hour Date-Of-Month Month Day-Of-Week" />
            <task:scheduled ref="fixedDelayTask" method="clean"
                cron="Sec Min Hour Date-Of-Month Month Day-Of-Week" />
        </task:scheduled-tasks>
 
    Example 1 - Extract job executes every day at 12 P.M.
 
        <task:scheduled ref="fixedDelayTask" method="extract" cron=" * * 0 * * ?" />
 
 
    Example 2 - Extract job executes every day at 11.2.0 A.M.
 
        <task:scheduled ref="fixedDelayTask" method="extract" cron=" 0 2 11 * * ?" />
 
 
 
Notes:  
	• Each value must be separated by a space.  
	•'Day-of-week' starts from zero (0 for Sunday).  
	• The * (asterisk) represents every. E.g. if * is put for Hour, it will execute every hour.   
	• AkuraSchedular.log (Located in webServe/logs) prints the status of running jobs.


2.3.6.Enabling to Enter Marks/Gradings for Monthly Term Test Marks (akura/WEB-INF/classes/config.properties)
	student.sub.term.marks.allow.marks : If the requirement is to enter marks set the property value to 'True`. To enter grades, set the value to `False`.


2.4 Deploying the Àkura system
• Change the property files accordingly and copy the akura folder into the Tomcat server webapp folder.
• Restart the Tomcat server.
• Browse the application using the URL. (e.g. http://localhost:8080/akura/login.htm)
• Use the following username and password to login to the system.
	• Username : admin
	• Password : admin
 
      
3. Obtaining the Source Code
============================
 
The source code is available at: <http://svn.code.sf.net/p/akura/code/trunk>
 
 
4. Additional Information
=========================
 
Comments and queries can be directed to the following individuals.
 
Chamindra De Silva – ckdesilva@virtusa.com
Charles Sudharshan Jayawardena – cjayawardena@virtusa.com
Manjula Fernando – manjula@virtusa.com
Ganga Abeyrathne – gabeyrathne@virtusa.com
Jeewantha Samaraweera – jsamaraweera@virtusa.com
 
Charles Sudharshan Jayawardena, Manjula Fernando, Ganga Abeyrathne, Upendra Haputantry, Chintha Maljini De Silva, Uthpala Nagahawatta, 
Sandun Champika Bandara Basnayake, Jeewantha Samaraweera, Kohilavani Kandasamy, Marlon Chapman, Lahiru Senani Halpe, Anjalee De Saram, 
Chandima Karunatillake, Gayan Chandana Kumara, Aushani Udayangani, Krishani Liyanaarachchi, Medhavi Somaratne, Isanka Dissanayake, 
Bhashita Wijewardhane, Lahiru Amaradasa, Mahesh Jeewantha, Thilina Rubasingha, Chanaka Dharmarathna
 
 
5. Licensing Information
========================
 
Copyright (C) 2012 Virtusa Corporation.
The Àkura School Management System is a free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
 
This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of 
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.
