package examinateur;

import java.util.ArrayList;

public class Initialize {

    public static void run() {

        ArrayList<Exercise> questions = new ArrayList<>();
        questions.add(new Exercise("Over welke poort worden https-websites geladen?", new Answer("443")));
        questions.add(new Exercise("Welke is GEEN naam van malware?", new Answer("Achilles")));
        questions.add(new Exercise("Hoe heet het programma waarmee de CIA smart-tv’s afluisterde?", new Answer("Ransomware")));
        questions.add(new Exercise("Welke computer worm verspreidde zich het snelst?", new Answer("MyDoom")));
        questions.add(new Exercise("welke vraag is dit?", new Answer("5")));

        Exam exam = new Exam(questions, "Cyber-Security");
        ApplicationManager.exams.add(exam);

        questions = new ArrayList<>();
        questions.add(new Exercise("Geef de reactievergelijking van de volledige verbranding van PEO.\n" +
                "De formule van PEO is (CH2CH2O)n.", new Answer("4n CO2 + 4n H2O")));
        questions.add(new Exercise("Waar staat Ne voor?", new Answer("Neon")));
        questions.add(new Exercise("Hoe heet het tabel met alle elementen?", new Answer("periodiek systeem")));
        questions.add(new Exercise("Wie is de leukste scheikunde docent?", new Answer("Vashy")));
        questions.add(new Exercise("Waar staat Sk voor?", new Answer("Scheikunde")));

        exam = new Exam(questions, "Scheikunde");
        ApplicationManager.exams.add(exam);

        questions = new ArrayList<>();
        questions.add(new Exercise("Wie is de grondlegger van karate?", new Answer("Funakoshi Gichin")));
        questions.add(new Exercise("Wat betekend karate?", new Answer("Lege hand")));
        questions.add(new Exercise("Welke karate stijl is het meest praktisch?", new Answer("Wado")));
        questions.add(new Exercise("Waar komt muay thai vandaan?", new Answer("Thailand")));
        questions.add(new Exercise("Waar kwam muay thai uit voort?", new Answer("krabi krabong")));

        exam = new Exam(questions, "Martial arts");
        ApplicationManager.exams.add(exam);

        questions = new ArrayList<>();
        questions.add(new Exercise("Wat is de beste anime?", new Answer("Naruto")));
        questions.add(new Exercise("Wie is de meest sophisticated Naruto character?", new Answer("Itachi")));
        questions.add(new Exercise("Hoe heette de groep met rogue ninjas?", new Answer("Akatsuki")));
        questions.add(new Exercise("Hoe heette het zwaard van Kisame?", new Answer("Samehada")));
        questions.add(new Exercise("Best waifu?", new Answer("Hyuuga Hanabi")));

        exam = new Exam(questions, "Anime");
        ApplicationManager.exams.add(exam);

        Main.isRunning = true;
    }
}
