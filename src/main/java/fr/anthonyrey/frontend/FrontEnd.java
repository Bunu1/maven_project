package fr.anthonyrey.frontend;

import fr.anthonyrey.business.exceptions.BusinessException;
import fr.anthonyrey.business.service.DirectoryService;
import fr.anthonyrey.model.Person;
import fr.anthonyrey.model.PersonQuery;

import java.util.Scanner;
import java.util.logging.Logger;

public class FrontEnd {

    private static final String CHOICE_1 = "1";
    private static final String CHOICE_2 = "2";
    private static final String CHOICE_3 = "3";
    private static final String UNK_COMMAND = "Commande inconnue";

    private DirectoryService directoryService;
    private Scanner reader = new Scanner(System.in);
    private boolean running = true;

    private static Logger logger = Logger.getLogger("InfoLogging");

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

        logger.info("Entrez la commande désirée : \n" +
                "1) Ajouter une personne à l'annuaire\n" +
                "2) Rechercher une personne\n" +
                "3) Quitter");

        try {
            String prompt = getString();
            if(prompt == null) { throw new NullPointerException(); }
            switch (prompt) {
                case CHOICE_1:
                    addPerson();
                    break;
                case CHOICE_2:
                    getPerson();
                    break;
                case CHOICE_3:
                    logger.info("bye have a great time");
                    running = false;
                    break;
                default:
                    logger.info(UNK_COMMAND);
                    break;
            }
        } catch (NullPointerException e ) {
            logger.info("prompt est null");
        }
    }

    private String getString(){

        String name;
        name = reader.nextLine();

        //pour que sonar trouve des trucs nazes
        // il a rien trouvé
        if(name.isEmpty()) {
            return null;
        }

        return name;
    }

    private void getPerson() {

        logger.info("Entrez les valeurs à rechercher :");
        logger.info("Nom ?");
        String name = getString();
        logger.info("Prenom ?");
        String surname = getString();
        logger.info("Numéro ?");
        String phoneNumber = getString();

        PersonQuery p = new PersonQuery(name, surname, phoneNumber);
        logger.info(directoryService.getPersons(p));
    }

    private void addPerson() {

        logger.info("Entrez une personne dans l'annuaire :");
        logger.info("Nom ?");
        String name = getString();
        logger.info("Prenom ?");
        String surname = getString();
        logger.info("Numéro ?");
        String phoneNumber = getString();

        Person p = new Person(name, surname, phoneNumber);

        try {
            directoryService.createEntry(p);
        } catch (BusinessException e) {
            logger.info(e.getMessage());
        }
    }
}