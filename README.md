# dbrecordproject
school project for serverprogrammering at YRGO

#Requirements
db-derby 10.8
wildfly 22.0.0
IDE of choice

#Project setup
First you clone this whole repository using this command
Git clone https://github.com/StaffanGodman/servprogproject.git

In Windows:
Start your dbDerby by going to the bin folder in your dbDerbyfolder and run
these commands
#start derby server
NetworkServerControl.bat -p 50000 start
#Start derby shell in a separate terminal
ij.bat
#Connect in to database in derby shell
connect 'jdbc:derby://localhost:50000/RecordManagement; create=true' ;

#Start wildfly
Go to your wildfly folder and run standalone.bat
navigate to localhost:9990 and deploy the derbyclient.jar includer in the dbrecordproject\lib folder
#Add datasource 
now you close wildfly and navigarte to the wildfly\standalone\configuration folder
and open the standalone.xml 
between the last <datasource> and <drivers> tag add this

<datasource jndi-name="java:/RecordDatabase" pool-name="RecordDatabase" enabled="true" use-java-context="true">
                    <connection-url>jdbc:derby://localhost:50000/RecordManagement</connection-url>
                    <driver>derbyclient.jar</driver>
                    <security>
                        <user-name>APP</user-name>
                        <password>APP</password>
                    </security>
                </datasource>
 then restart wildfly by running the standalone.bat

#Next step is to build the .war file.
Import the dbrecordproject and RecordClient folders as separate projects in your IDE of choice and
make sure the build.xml file has the right "server-dist"-path to your deployment folder
in this setup the wildfly path is
C:\wildfly-23.0.2.Final\standalone\deployments
but it should point to the location of the wildfly folder on you computer.
Then you run the build.xml as a ant script
This should deploy the project.
You can check localhost http://localhost:9990/ under deployments
#Client code.
now navigate to the RecordClient project in your IDE.
In the file RecordClient.java you will find some commands with comments
that explain their purpose. Try them out!