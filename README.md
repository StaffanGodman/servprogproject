# dbrecordproject
school project for serverprogrammering at YRGO


#Project setup
First you clone this whole repository using this command
Git clone https://github.com/StaffanGodman/servprogproject.git

Then start your dbDerby by going to the bin folder in dbDerbyfolder and run
these commands
#start derby server
NetworkServerControl.bat -p 50000
#Start derby shell
ij.bat
#Connect in to database in derby shell
connect 'jdbc:derby://localhost:50000/RecordManagement; create=true' ;

#Start wildfly
Go to your wildfly folder and run standalone.bat
and then deploy the derbyclient.jar includer in the project lib folder
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
 then start wildfly by running the standalone.bat
#Next step is to build the .war file.
make sure the build.xml file has the right path to your deployment folder
in this setup the wildfly path is 
C:\wildfly-23.0.2.Final\standalone\deployments
but it should point to the location on you computer.
Then you run the build.xml as a ant script
This should deploy the project.
You can check localhost http://localhost:9990/ under deployments
#Client code.
now you can open up the client project.
In the file RecordClient.java you will find some commands with comments
that explain their purpose. Try them out!