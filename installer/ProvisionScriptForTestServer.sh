#!/bin/sh
#Before running this script,
#git clone git@git.slidev.org:sli/liferay.git
#this script needs elevated privilidges
#MAKE SURE TOMCAT_HOME is set correctly
mkdir /opt/sli
cd /opt/sli
export TOMCAT_HOME=/opt/sli 

wget http://downloads.sourceforge.net/project/lportal/Liferay%20Portal/6.1.0%20GA1/liferay-portal-6.1.0-ce-ga1-20120106155615760.war
mv liferay-portal-6.1.0-ce-ga1-20120106155615760.war portal.war

sudo cp /opt/sli/portal.war /opt/sli/webapps
cd /opt/sli/webapps/
ls /opt/sli/webapps
 
sh /opt/sli/bin/catalina.sh start
sleep 3
rm -rf /opt/sli/webapps/portal.war
sh /opt/sli/bin/catalina.sh stop


#The setenv.sh has settings for the JVM that are used when tomcat starts
sudo cp conf/setenv.sh $TOMCAT_HOME/bin
sudo chown tomcat:tomcat $TOMCAT_HOME/bin/setenv.sh

# Adding jars that liferay depends on to lib/ext
sudo mkdir -p $TOMCAT_HOME/lib/ext
sudo chown tomcat:tomcat $TOMCAT_HOME/lib/ext
sudo cp conf/ext/*.jar $TOMCAT_HOME/lib/ext
sudo chown tomcat:tomcat $TOMCAT_HOME/lib/ext
sudo chown tomcat:tomcat $TOMCAT_HOME/lib/ext/*.jar
sudo chmod 755 $TOMCAT_HOME/lib/ext
sudo chmod 755 $TOMCAT_HOME/lib/ext/*.jar

# Update catalina.properties to look for jars in the directory created above (lib/ext)
sudo cp conf/catalina.properties $TOMCAT_HOME/conf
sudo chown tomcat:tomcat $TOMCAT_HOME/conf/catalina.properties
sudo chmod 600 $TOMCAT_HOME/conf/catalina.properties

# Copy the portal.xml file into tomcat 
sudo cp conf/portal.xml $TOMCAT_HOME/conf/Catalina/localhost
sudo chown tomcat:tomcat $TOMCAT_HOME/conf/Catalina/localhost/portal.xml
sudo chmod 600 $TOMCAT_HOME/conf/Catalina/localhost/portal.xml


# Copy the portal-ext.properties file into tomcat
sudo cp conf/portal-ext.properties /opt/tomcat/portal-ext.properties

sh /opt/tomcat/bin/catalina.sh start