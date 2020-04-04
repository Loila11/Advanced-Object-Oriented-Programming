# Exercitii

Lab1:
1. Scrieți un program care să afișeze toate numerele pare din intervalul [0,n], unde n este un număr citit de la tastatură.
2. Scrieți un program care să compare două numere a și b citite de la tastatură și să afișeze numărul mai mare.
3. Fiind dat un număr n citit de la tastatură, să se afișeze toți divizorii săi.
4. Scrieți o metoda care să calculeze factorialul unui număr n citit de la tastatură.
5. Scrieți un program care să întoarcă true dacă un număr este prim, și fals în caz contrar.
6. Se citesc două numere a și b de la tastatură, să se afișeze valoarea a^b.
7. Să se afișeze al n-lea termen din seria Fibonacci, unde n este citit de la tastatură.

Lab2:
1. Scrieți o aplicație în Java care să vă permită să citiți de la tastatură n note, numere întregi într-un vector. Când utilizatorul citește de la tastatură valoarea -1, citirea notelor se oprește și programul afișează media notelor.
2. Scrieți o aplicație in Java care să citească n numere de la tastatură. Elementele citite de la tastatură vor fi organizate în doi vectori diferiți, în funcție de paritate (Ex. numerele impare vor fi puse într-un vector x, numerele pare intr-un vector y). Afișați care vector are mai multe elemente.
3. Scrieți o aplicație în Java care să declare un obiect (entitate din viața reală, alegerea voastră care) cu două atribute (de tipuri diferite) private. Implementați getteri/setteri, un constructor, și o metodă care să definească un comportament al entității (să afișați/ sau să incrementați un atribut).
4. Se citesc de la tastatură N linii de forma:\
Nume1 nota1\
...\
NumeN notaN.\
Declarați o clasă __Student__ cu atributele/constructorii/metodele necesare ca să mapați liniile citite de la tastatură. Stocați toți studenții într-un tablou. Afișați-l în fluxul de ieșire.

Lab4:
1. Scrieți un program care să verifice dacă două șiruri de caractere sunt anagrame.
2. Se citește de la tastatură un număr întreg n în intervalul [0, 100] și n șiruri de caractere. Creați un vector cu toate șirurile de caractere care sunt palindroame și afișați lungimea maximă a unui palindrom din vector.
3. Având la dispoziţie o imagine cu maxim 100 de linii şi coloane (numărul de coloane nu este neapărat egal cu cel al liniilor), să se realizeze un program ce permite conversia acesteia la o imagine binară, cu valori de 0 şi 1. Regula de conversie este aceea că orice valoare primă este convertită în 0 şi orice valoare care nu este primă, în 1. Imaginea obţinută va conţine ceea ce numim obiecte. Să se afişeze pe ecran dimensiunea obiectelor din imagine, aceasta fiind dată de numărul total de valori de 1 din imaginea binară.

Lab5:
1. Declarați o interfață __Task__ care conține o metodă: void execute(). Pe baza interfeței respective, o să implementați 3 clase: __RandomTask__, __RandomOutTask__ și __CounterOutTask__:
- pentru __RandomTask__ implementați un task care să afișeze un
mesaj în fluxul de ieșire. Inițializați mesajul în constructor.
- pentru __RandomOutTask__ implementați un task care generează un număr aleator și afișează un mesaj cu numărul generat la output. Generarea se va face în constructor.
- pentru __CounterOutTask__ implementați un task care incrementează un contor global și afișează valoarea contorului după fiecare incrementare.
2. Declarați o clasă __Album__ care are câmpurile: nume, anul publicării și rating.
- implementați metodele clasei: constructori, getteri, setteri.
- folosiți una din cele două interfețe de comparare (Comparable/Comparator) pentru a sorta o colecție de albume pe baza numelui și al ratingului.
- declarați-vă o clasă Main în care să creați o listă de albume și să afișați colecția înainte și după sortare.

Lab6:
1. Să se scrie un program care citeşte de la tastatură perechi de numere în care primul număr trebuie să fie mai mic decât al doilea. Dacă această condiţie nu este îndeplinită, folosind mecanismul excepţiilor, se va semnala eroare şi se va trata această eroare prin cererea unei alte perechi de numere. Toate perechile de numere care îndeplinesc condiţia vor fi scrise într-un fişier(_output.txt_).
2. Să se citească de la tastatură un user și o parolă. Acestea se vor compara cu înregistrările existente în fișierul _parole.txt_. Dacă user-ul și parola se regăsesc printre acestea (pe aceeași linie), se va afișa mesajul ”acces permis”. Dacă se regăsește doar userul, iar parola este greșită, se va afișa ”parola greșită” și se va mai cere introducerea parolei încă o dată, dar nu de mai mult de 3 ori. Dacă se atinge acest prag se va afișa mesajul ”cont blocat”. Altfel, se reia procesul de introducere a datelor, dar nu de mai mult de 5 ori. Dacă se atinge limita de 5 intrări se va afișa mesajul ”Nu ai cont. Inregistrează-te.”
3. Într-un fișier numit _clienți.txt_ sunt memorate date despre clienții unui magazin virtual. Pe fiecare linie se află numele, prenumele și vârsta clienților. Se cere să se afișeze numărul și lista clienților majori și numărul clienților minori.