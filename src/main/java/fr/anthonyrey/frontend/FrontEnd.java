package fr.anthonyrey.frontend;

import fr.anthonyrey.business.exceptions.BusinessException;
import fr.anthonyrey.business.service.DirectoryService;
import fr.anthonyrey.model.Person;
import fr.anthonyrey.model.PersonQuery;

import java.util.Scanner;

public class FrontEnd {

    private static final String CHOICE_1 = "1";
    private static final String CHOICE_2 = "2";
    private static final String CHOICE_3 = "3";
    private static final String UNK_COMMAND = "Commande inconnue";

    private DirectoryService directoryService;
    private Scanner reader = new Scanner(System.in);
    private boolean running = true;

    public static void main( String[] args )
    {
        FrontEnd frontEnd = new FrontEnd();
        frontEnd.start();
    }

    private void start() {

        directoryService = new DirectoryService();

        while(running) {
            whatToDo();
        }

        //sonar ne semble pas voir ça ? :D
        //il l'a vu
    }

    private void whatToDo() {

        System.err.println("Entrez la commande désirée : \n" +
                "1) Ajouter une personne à l'annuaire\n" +
                "2) Rechercher une personne\n" +
                "3) Quitter");

        String prompt = getString();

        switch (prompt) {
            case CHOICE_1:
                addPerson();
                break;
            case CHOICE_2:
                getPerson();
                break;
            case CHOICE_3:
                running = false;
                break;
            default:
                System.err.println(UNK_COMMAND);
                break;
        }
    }

    private String getString(){

        String name;
        name = reader.nextLine();

        //pour que sonar trouve des trucs nazes
        if(name.isEmpty()) {
            return null;
        }

        return name;
    }

    private void getPerson() {

        System.err.println("Entrez les valeurs à rechercher :");
        System.err.println("Nom ?");
        String name = getString();
        System.err.println("Prenom ?");
        String surname = getString();
        System.err.println("Numéro ?");
        String phoneNumber = getString();

        PersonQuery p = new PersonQuery(name, surname, phoneNumber);
        System.err.println(directoryService.getPersons(p));
    }

    private void addPerson() {

        System.err.println("Entrez une personne dans l'annuaire :");
        System.err.println("Nom ?");
        String name = getString();
        System.err.println("Prenom ?");
        String surname = getString();
        System.err.println("Numéro ?");
        String phoneNumber = getString();

        Person p = new Person(name, surname, phoneNumber);

        try {
            directoryService.createEntry(p);
        } catch (BusinessException e) {
            System.err.println(e.getMessage());
        }
    }
}
