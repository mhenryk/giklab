# Laboratorium 3

## Lokalizacja i listy ##

### Zadanie 1 ###

Utworzyć nowy projekt, określić, w Manifeście, że aplikacja ma uprawnienia do lokalizacji gps (fine).

Poprosić użytkownika o uprawnienia do lokalizacji. (Android 6.0+)

### Zadanie 2 ###

W app/build.gradle dodać

dependencies {
	...
    implementation 'com.google.android.gms:play-services-location:11.8.0'
	...
}

Następnie, po otrzymaniu zgody użytkownika wyświetlić dwa TextView, w których bedą widoczne aktualne współrzędne. Dokonać pobrania lokalizacji.

Po skutecznym pobraniu lokalizacji zmienić kod tak aby otrzymywać lokalizację w regularnych interwałach, np. 30s.

### Zadanie 3 ###

Pod współrzędnymi wyświetlić listę (RecyclerView), i w niej wyświetlić historię współrzędnych. Każdy pomiar opatrzyć timestampem pochodzącym z System.currentTimeMillis()

## Literatura ##

[https://developer.android.com/training/location/index.html](https://developer.android.com/training/location/index.html)

[ https://developer.android.com/guide/topics/ui/layout/recyclerview.html]( https://developer.android.com/guide/topics/ui/layout/recyclerview.html)
