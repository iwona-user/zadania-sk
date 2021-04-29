# git-zadanie-sketch
W swoim repozytorium przygotuj plik sprawozdanie.md ze sprawozdaniem z rozwiązania zadań. Miej na uwadze format plików md https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet. 
Rozwiązanie powinno zawierać użyte komendy i ich wyjście. Warto używać git basha, cmdera, bo kopiowanie z windows cmd jest uciążliwe.
Używanie graficznych pomocy jest zabronione (nie uzywamy intellij, source tree, gitlab page i innych) chyba, że w zadaniu powiedziano inaczej.
Kiedy piszę gitlab mam na myśli de-devopshrtoolstag:8080/gitlab

Zadanie -1 - przejść kurs na [https://learngitbranching.js.org/](https://learngitbranching.js.org/)

Zadanie 0 - zmień remote na swoje
* [ ] Sklonuj moje repozytorium
* [ ] Zmień użytkownika w remote url na swojego
* [ ] Wypchnij do gitlaba (powinno powstać nowe prywatne repo)
* [ ] Dodaj trenera (należ użyć gitlaba, w gitlabie dodać swojego trenera do nowego repo z dostępem maintainer)

Zadanie 1 - praca na repozytorium
* [ ] Znaleźć jakiej zależności brakuje - uzupełnić to w pomie 
* [ ] Domergować branche JanKowalski i AdamNowak do mastera 
* [ ] Do projektu dodać .gitignore (chodzi o pliki związane z intellij)
* [ ] Dodać nowego brancha z Twoimi danymi i stworzyć do niego poprawny pull request (trzeba użyć strony gitlab)
* [ ] Praca oczekująca
  * [ ] Stworzyć nowego brancha test
  * [ ] Dodać do poma sekcje developers z wpisem developer i twoim imieniem i nazwiskiem
  * [ ] Zakomitować plik
  * [ ] Wrócić na mastera zmienić wersje patch poma o jeden w górę
  * [ ] Zmienić brancha spowrotem na test. Jakie pojawiły się problemy jak można je rozwiązać? Opisz dwa sposoby.
* [ ] opisać jaka jest różnica między git checkout HEAD~3 i git reset --hard HEAD~3
* [ ] Różnica między revert i reset
  * [ ] Opisać ją
  * [ ] Przetestować do sprawozdania dodać komendy z opisami
* [ ] Sprzątanie śmieci
  * [ ] Stworzyć plik test 
  * [ ] Uruchomić komendę git clean -n przeanalizować co stało by się gdby nie było -n
  * [ ] git remote prune -n origin przeanalizować co stało by się gdby nie było -n 
  * [ ] Jak usunąc nie używanego brancha
* [ ] Cherry pick
  * [ ] Stworzyć brancha cherry-pick-test 
  * [ ] Na którym dodamy wykrzykinik do Hello World
  * [ ] Zamiast wykonywać merga zmiany na mastera przenieść za pomocą komendy cherry-pick
  * [ ] Co robi opcja --nocommit

Zadanie 2 - Maven
* [ ] Stworzyć projekt w mvn od podstaw
  * [ ] Który będzi można uruchomić z mavena
  * [ ] Który za pomocą biblioteki zewnętrznej biblioteki (okhttp, google.http-client) wykona zapytanie do https://breaking-bad-quotes.herokuapp.com/v1/quotes
  * [ ] I wypisze cytat i autora na konsolę
  * [ ] Który wygeneruje jara z zależnościami (tak, żeby możliwe było odpalenie go java -jar plik.jar)

Zadanie 3* - przeszukiwanie istniejących repozytoriów i bash
* [ ] Sklonuj repozytorium https://github.com/git/git
* [ ] Przygotuj posortowaną listę autorów, bez powtórzeń, którzy mieli udział w powstaniu brancha main (przydatne komendy uniq sort https://git-scm.com/docs/git-log) 
* [ ] Czyje zmiany są w tej chwili w pliku README (autorzy obecnej wersji); --porcelain, grep 
