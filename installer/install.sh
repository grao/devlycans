#!/bin/sh
#Before running this script,
#git clone git@git.slidev.org:sli/liferay.git

#this script needs elevated privilidges

#MAKE SURE TOMCAT_HOME is set correctly
export TOMCAT_HOME=/opt/tomcat/apache-tomcat-7.0.27

#Download Dependenices
wget http://downloads.sourceforge.net/project/lportal/Liferay%20Portal/6.1.0%20GA1/liferay-portal-tomcat-6.1.0-ce-ga1-20120106155615760.zip
wget http://downloads.sourceforge.net/project/lportal/Liferay%20Portal/6.1.0%20GA1/liferay-portal-6.1.0-ce-ga1-20120106155615760.war
unzip liferay-portal-tomcat-6.1.0-ce-ga1-20120106155615760.zip

#stop tomcat before making changes
sudo /etc/init.d/tomcat stop

#The setenv.sh has settings for the JVM that are used when tomcat starts
sudo cp conf/setenv.sh $TOMCAT_HOME/bin
sudo chown tomcat:tomcat $TOMCAT_HOME/bin/setenv.sh

# Adding jars that liferay depends on to lib/ext
sudo mkdir -p $TOMCAT_HOME/lib/ext
sudo chown tomcat:tomcat $TOMCAT_HOME/lib/ext
sudo cp liferay-portal-6.1.0-ce-ga1/tomcat-7.0.23/lib/ext/*.jar $TOMCAT_HOME/lib/ext
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

# Copy the liferay war (renamed to portal.war) into tomcat
#sudo cp liferay-portal-6.1.0-ce-ga1-20120106155615760.war $TOMCAT_HOME/webapps/portal.war
# TAPAN AVASTHI
# Rename the Liferay WAR before deploy 
mv liferay-portal-6.1.0-ce-ga1-20120106155615760.war portal.war

#TODO: find a better way to set LIFERAY_HOME (instead of $TOMCAT_HOME's parent)
sudo cp conf/portal-ext.properties $TOMCAT_HOME/../

# Start tomcat
sudo /etc/init.d/tomcat start
