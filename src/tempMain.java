import DesignPatterns.AdapterPattern.CollegeStudent;
import DesignPatterns.AdapterPattern.LegacySchoolStudent;
import DesignPatterns.AdapterPattern.SchoolStudentAdapter;
import DesignPatterns.AdapterPattern.Student;
import DesignPatterns.BuilderPattern.Computer;
import DesignPatterns.ChainOfResponsibility.CardProvider;
import DesignPatterns.ChainOfResponsibility.CashProvider;
import DesignPatterns.ChainOfResponsibility.PayPalProvider;
import DesignPatterns.ChainOfResponsibility.PaymentProvider;
import DesignPatterns.FactoryPattern.Document;
import DesignPatterns.FactoryPattern.IDocument;
import DesignPatterns.Games.SnakeLadder.Game;
import DesignPatterns.Games.SnakeLadder.Ladder;
import DesignPatterns.Games.SnakeLadder.Player;
import DesignPatterns.Games.SnakeLadder.Snake;
import DesignPatterns.SingeltonPattern.RandomRecord;
import DesignPatterns.SingeltonPattern.RecordKeeper;

import java.util.ArrayList;
import java.util.List;

public class tempMain {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // ---------------- BUILDER PATTERN ------------------ //
        Computer computer =
                new Computer.ComputerBuilder()
                        .ram("DDR4").ssd("NVIDIA")
                        .bluetoothEnabled(true)
                        .graphicCard(true).build();

        // ---------------- ADAPTER PATTERN ----------------- //
        Student student = new CollegeStudent("Vagish Yagnik", "B", "3", 1);
        List<String> updatedName = new ArrayList<>();
        updatedName.add("Vagish");
        updatedName.add("Shanker");
        updatedName.add("Yagnik");
        Student schoolStudent = new SchoolStudentAdapter(new LegacySchoolStudent(updatedName, "XII", "A", "vagishyagnik@gmail.com"));

        // ----------------- FACTORY PATTERN ----------------- //
        List<Document> documents = new ArrayList<>();
        documents.add(Document.WORD);
        documents.add(Document.GOOGLE);
        documents.add(Document.WORD);
        List<IDocument> documentInstances = documents.stream().map(t -> t.getInstance("random-title")).toList();

        // ---------------- SINGELTON PATTERN -------- //
        RecordKeeper rk = RandomRecord.getInstance();
        // ---------------- FACADE PATTERN ------------ //
        // Creating a helper class to remove complex logic from client layer is called facade
        // --------------- CHAIN OF RESPONSIBILITY ----- //
        // Just like in AWS region provider or credentials provider chain
        PaymentProvider providerChain = new CashProvider();
        providerChain
                .setNext(new CardProvider())
                .setNext(new PayPalProvider());

        // --------------- DECORATOR -------------------
        /*Procedure:
            Create an interface.
            Create concrete classes implementing the same interface.
            Create an abstract decorator class implementing the above same interface.
            Create a concrete decorator class extending the above abstract decorator class.
            Now use the concrete decorator class created above to decorate interface objects.
            Lastly, verify the output
            Like a Pizza class & a decorator interface now some decorators like cheese burst decorator jalapeno decorator takes pizza as input & decorates them by performing some common function
         */
        // ---------------- SNAKE & LADDER GAME ------------- //
        Game snakeLadder = new Game.GameBuilder()
                .addPlayer(new Player("Vagish"))
                .addPlayer(new Player("Varun"))
                .addLadder(new Ladder(3,80))
                .addLadder(new Ladder(4, 81))
                .addLadder(new Ladder(5, 82))
                .addLadder(new Ladder(6, 83))
                .addSnake(new Snake(7, 1))
                .addSnake(new Snake(12, 3))
                .build();

        snakeLadder
                .playNext().playNext()
                .playNext().playNext()
                .playNext().playNext()
                .playNext().playNext()
                .playNext().playNext()
                .playNext().playNext();

        /* --------------- SINGLE RESPONSIBILITY PRINCIPLE ----------------
         * If the code request changes from one business entity or stakeholders then it is fine
         * but if more than that then we have tried to integrate 2 different use cases into 1 class
        */

        /* ----------------- OPEN CLOSED PRINCIPLE ------------------------
        * The Open-Closed Principle requires that classes should be open for extension and closed to modification.
        * Example - theirs a single responsibility class named account, now a person has a saving account + a current account,
        * Now the basic common details of these accounts (like rate of interest) should be kept separately in a class created out of a common interface
        * */

        /* --------------- LISKOV Substitution Principle ----------------
         * To tell how to inherit properly
         * what we want is to have the objects of our subclasses behaving the same way as the objects of our superclass.
         * Example - Square vs Rectangle -> Will you inherit the Rectangle class inside the Square class?
         * Your ClientMethod() expects a Rectangle and asserts a value of the area. All was well up to this point but now
         * when we do rec.setHeight(4), our Square will set both its sides as 4, and that will totally mess up the assert statement.
         * We were expecting a Rectangle of sides 5 and 4 to have an area of 20 but we got a Square with sides 4 and 4 and area 16.
         */

        /* ----------------- INTERFACE SEGREGATION PRINCIPLE ------------
         * many client-specific interfaces are better than one general-purpose interface. Clients should not be forced to implement a function they do no need.
         * Example - ATM Machine, Cash Deposit Machine, Cheque Deposit Machine, Passbook printing -> A class becomes fat if it implements functions that it may or may not use
         * so to remove unused function interfaces need to be made light.
         */

        /* ------------------- DEPENDENCY INVERSION PRINCIPLE -------------
        * The Dependency Inversion principle states that our classes should depend upon interfaces or abstract classes
        * instead of concrete classes and functions.
        * Simple example is a cache store, cachestore is a common interface for n number of different cache technology
        * RedisCacheService implements CacheStore, MemCacheService implements CacheStore -> CacheStore store = new RedisCacheService();
        * */


    }
}