# PolitAktiv Map Portlet
This portlet for Liferay based on [Leaflet](http://leafletjs.com), OpenStreet map and [Leaflet.Draw](https://github.com/Leaflet/Leaflet.draw) plugin.

Guest user can observe all markers without possibility to add or update them.
Signed in User can add and update markers. User's markers colored with red and displayed under Your marker's panel. 


Configuration:
	Map center longtitude, latitude and zoom level can be configured from portlet's configuration page. After updating values page should be refreshed.

###############################################
# aleksandar.lukic@aslcom.net installation guide

Step by step guide to start Liferay 6.2 Portlet development 
###############################################
1.
 Download Liferay 6.2 with tomcat and jre bundle. If you start your Liferay development it will be nice if you don't think about version of tomcat and java that is compatibile with your Liferay development version,
 so it would be nice if you can download everything bundled and just UNPACK it. This step is right that!
 Go to https://sourceforge.net/projects/lportal/files/Liferay%20Portal/6.2.1%20GA2/
and download bundled Liferay. Direct link: https://sourceforge.net/projects/lportal/files/Liferay%20Portal/6.2.1%20GA2/liferay-portal-tomcat-jre-6.2-ce-ga2-20140321144642639.zip/download
Unpack it in some folder. 
Warning: Do not unpack it in deep folder structure because on older windows you have just 256 characters for dir path.
2.
 Download appropriate Liferay SDK. You can take it from the same location lik ein step 1.
or use direct link https://sourceforge.net/projects/lportal/files/Liferay%20Portal/6.2.1%20GA2/liferay-plugins-sdk-6.2-ce-ga2-20140319114139101.zip/download
Unpack it in some folder
3.
 Go to the root of the plugin SDK folder and make  build.<username>.properties where <username> is the current os username (current logged user)
In that file.
Here are example of build.<username>.properties (my settings: build.alukic.properties):
File contains main path of needed components for succesfull build and deploy to Liferay portal

app.server.type = tomcat
app.server.tomcat.dir = D:\\projects\\PolitAktiv\\liferay-portal-6.2-ce-ga2\\tomcat-7.0.42
javac.compiler = modern
app.server.parent.dir = D:\\projects\\PolitAktiv\\liferay-portal-6.2-ce-ga2
app.server.tomcat.lib.global.dir = D:\\projects\\PolitAktiv\\liferay-portal-6.2-ce-ga2\\tomcat-7.0.42\\lib\\ext
lp.version = 6.2.1
app.server.tomcat.deploy.dir = D:\\projects\\PolitAktiv\\liferay-portal-6.2-ce-ga2\\tomcat-7.0.42\\webapps
app.server.tomcat.portal.dir = D:\\projects\\PolitAktiv\\liferay-portal-6.2-ce-ga2\\tomcat-7.0.42\\webapps\\ROOT

4.
Copy your portlet source or git clone it from git repository to your  <SDK_Folder>/portlets directory
5.
Go to the checkouted folder cd  <SDK_Folder>/portlets/politaktiv-map2-portlet
6 Run some of the ant task you wish. Example:
ant deploy will build portlet project and deploy it to the liferay portal (Max version for ant is apache-ant-1.9.x because it is last release that support java that is bundled with liferay 6.2 bundled pack)

For developming purposes you can install Liferay IDE. Url for IDE for this liferay 6.2 release it is
https://sourceforge.net/projects/lportal/files/Liferay%20IDE/2.1.1%20GA2/




