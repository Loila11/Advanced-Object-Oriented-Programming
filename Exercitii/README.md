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
4. Se citesc de la tastatură N linii de forma:
Nume1 nota1
...
NumeN notaN.
Declarați o clasă 'Student' cu atributele/constructorii/metodele necesare ca să mapați liniile citite de la tastatură. Stocați toți studenții într-un tablou. Afișați-l în fluxul de ieșire.

Lab4:
1. Scrieți un program care să verifice dacă două șiruri de caractere sunt anagrame.
2. Se citește de la tastatură un număr întreg n în intervalul [0,100] și n șiruri de caractere. Creați un vector cu toate șirurile de caractere care sunt palindroame și afișați lungimea maximă a unui palindrom din vector.
3. Având la dispoziţie o imagine cu maxim 100 de linii şi coloane (numărul de coloane nu este neapărat egal cu cel al liniilor), să se realizeze un program ce permite conversia acesteia la o imagine binară, cu valori de 0 şi 1. Regula de conversie este aceea că orice valoare primă este convertită în 0 şi orice valoare care nu este primă, în 1. Imaginea obţinută va conţine ceea ce numim obiecte. Să se afişeze pe ecran dimensiunea obiectelor din imagine, aceasta fiind dată de numărul total de valori de 1 din imaginea binară.

Lab5:
1. Declarați o interfață Task care conține o metodă execute(), tipul returnat al metodei este void. Pe baza interfeței respective, o să implementați 3 clase: RandomTask, RandomOutTask și CounterOutTask:
- pentru RandomTask implementați un task care să afișeze un
mesaj în fluxul de ieșire. Inițializați mesajul în constructor.
- pentru RandomOutTask implementați un task care generează un număr aleator și afișează un mesaj cu numărul generat la output. Generarea se va face în constructor.
- pentru CounterOutTask implementați un task care incrementează un contor global și afișează valoarea contorului după fiecare incrementare.
2. Declarați o clasă Album care are câmpurile: nume, anul publicării și rating.
- implementați metodele clasei: constructori, getteri, setteri.
- folosiți una din cele două interfețe de comparare (Comparable/Comparator) pentru a sorta o colecție de albume pe baza numelui și al ratingului.
- declarați-vă o clasă Main în care să creați o listă de albume și să afișați colecția înainte și după sortare.