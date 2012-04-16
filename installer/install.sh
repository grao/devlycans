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

#checkout configuration files - already checked out with this script.
sudo /etc/init.d/tomcat stop

sudo cp conf/catalina.properties $TOMCAT_HOME/conf
sudo chown tomcat:tomcat $TOMCAT_HOME/conf/catalina.properties
sudo chmod 600 $TOMCAT_HOME/conf/catalina.properties

sudo mkdir -p $TOMCAT_HOME/lib/ext
sudo chown tomcat:tomcat $TOMCAT_HOME/lib/ext
sudo cp liferay-portal-6.1.0-ce-ga1/tomcat-7.0.23/lib/ext/*.jar $TOMCAT_HOME/lib/ext
sudo chown tomcat:tomcat $TOMCAT_HOME/lib/ext
sudo chown tomcat:tomcat $TOMCAT_HOME/lib/ext/*.jar
sudo chmod 755 $TOMCAT_HOME/lib/ext
sudo chmod 755 $TOMCAT_HOME/lib/ext/*.jar

sudo cp conf/portal.xml $TOMCAT_HOME/conf/Catalina/localhost
sudo chown tomcat:tomcat $TOMCAT_HOME/conf/Catalina/localhost/portal.xml
sudo chmod 600 $TOMCAT_HOME/conf/Catalina/localhost/portal.xml

sudo cp liferay-portal-6.1.0-ce-ga1-20120106155615760.war $TOMCAT_HOME/webapps/portal.war

#TODO: find a better way to set LIFERAY_HOME (instead of $TOMCAT_HOME's parent)
sudo cp conf/portal-ext.properties $TOMCAT_HOME/../

sudo /etc/init.d/tomcat start
