# Laboratorium 1

W ramach laboratorium zajmować będziemy się tworzeniem aplikacji na urządzenia mobilne a konkretniej na platformę Android.

### Instalacja środowiska ###
Android Studio - https://dl.google.com/dl/android/studio/ide-zips/3.0.1.0/android-studio-ide-171.4443003-windows.zip
Po pobraniu uruchomić i zacząć pobieranie SDK.

### Emulator ###

Osoby posiadające własny telefon + kabelek do niego moga pominąć ten krok.

Należy wybrać z menu Tools -> Android -> AVD Manager 

I kolejno:
Create Virtual Device -> Phone -> Nexus 5
Other Images -> Nougat API 25, ABI arm64-v8a, Target 7.1.1(Google APIs)

### Fizyczne urządzenie ###
Dla osób z własnym telefonem.
Należy włączyć opcje deweloperskie. Instrukcja znajduje się tutaj: [https://developer.android.com/studio/debug/dev-options.html](https://developer.android.com/studio/debug/dev-options.html)

## Hello World ##

Tworzenie nowego projektu:
Należy utworzyć nowy projekt typu Android Application, przy wyborze Activity należy wybrać Empty activity.
Po utworzeniu projektu skopiować zawartość folderu "res" z tego repozytorium do folderu w projekcie o ścieżce:
**app/src/main/**

### Uruchomienie ###
Aplikację uruchamia się przyciskiem "Run" (zielona strzałka) w górnym menu.

### Zadanie 1 ###
Ustawić Toolbar jako ActionBar, ustawić mu jakiś tytuł z poziomu kodu.
Na wciśnięcie przycisku otworzyć Google Maps (aplikacja, jeśli dostępna, jeśli nie to przeglądarka z odpowiednim adresem) ze wskazanymi współrzędnymi uzupełnionymi w 

### Zadanie 2 ###
Zamienić layout na activity\_main2 i dodać Fragment, korzystający z layoutu fragment\_content. Upewnić się, że to działa, ustawić jakiś tytuł Toolbara z poziomu Fragmentu.

### Zadanie 3 ###
Przy starcie aplikacji dodać zapytanie do systemu o uzyskanie uprawnień do lokalizacji (tylko uprawnienia, bez pobierania lokalizacji).

### Zadanie 4 ###
Utworzyć menu, umieścić tam jakiś przycisk, poeksperymentować z jego widocznością, jego wcisnięcie wykonuje akcję share z współrzędnymi wpisanymi w tekst

### Zadanie 5 ###
Wciśnięcie back w aplikacji otwiera okno dialogowe pytające użytkownika czy chce opuścić aplikację.

## Kolejne laboratorium ##
W kolejnym laboratorium będziemy operować na layoutach i będziemy kontynuować aplikację, która powstała na 1wszych zajęciach.

# Uwaga #
Ze względu na przebiegającą modernizację laboratorium proszę zabezpieczyć wyniki swojej pracy.

# Literatura #
[https://developer.android.com/training/index.html](https://developer.android.com/training/index.html)

[https://developer.android.com/reference/packages.html](https://developer.android.com/reference/packages.html)

[https://developer.android.com/guide/index.html](https://developer.android.com/guide/index.html)
