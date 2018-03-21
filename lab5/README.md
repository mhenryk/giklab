# Laboratorium 5

## Zadanie 1 ##

Na podstawie poprzedniego laboratorium z mapami, ustawić kamerę na zatokę gdańską.
Dodać do projektu plik GeoServerUrlTileProvider z repozytorium i dodać jako źródło kafelków.

Tworzenie providera:
new GeoServerUrlTileProvider("http://vps526645.ovh.net:8145/geoserver/gwc/service/",
                        "gik",
                        "S2A_20170829T152942_T34UCF_CHL_OC3",
                        256, 256)))