//package beanmm.beanquiz;
package com.example.wojci.bean_sputnik; //musiałem zmienić nazwę pakietu żeby to pasowało do mojej paczki //SYROP

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;

//import beanm.beanquiz.QuizTableSchema.*;
import com.example.wojci.bean_sputnik.QuizTableSchema.*; // podmianka ściezki //SYROP

public class QuizDb extends SQLiteOpenHelper {

    private static final String DB_NAME="BeanQuiz.db";
    private static final int DB_VERSION=2;

    private SQLiteDatabase db;

    public QuizDb(@Nullable Context context) {
        super(context, DB_NAME,null,DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db=db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE IF NOT EXISTS " +
                QuestionTable.TABLE_NAME + " ( " +
                QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();

    }

    //wywolywane przy aktualizowaniu bazy danych
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+QuestionTable.TABLE_NAME);
        onCreate(db);
    }

    //Wypełnanie tabeli w bazie danych pytaniami do quizu (narazie sa to pytania do testowania)
    private void fillQuestionsTable(){
        Question q1=new Question("Na podstawie pełnionych funkcji neurony dzielimy na:","czuciowe, ruchowe i pośredniczące,","czuciowe, przewodzące i pośredniczące,","przewodzące, ruchowe i boczne,",1);
        addQuestion(q1);
        Question q2 = new Question("Homeostaza to zdolność organizmu do utrzymania stałych parametrów organizmu takich jak temperatura czy pH krwi, oraz ich regulacji. Za zachowanie homeostazy odpowiada układ nerwowy wraz z układem: ",
                "pokarmowym", "krwionośnym", "hormonalnym", 3);
        addQuestion(q2);
        Question q3 = new Question("Wśród komórek tkanki nerwowej wyróżniamy: ",
                "neurony i komórki glejowe", "neurony i erytrocyty", "komórki glejowe i leukocyty", 1);
        addQuestion(q3);
        Question q4 = new Question("Zasadniczymi elementami budowy komórki nerwowej są:",
                "jądro komórki, jąderko, błona komórkowa, dendryty i aksony", "mikrofibryle, jąderko, dendryty, osłonka mielinowa i wypustki czuciowe", "ciało komórki, jądro komórki, dendryty, aksony i osłonka mielinowa", 3);
        addQuestion(q4);
        Question q5 = new Question("Skrót OUN oznacza:",
                "Ogólnoustrojowy Układ Nerwowy", "Ośrodkowy Układ Nerwowy", "Ogólny Układ Nerwowy", 2);
        addQuestion(q5);
        Question q6 = new Question("Główną funkcją osłonki mielinowej jest:",
                "ochrona mechaniczna i ukrwienie komórki nerwowej", "ochrona mechaniczna i izolacja elektryczna", "ukrwienie komórki nerwowej i izolacja elektryczna", 2);
        addQuestion(q6);
        Question q7 = new Question("Ze względu na sposób przekazywania impulsu synapsy dzielimy na:",
                "chemiczne i elektryczne", "endogenne i egzogenne", "obojętne i bipolarne", 1);
        addQuestion(q7);
        Question q8 = new Question("Stan pobudzenia w komórkach nerwowych przekazywany jest w:",
                "obu kierunkach zależnie od rodzaju neuronu", "tylko w jednym kierunku: od organu czuciowego do rdzenia kręgowego i mózgu", "stan pobudzenia występuje jedynie w obrębie komórek, które wykonują ruch", 1);
        addQuestion(q8);
        Question q9 = new Question("Częstotliwość sygnału elektroencefalograficznego wynosi około:",
                "-60 ÷ 70 Hz", "0 ÷ 30 Hz", "0 ÷ 70 Hz", 3);
        addQuestion(q9);
        Question q10 = new Question("Wielkość mierzonego napięcia sygnału pobudzenia elektrycznego w mózgu wynosi:",
                "10÷100 μV", "0÷70 mV", "10÷100 mV", 1);
        addQuestion(q10);
        Question q11 = new Question("Skrót EEG oznacza:",
                "elektromiografia", "elektroendografia", "elektroencefalografia", 3);
        addQuestion(q11);
        Question q12 = new Question("Mózgowie kręgowców, w tym człowieka składa się z kilku połączonych ze sobą części osłonionych czaszką. Można do nich zaliczyć:",
                "kresomózgowie, międzymózgowie, bocznomózgowie, tyłomózgowie oraz rdzeń przedłużony", "kresomózgowie, płaty skroniowe, śródmózgowie, tyłomózgowie oraz rdzeń podłużny",
                "  kresomózgowie, międzymózgowie, śródmózgowie, tyłomózgowie oraz rdzeń przedłużony", 3);
        addQuestion(q12);
        Question q13 = new Question("Rdzeń kręgowy oraz mózgowie osłonięte są trzema błonami nazywanymi oponami. Ich nazwy pochodzą od pełnionych funkcji, stąd możemy wyróżnić:",
                "twardówka, pajęczynówka i opona miękka", "twardówka, pajęczynówka i tęczówka", "twardówka, pajęczynówka i naczyniówka", 1);
        addQuestion(q13);
        Question q14 = new Question("Na powierzchni kory mózgowej wyróżniamy fałdy pooddzielane bruzdami. Dzielą one korę mózgową każdej półkuli na cztery płaty. Zaliczamy do nich płaty:",
                "skroniowy, środkowy, czołowy i potyliczny", "skroniowy, ciemieniowy, czołowy i potyliczny", "przedni, ciemieniowy, czołowy i tylny", 2);
        addQuestion(q14);
        Question q15 = new Question("Rdzeń kręgowy znajduje się w kanale utworzonym przez kręgi. W jego budowie można wyodrębnić takie elementy jak:",
                "istota ciemna, istota biała, róg brzuszny, róg grzbietowy", "istota szara, istota biała, róg brzuszny, róg grzbietowy", "istota szara, istota biała, róg falisty, róg grzbietowy", 2);
        addQuestion(q15);
        Question q16 = new Question("Do odruchów bezwarunkowych (niezależnych od woli człowieka) nie zalicza się:",
                "odruchu wymiotnego", "wydzielania śliny na widok jedzenia", "reakcji źrenicy na zmiany oświetlenia", 2);
        addQuestion(q16);
        Question q17 = new Question("Urządzenie zbierające i analizujące sygnał pochodzący z aktywności bioelektrycznej mózgu to:",
                "elektrokardiograf", "elektromiograf", "elektroencefalograf", 3);
        addQuestion(q17);
        Question q18 = new Question("Podczas standardowego badania EEG rejestrowane są fale mózgowe, których nazwy są zależne od ich znaczenia i wielkości amplitudy sygnału. Nie istnieją jednak fale o nazwie:",
                "kappa", "lambda", "omega", 3);
        addQuestion(q18);
        Question q19 = new Question("Fale mózgowe theta bardzo często są oznaką oznaka senności i hiperwentylacji, występują również przy niektórych stanach patologicznych. Ich występowanie może również oznaczać:",
                "nieprzeciętną inteligencję", "głuchotę lub niedosłuch", "głupotę", 1);
        addQuestion(q19);
        Question q20 = new Question("Komórki zwierzęce otoczone są błoną komórkową, która jest selektywnie przepuszczalna dla niektórych związków lub cząsteczek. Oznacza to, że:",
                "przepuszcza wszystkie cząstki", "przepuszcza jedynie wybrane cząstki", "przepuszcza tylko małe cząstki", 2);
        addQuestion(q20);
        Question q21 = new Question("Depolaryzacja błony komórkowej oznacza:",
                "zmniejszenie wartości ładunku ujemnego na zewnątrz komórki", "zwiększenie wartości ładunku ujemnego wewnątrz komórki", "zmniejszenie wartości ładunku ujemnego wewnątrz komórki", 3);
        addQuestion(q21);
        Question q22 = new Question("Epilepsja to choroba, której objawami są rytmiczne, powtarzające się nagłe i krótkie wyładowania w obrębie neuronów, które są ograniczone do określonego obszaru kory mózgowej lub całej jej objętości. Choroba ta znana jest pod nazwą:",
                "choroba Parkinsona", "depresja", "padaczka", 3);
        addQuestion(q22);
        Question q23 = new Question("Choroba neurodegeneracyjna nie powodująca bezpośrednio śmierci pacjenta, lecz znacznie pogarszająca jego jakość życia, dotykająca głównie osoby starsze i objawiająca się głównie poprzez ślinotok, niestabilność postawy, sztywność mięśniową oraz pochylenie tułowia ku przodowi to:",
                "choroba Parkinsona", "choroba Alzheimera", "choroba Aspergera", 1);
        addQuestion(q23);
        Question q24 = new Question("Której przypadłości nie zalicza się to chorób neurodegeneracyjnych, czyli inaczej chorób układu nerwowego:",
                "miażdżycy", "choroby Alzheimera", "pląsawicy Huntingtona", 1);
        addQuestion(q24);
        Question q25 = new Question("Standardowe badanie EEG trwa co najmniej 30 minut i powinno zawierać około 20 minut zapisu bez artefaktów. Artefakty to inaczej:",
                "oznaczenia rejestrowanych fal mózgowych", "oznaczenia miejsc specyficznych podczas występowania danej choroby", "zakłócenia pomiarowe pochodzące m. in. od pacjenta i aparatury pomiarowej", 3);
        addQuestion(q25);
        Question q26 = new Question("Wyróżniamy cztery podstawowe elementy, które sprawiają, że chód charakteryzuje się poprawnością:",
                "równowaga, kontrola układu nerwowego, stały rytm, ruch", "równowaga, ruch, integralność układu mięśniowo-szkieletowego, kontrola układu nerwowego", "równowaga, spionizowana pozycja, kontrola układu nerwowego, stały rytm", 2);
        addQuestion(q26);
        Question q27 = new Question("Wysklepienie stopy amortyzuje podczas chodu, gdy nie ma łuku (płaskostopie) obciążamy:",
                "staw łokciowy, staw biodrowy, kręgosłup", "staw kolanowy, staw biodrowy, kręgosłup", "staw kolanowy, staw biodrowy, mostek", 2);
        addQuestion(q27);
        Question q28 = new Question("Kończyny dolne przenoszą:",
                "prawie 60% masy ciała", "prawie 80% masy ciała", "prawie 70% masy ciała", 3);
        addQuestion(q28);
        Question q29 = new Question("Wpływ na statykę ciała w czasie chodu mają:",
                "pozycja ciała, masa ciała, siła antygrawitacyjna mięśni", "pozycja ciała, wzrost, masa ciała", "wzrost, masa ciała, siła antygrawitacyjna mięśni", 1);
        addQuestion(q29);
        Question q30 = new Question("Środek ciężkości znajduje się:",
                "33cm powyżej stawu biodrowego, blisko kręgosłupa (jeśli ktoś jest otyły, to środek ciężkości przesuwa się do przodu)", "33cm powyżej stawu biodrowego, blisko kręgosłupa (jeśli ktoś jest otyły, to środek ciężkości przesuwa się do tyłu)", "na wysokości końca dalszego mostka, blisko kręgosłupa", 1);
        addQuestion(q30);
        Question q31 = new Question("Wyróżnia się trzy fazy chodu, trwają one określoną długość cyklu chodu (dwa kroki):",
                "podporu 49%, przenoszenia 50%, podwójnego podparcia 1%", "podporu około 60%, przenoszenia około 40%, podwójnego podparcia około 1%", "podporu 69%, przenoszenia 30%, podwójnego podparcia 1%", 2);
        addQuestion(q31);
        Question q32 = new Question("Wyróżniamy trzy fazy chodu, jedną z nich jest faza przenoszenia, która rozpoczyna się w momencie oderwania palucha od podłoża, a kończy w chwili zetknięcia pięty tej samej kończyny z podłożem. Składa się ona z trzech podfaz w kolejności:",
                "przyspieszenie, przenoszenie właściwe, hamowanie",
                "przyspieszenie, hamowanie, przenoszenie właściwe",
                "przenoszenie właściwe, przyspieszenie, hamowanie", 1);
        addQuestion(q32);
        Question q33 = new Question("Ze względu na budowę tkanki mięśniowej wyróżniamy trzy rodzaje mięśni, nie istnieją mięśnie:",
                "gładkie",
                "mięsień sercowy",
                "prążkowane", 3);
        addQuestion(q33);
        Question q34 = new Question("Mięśnie wykorzystują energię z różnych źródeł w zależności od czasu trwania wysiłku:",
                "kilka sekund - fosfokreatyna, do 60 minut - glukoza, powyżej 60 minut - kwas tłuszczowy",
                "kilka sekund - fosfokreatyna, do 30 minut - kwas tłuszczowy, powyżej 30 minut glukoza",
                "kilka sekund - glukoza, do 30 minut - fosfokreatyna, powyżej 30 minut - kwas tłuszczowy", 1);
        addQuestion(q34);
        Question q35 = new Question("Włóknami nerwowymi przenoszone są bodźce z układu nerwowego do mięśnia. Bodziec elektryczny przenoszony przez włókna nerwowe jest:",
                "krótkotrwały, asynchroniczny, o dużej częstotliwości (do 50Hz)",
                "krótkotrwały, synchroniczny, o częstotliwości do 30Hz",
                "krótkotrwały, synchroniczny, o dużej częstotliwości (do 50Hz)", 1);
        addQuestion(q35);
        Question q36 = new Question("Mięśnie szkieletowe stanowią około:",
                "30-40% ciężaru ciała osobnika dorosłego",
                "40-50% ciężaru ciała osobnika dorosłego",
                "55-40% ciężaru ciała osobnika dorosłego", 2);
        addQuestion(q36);
        Question q37 = new Question("Jaka kara pozbawienia wolności grozi za jazdę w stanie nietrzeźwości?",
                "kara pozbawienia wolności do 2 lat",
                "kara pozbawienia wolności do 1 roku",
                "do więzienia idzie się tylko w przypadku spowodowania kolizji lub wypadku", 1);
        addQuestion(q37);
        Question q38 = new Question("Stan po użyciu alkoholu zaczyna się od:",
                "od 0,1 mg/l w wydychanym powietrzu",
                "od 0,2 promila alkoholu we krwi",
                "odpowiedzi a i b są prawidłowe", 3);
        addQuestion(q38);
        Question q39 = new Question("Ile kosztuje pobyt we WrOPON (Izba Wytrzeźwień ul. Sokolnicza we Wrocławiu):",
                "99,98 zł",
                "199,98 zł",
                "299,98 zł", 3);
        addQuestion(q39);
        Question q40 = new Question("Alkoholizm to:",
                "picie alkoholu",
                "choroba alkoholowa, uzależnienie od alkoholu",
                "utrata kontroli nad ilością spożywanego alkoholu", 2);
        addQuestion(q40);
        Question q41 = new Question("Dopuszczalna zawartość alkoholu we krwi w Austrii, Chorwacji, Belgii, Danii, Francji, Grecji to",
                "tak jak w Polsce - 0,2 promila",
                "0,1 promila",
                "0,5 promila", 3);
        addQuestion(q41);
        Question q42 = new Question("Jakie są inne konsekwencje prawne związane z prowadzeniem pojazdu w stanie nietrzeźwości:",
                "odpowiedzi b i c są poprawne",
                "zatrzymanie prawa jazdy",
                "10 punktów karnych", 1);
        addQuestion(q42);
        Question q43 = new Question("Za spożywanie alkoholu w miejscach objętych zakazem grozi mandat karny w wysokości:",
                "100 zł",
                "200 zł",
                "50 zł", 1);
        addQuestion(q43);
        Question q44 = new Question("Poczęstowanie alkoholem 17-latka to przestępstwo za które grozi:",
                "tylko kara grzywny",
                "więzienie do 2 lat",
                "można dostać tylko wyrok w zawieszeniu", 2);
        addQuestion(q44);
        Question q45 = new Question("Leczenie odwykowe osób uzależnionych od alkoholu jest:",
                "dobrowolne",
                "przymusowe, kieruje sąd",
                "przymusowe, kieruje lekarz orzecznik", 1);
        addQuestion(q45);
    }

    //dodawanie pytan do bazy danych
    private void addQuestion(Question question){
        ContentValues cv=new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuestionTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionTable.TABLE_NAME, null, cv);
    }

    public ArrayList<Question> getAllQuestions(){
        ArrayList<Question> questionList=new ArrayList<>();
        db=getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM "+QuestionTable.TABLE_NAME,null);

        if(c.moveToFirst()){
            do{
                Question question=new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            }while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}
