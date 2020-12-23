# PolitAktiv Map Portlet
This portlet for Liferay based on [Leaflet](http://leafletjs.com), OpenStreet map and [Leaflet.Draw](https://github.com/Leaflet/Leaflet.draw) plugin.

Guest user can observe all markers without possibility to add or update them.
Signed in User can add and update markers. User's markers colored with red and displayed under Your marker's panel. 


Configuration:
	Map center longtitude, latitude and zoom level can be configured from portlet's configuration page. After updating values page should be refreshed.

This portlet version version is tested with Liferay Community Edition Portal 7.3.5 CE GA6
(Athanasius / Build 7305 / September 22, 2020).

You need to import it via Developer studio with option:
File->Import..-> Liferay Project with Plugins SDK (Legacy)

In Servers Tab select New Server and Chose Liferay 7.x and configure path to your new downloaded and unziped version of Liferay
In my case it is: /home/aleksandar/projects/PolitAktiv/liferay-ce-portal-7.3.5-ga6





