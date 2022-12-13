import java.util.*;
public class Menu {
    public static void main(String[] args) {
        // Oprettelse af lister og attributter til senere brug
        ArrayList<Discipline> swimDisciplines = new ArrayList<>();
        Discipline crawl200m = new Discipline(200, "Crawl");
        Discipline backstroke200m = new Discipline(200, "Backstroke");
        swimDisciplines.add(crawl200m);
        swimDisciplines.add(backstroke200m);
        ArrayList<Member> memList = new ArrayList<>();
        ArrayList<Member> u18 = new ArrayList<>();
        ArrayList<Member> o18 = new ArrayList<>();
        ArrayList<SwimResult> u18TrainList = new ArrayList<>();
        ArrayList<SwimResult> u18CompList = new ArrayList<>();
        ArrayList<SwimResult> o18CompList = new ArrayList<>();
        ArrayList<SwimResult> o18TrainList = new ArrayList<>();
        boolean sentinel = true;
        int userChoice = -1;
        String stringInput;
        Scanner input = new Scanner(System.in);

        while (sentinel) { // While sentinel - så koden bliver ved med at køre indtil vælger exit.
            System.out.println("Valgmuligheder:");
            System.out.println("1. Opret nyt medlem.");
            System.out.println("2. Vis/Rediger medlemsinformation.");
            System.out.println("3. Vis restance.");
            System.out.println("4. Indtast traeningsdata.");
            System.out.println("5. Indtast staevnedata.");
            System.out.println("6. Vis top 5 resultater.");
            System.out.println("0. Exit");
            while (!input.hasNextInt()) { //Input fejlsikring
                System.out.println("Forkert input, proev igen:");
                input.nextLine();
            }
            int choice = input.nextInt();
            switch (choice) {
                case 1: //Oprettelse af medlem case
                    System.out.println("1. Opret motionist medlem");
                    System.out.println("2. Opret konkurrence medlem");
                    boolean incorrectInput = true;
                    while (incorrectInput) {
                        if (input.hasNextInt()) {
                            userChoice = input.nextInt();
                            if (userChoice < 1 || userChoice > 2) {
                                System.out.println("Proev igen. Dit heltal skal vaere 1 eller 2");
                                input.nextLine();
                            } else {
                                incorrectInput = false;
                            }
                        } else {
                            System.out.println("Proev igen, input var ikke et heltal");
                            input.nextLine();
                        }
                    }
                    int choice2 = userChoice;
                    if (choice2 == 1) {
                        System.out.println("Medlemsnavn:");
                        stringInput = input.next();

                        System.out.println("Medlems alder:");
                        incorrectInput = true;
                        while (incorrectInput) {
                            if (input.hasNextInt()) {
                                userChoice = input.nextInt();
                                if (userChoice < 1) {
                                    System.out.println("Proev igen. Dit heltal skal vaere 1 eller over");
                                    input.nextLine();
                                } else {
                                    incorrectInput = false;
                                }
                            } else {
                                System.out.println("Proev igen, input var ikke et heltal");
                                input.nextLine();
                            }
                        }
                        int memAge = userChoice;

                        System.out.println("Medlemstype:");
                        System.out.println("1. Aktiv");
                        System.out.println("2. Passiv");
                        incorrectInput = true;
                        while (incorrectInput) {
                            if (input.hasNextInt()) {
                                userChoice = input.nextInt();
                                if (userChoice < 1 || userChoice > 2) {
                                    System.out.println("Proev igen. Dit heltal skal vaere 1 eller 2");
                                    input.nextLine();
                                } else {
                                    incorrectInput = false;
                                }
                            } else {
                                System.out.println("Proev igen, input var ikke et heltal");
                                input.nextLine();
                            }
                        }
                        boolean actOrPas;
                        if (userChoice == 1) {
                            actOrPas = true;
                        } else {
                            actOrPas = false;
                        }
                        Member memb = new Member(stringInput, memAge, actOrPas);
                        memList.add(memb);

                    } else {
                        System.out.println("Medlemsnavn:");
                        stringInput = input.next();

                        System.out.println("Medlems alder:");
                        incorrectInput = true;
                        while (incorrectInput) {
                            if (input.hasNextInt()) {
                                userChoice = input.nextInt();
                                if (userChoice < 1) {
                                    System.out.println("Proev igen. Dit heltal skal vaere 1 eller over");
                                    input.nextLine();
                                } else {
                                    incorrectInput = false;
                                }
                            } else {
                                System.out.println("Proev igen, input var ikke et heltal");
                                input.nextLine();
                            }
                        }
                        int memAge = userChoice;

                        System.out.println("Medlemstype:");
                        System.out.println("1. Aktiv");
                        System.out.println("2. Passiv");
                        incorrectInput = true;
                        while (incorrectInput) {
                            if (input.hasNextInt()) {
                                userChoice = input.nextInt();
                                if (userChoice < 1 || userChoice > 2) {
                                    System.out.println("Proev igen. Dit heltal skal vaere 1 eller 2");
                                    input.nextLine();
                                } else {
                                    incorrectInput = false;
                                }
                            } else {
                                System.out.println("Proev igen, input var ikke et heltal");
                                input.nextLine();
                            }
                        }
                        boolean actOrPas;
                        if (userChoice == 1) {
                            actOrPas = true;
                        } else {
                            actOrPas = false;
                        }
                        System.out.println("Vil medlemmet deltage i crawl?");
                        System.out.println("1 = Ja");
                        System.out.println("2 = Nej");
                        incorrectInput = true;
                        while (incorrectInput) {
                            if (input.hasNextInt()) {
                                userChoice = input.nextInt();
                                if (userChoice < 1 || userChoice > 2) {
                                    System.out.println("Proev igen. Dit heltal skal vaere 1 eller 2");
                                    input.nextLine();
                                } else {
                                    incorrectInput = false;
                                }
                            } else {
                                System.out.println("Proev igen, input var ikke et heltal");
                                input.nextLine();
                            }
                        }
                        boolean actOrPas2;
                        if (userChoice == 1) {
                            actOrPas2 = true;
                        } else {
                            actOrPas2 = false;
                        }
                        System.out.println("Vil medlemmet deltage i backstroke?");
                        System.out.println("1 = Ja");
                        System.out.println("2 = Nej");
                        incorrectInput = true;
                        while (incorrectInput) {
                            if (input.hasNextInt()) {
                                userChoice = input.nextInt();
                                if (userChoice < 1 || userChoice > 2) {
                                    System.out.println("Proev igen. Dit heltal skal vaere 1 eller 2");
                                    input.nextLine();
                                } else {
                                    incorrectInput = false;
                                }
                            } else {
                                System.out.println("Proev igen, input var ikke et heltal");
                                input.nextLine();
                            }
                        }
                        boolean actOrPas3;
                        if (userChoice == 1) {
                            actOrPas3 = true;
                        } else {
                            actOrPas3 = false;
                        }
                        Member memb = new Member(stringInput, memAge, actOrPas, actOrPas2, actOrPas3);
                        memList.add(memb);
                        if (memb.getAge() < 18 && memb.isCompetitive()) {
                            u18.add(memb);
                        } else if (memb.getAge() > 17 && memb.isCompetitive()) {
                            o18.add(memb);
                        } else {
                            break;
                        }
                    }
                    break;

                case 2: //Visning/redigering af medlem information
                    System.out.println("Vaelg et medlem:");
                    for (int i = 0; i < memList.size(); i++) {
                        System.out.println(i+1+". "+memList.get(i).getName());
                    }
                    incorrectInput = true;
                    while (incorrectInput) {
                        if (input.hasNextInt()) {
                            userChoice = input.nextInt();
                            if (userChoice < 1 || userChoice > memList.size()) {
                                System.out.println("Proev igen. Dit heltal skal vaere 1 eller 2");
                                input.nextLine();
                            } else {
                                incorrectInput = false;
                            }
                        } else {
                            System.out.println("Proev igen, input var ikke et heltal");
                            input.nextLine();
                        }
                    }
                    int memChoice = userChoice-1;

                    if (memList.get(memChoice).isCompetitive()) {
                        System.out.println("Navn: " + memList.get(memChoice).getName());
                        System.out.println("Alder: " + memList.get(memChoice).getAge());
                        if (memList.get(memChoice).isActive()) {
                            System.out.println("Aktivt medlem");
                        } else {
                            System.out.println("Passivt medlem");
                        }
                        System.out.println("Konkurrencesvoemmer");
                        if (memList.get(memChoice).isCrawl() && memList.get(memChoice).isBackstroke()) {
                            System.out.println("Aktiv i: Crawl & Backstroke");
                        } else if (!memList.get(memChoice).isCrawl() && memList.get(memChoice).isBackstroke()) {
                            System.out.println("Aktiv i: Backstroke");
                        } else if (!memList.get(memChoice).isBackstroke() && memList.get(memChoice).isCrawl()) {
                            System.out.println("Aktiv i: Crawl");
                        }
                        System.out.println("Kontingent beloeb: " + memList.get(memChoice).getSubFee());
                        if (memList.get(memChoice).isSubPaid()) {
                            System.out.println("Betalingsstatus: Betalt");
                        } else {
                            System.out.println("Betalingsstatus: Ikke betalt");
                        }
                    } else {
                        System.out.println("Navn: " + memList.get(memChoice).getName());
                        System.out.println("Alder: " + memList.get(memChoice).getAge());
                        if (memList.get(memChoice).isActive()) {
                            System.out.println("Aktivt medlem");
                        } else {
                            System.out.println("Passivt medlem");
                        }
                        System.out.println("Motionistsvoemmer");
                        System.out.println("Kontingent beloeb: " + memList.get(memChoice).getSubFee());
                        if (memList.get(memChoice).isSubPaid()) {
                            System.out.println("Betalingsstatus: Betalt");
                        } else {
                            System.out.println("Betalingsstatus: Ikke betalt");
                        }
                    }
                    System.out.println("Vaelg den data du vil redigere:");
                    System.out.println("1. Navn");
                    System.out.println("2. Alder");
                    System.out.println("3. Aktivitetsstatus (passiv/aktiv)");
                    System.out.println("4. Motionist eller konkurrencesvoemmer");
                    System.out.println("5. Kontingent");
                    System.out.println("6. Svoemmedisciplin");
                    System.out.println("0. Vend tilbage til hovedmenuen");
                    incorrectInput = true;
                    while (incorrectInput) {
                        if (input.hasNextInt()) {
                            userChoice = input.nextInt();
                            if (userChoice < 0 || userChoice > 6) {
                                System.out.println("Proev igen. Dit heltal skal vaere mellem 0-6");
                                input.nextLine();
                            } else {
                                incorrectInput = false;
                            }
                        } else {
                            System.out.println("Proev igen, input var ikke et heltal");
                            input.nextLine();
                        }
                    }
                    choice2 = userChoice;

                    switch (choice2) { //Redigering af medlemsinformation
                        case 1:
                            System.out.println("Indtast det nye navn:");
                            stringInput = input.next();
                            memList.get(memChoice).setName(stringInput);
                            break;
                        case 2: //Navn
                            System.out.println("Indtast en ny alder:");
                            incorrectInput = true;
                            while (incorrectInput) {
                                if (input.hasNextInt()) {
                                    userChoice = input.nextInt();
                                    if (userChoice < 1) {
                                        System.out.println("Proev igen. Dit heltal skal vaere 1 eller over");
                                        input.nextLine();
                                    } else {
                                        incorrectInput = false;
                                    }
                                } else {
                                    System.out.println("Proev igen, input var ikke et heltal");
                                    input.nextLine();
                                }
                            }
                            int memAge = userChoice;
                            memList.get(memChoice).setAge(memAge);
                            break;
                        case 3: //Status
                            System.out.println("Vaelg medlemsstatus:");
                            System.out.println("1. Aktivt medlem");
                            System.out.println("2. Passivt medlem");
                            incorrectInput = true;
                            while (incorrectInput) {
                                if (input.hasNextInt()) {
                                    userChoice = input.nextInt();
                                    if (userChoice < 1 || userChoice > 2) {
                                        System.out.println("Proev igen. Dit heltal skal vaere 1 eller 2");
                                        input.nextLine();
                                    } else {
                                        incorrectInput = false;
                                    }
                                } else {
                                    System.out.println("Proev igen, input var ikke et heltal");
                                    input.nextLine();
                                }
                            }
                            boolean actOrPas;
                            if (userChoice == 1) {
                                actOrPas = true;
                            } else {
                                actOrPas = false;
                            }
                            memList.get(memChoice).setActive(actOrPas);
                            break;
                        case 4: //Konkurrence/Motionst
                            System.out.println("Er medlemmet motionist eller konkurrencesvoemmer?");
                            System.out.println("1 = konkurrencesvoemmer");
                            System.out.println("2 = motionist");
                            incorrectInput = true;
                            while (incorrectInput) {
                                if (input.hasNextInt()) {
                                    userChoice = input.nextInt();
                                    if (userChoice < 1 || userChoice > 2) {
                                        System.out.println("Proev igen. Dit heltal skal vaere 1 eller 2");
                                        input.nextLine();
                                    } else {
                                        incorrectInput = false;
                                    }
                                } else {
                                    System.out.println("Proev igen, input var ikke et heltal");
                                    input.nextLine();
                                }
                            }
                            if (userChoice == 1) {
                                actOrPas = true;
                            } else {
                                actOrPas = false;
                            }
                            memList.get(memChoice).setCompetitive(actOrPas);
                            break;
                        case 5: //Kontingent beløb og betalingsstatus
                            System.out.println("Hvilken data vil du aendre paa:");
                            System.out.println("1. Betalingsbeloeb.");
                            System.out.println("2. Betalingsstatus.");
                            incorrectInput = true;
                            while (incorrectInput) {
                                if (input.hasNextInt()) {
                                    userChoice = input.nextInt();
                                    if (userChoice < 1 || userChoice > 2) {
                                        System.out.println("Proev igen. Dit heltal skal vaere 1 eller 2");
                                        input.nextLine();
                                    } else {
                                        incorrectInput = false;
                                    }
                                } else {
                                    System.out.println("Proev igen, input var ikke et heltal");
                                    input.nextLine();
                                }
                            }
                            int choice3 = userChoice;
                            if (choice3 == 1) {
                                System.out.println("Indtast det nye kontigent beloeb:");
                                incorrectInput = true;
                                while (incorrectInput) {
                                    if (input.hasNextInt()) {
                                        userChoice = input.nextInt();
                                        if (userChoice < 1) {
                                            System.out.println("Proev igen. Tallet skal vaere et positivt heltal");
                                            input.nextLine();
                                        } else {
                                            incorrectInput = false;
                                        }
                                    } else {
                                        System.out.println("Proev igen, input var ikke et heltal");
                                        input.nextLine();
                                    }
                                }
                                int newSubFee = userChoice;
                                memList.get(memChoice).setSubFee(newSubFee);
                            } else {
                                System.out.println("Indtast betalingsstatus:");
                                System.out.println("1. Betalt.");
                                System.out.println("2. Ikke betalt.");
                                incorrectInput = true;
                                while (incorrectInput) {
                                    if (input.hasNextInt()) {
                                        userChoice = input.nextInt();
                                        if (userChoice < 1 || userChoice > 2) {
                                            System.out.println("Proev igen. Dit heltal skal vaere 1 eller 2");
                                            input.nextLine();
                                        } else {
                                            incorrectInput = false;
                                        }
                                    } else {
                                        System.out.println("Proev igen, input var ikke et heltal");
                                        input.nextLine();
                                    }
                                }
                                if (userChoice == 1) {
                                    actOrPas = true;
                                } else {
                                    actOrPas = false;
                                }
                                memList.get(memChoice).setSubPaid(actOrPas);
                            }
                            break;
                        case 6: //Svømmediscipliner som medlemmet er aktivt i
                            System.out.println("1. Crawl.");
                            System.out.println("2. Backstroke.");
                            incorrectInput = true;
                            while (incorrectInput) {
                                if (input.hasNextInt()) {
                                    userChoice = input.nextInt();
                                    if (userChoice < 1 || userChoice > 2) {
                                        System.out.println("Proev igen. Dit heltal skal vaere 1 eller 2");
                                        input.nextLine();
                                    } else {
                                        incorrectInput = false;
                                    }
                                } else {
                                    System.out.println("Proev igen, input var ikke et heltal");
                                    input.nextLine();
                                }
                            }
                            choice3 = userChoice;

                            if (choice3 == 1) {
                                System.out.println("Vaelg aktivitetsstatus:");
                                System.out.println("1. aktiv");
                                System.out.println("2. ikke aktiv");
                                incorrectInput = true;
                                while (incorrectInput) {
                                    if (input.hasNextInt()) {
                                        userChoice = input.nextInt();
                                        if (userChoice < 1 || userChoice > 2) {
                                            System.out.println("Proev igen. Dit heltal skal vaere 1 eller 2");
                                            input.nextLine();
                                        } else {
                                            incorrectInput = false;
                                        }
                                    } else {
                                        System.out.println("Proev igen, input var ikke et heltal");
                                        input.nextLine();
                                    }
                                }
                                if (userChoice == 1) {
                                    actOrPas = true;
                                } else {
                                    actOrPas = false;
                                }
                                memList.get(memChoice).setCrawl(actOrPas);
                            } else {
                                System.out.println("Vaelg aktivitetsstatus:");
                                System.out.println("1. aktiv");
                                System.out.println("2. ikke aktiv");
                                incorrectInput = true;
                                while (incorrectInput) {
                                    if (input.hasNextInt()) {
                                        userChoice = input.nextInt();
                                        if (userChoice < 1 || userChoice > 2) {
                                            System.out.println("Proev igen. Dit heltal skal vaere 1 eller 2");
                                            input.nextLine();
                                        } else {
                                            incorrectInput = false;
                                        }
                                    } else {
                                        System.out.println("Proev igen, input var ikke et heltal");
                                        input.nextLine();
                                    }
                                }
                                if (userChoice == 1) {
                                    actOrPas = true;
                                } else {
                                    actOrPas = false;
                                }
                                memList.get(memChoice).setBackstroke(actOrPas);
                            }
                            break;
                        case 0:
                            break;
                    }
                    break;

                case 3: //Viser medlemmer i restance + beløbet de skylder
                    for (int i = 0; i < memList.size(); i++) {
                        if (!memList.get(i).isSubPaid()) {
                            System.out.println("Navn: "+ memList.get(i).getName() + ". Beloeb i restance: " + memList.get(i).getSubFee() + " kr");
                            System.out.println(" ");
                        }
                    }
                    break;
                case 4: //Indtastning af træningsdata
                    System.out.println("Er det en u18 eller senior svoemmmer?");
                    System.out.println("1. u18");
                    System.out.println("2. Senior");
                    incorrectInput = true;
                    while (incorrectInput) {
                        if (input.hasNextInt()) {
                            userChoice = input.nextInt();
                            if (userChoice < 1 || userChoice > 2) {
                                System.out.println("Proev igen. Dit heltal skal vaere 1 eller 2");
                                input.nextLine();
                            } else {
                                incorrectInput = false;
                            }
                        } else {
                            System.out.println("Proev igen, input var ikke et heltal");
                            input.nextLine();
                        }
                    }
                    choice2 = userChoice;
                    if (choice2 == 1) {
                        if (u18.size() == 0) {
                            System.out.println("Der er ingen medlemmer paa u18 holdet");
                            break;
                        }
                        System.out.println("Vaelg et medlem:");
                        for (int i = 0; i < u18.size(); i++) {
                            System.out.println(i+1+". "+u18.get(i).getName());
                        }
                        incorrectInput = true;
                        while (incorrectInput) {
                            if (input.hasNextInt()) {
                                userChoice = input.nextInt();
                                if (userChoice < 1 || userChoice > u18.size()) {
                                    System.out.println("Proev igen. Dit heltal skal vaere mellem 1 til " + u18.size());
                                    input.nextLine();
                                } else {
                                    incorrectInput = false;
                                }
                            } else {
                                System.out.println("Proev igen, input var ikke et heltal");
                                input.nextLine();
                            }
                        }
                        memChoice = userChoice-1;

                        System.out.println("Vaelg en disciplin:");
                        for (int i = 0; i < swimDisciplines.size(); i++) {
                            System.out.println(i+1+". " +swimDisciplines.get(i).getDistance() + "m " + swimDisciplines.get(i).getDisName());
                        }
                        incorrectInput = true;
                        while (incorrectInput) {
                            if (input.hasNextInt()) {
                                userChoice = input.nextInt();
                                if (userChoice < 1 || userChoice > swimDisciplines.size()) {
                                    System.out.println("Proev igen. Dit heltal skal vaere mellem 1 til " + swimDisciplines.size());
                                    input.nextLine();
                                } else {
                                    incorrectInput = false;
                                }
                            } else {
                                System.out.println("Proev igen, input var ikke et heltal");
                                input.nextLine();
                            }
                        }
                        int disChoice = userChoice - 1;

                        System.out.println("Indtast tid: (Double format)");
                        incorrectInput = true;
                        double userChoiceDouble = -1.0;
                        while (incorrectInput) {
                            if (input.hasNextDouble()) {
                                userChoiceDouble = input.nextDouble();
                                if (userChoiceDouble < 0.0) {
                                    System.out.println("Proev igen. Svoemmetiden kan ikke vaere negativ.");
                                    input.nextLine();
                                } else {
                                    incorrectInput = false;
                                }
                            } else {
                                System.out.println("Proev igen, input var ikke et heltal");
                                input.nextLine();
                            }
                        }
                        Double swimTime = userChoiceDouble;

                        System.out.println("Dato: (DDMMYY int format)");
                        incorrectInput = true;
                        while (incorrectInput) {
                            if (input.hasNextInt()) {
                                userChoice = input.nextInt();
                                incorrectInput = false;
                                input.nextLine();
                            } else {
                                System.out.println("Proev igen, input var ikke et heltal");
                                input.nextLine();
                            }
                        }
                        int date = userChoice;
                        SwimResult trainResult = new SwimResult(swimTime, date, u18.get(memChoice), swimDisciplines.get(disChoice));
                        u18TrainList.add(trainResult);
                        break;
                    } else {
                        if (o18.size() == 0) {
                            System.out.println("Der er ingen medlemmer paa senior holdet");
                            break;
                        }
                        System.out.println("Vaelg et medlem:");
                        for (int i = 0; i < o18.size(); i++) {
                            System.out.println(i+1+". "+o18.get(i).getName());
                        }
                        incorrectInput = true;
                        while (incorrectInput) {
                            if (input.hasNextInt()) {
                                userChoice = input.nextInt();
                                if (userChoice < 1 || userChoice > o18.size()) {
                                    System.out.println("Proev igen. Dit heltal skal vaere mellem 1 til " + o18.size());
                                    input.nextLine();
                                } else {
                                    incorrectInput = false;
                                }
                            } else {
                                System.out.println("Proev igen, input var ikke et heltal");
                                input.nextLine();
                            }
                        }
                        memChoice = userChoice-1;
                        System.out.println("Vaelg en disciplin:");
                        for (int i = 0; i < swimDisciplines.size(); i++) {
                            System.out.println(i + 1 + ". " + swimDisciplines.get(i).getDistance() + "m " + swimDisciplines.get(i).getDisName());
                        }
                        incorrectInput = true;
                        while (incorrectInput) {
                            if (input.hasNextInt()) {
                                userChoice = input.nextInt();
                                if (userChoice < 1 || userChoice > swimDisciplines.size()) {
                                    System.out.println("Proev igen. Dit heltal skal vaere mellem 1 til " + swimDisciplines.size());
                                    input.nextLine();
                                } else {
                                    incorrectInput = false;
                                }
                            } else {
                                System.out.println("Proev igen, input var ikke et heltal");
                                input.nextLine();
                            }
                        }
                        int disChoice = userChoice - 1;

                        System.out.println("Indtast tid: (Double format)");
                        incorrectInput = true;
                        double userChoiceDouble = -1.0;
                        while (incorrectInput) {
                            if (input.hasNextDouble()) {
                                userChoiceDouble = input.nextDouble();
                                if (userChoiceDouble < 0.0) {
                                    System.out.println("Svoemmetiden kan ikke vaere negativ.");
                                    input.nextLine();
                                } else {
                                    incorrectInput = false;
                                }
                            } else {
                                System.out.println("Proev igen, input var ikke et heltal");
                                input.nextLine();
                            }
                        }
                        Double swimTime = userChoiceDouble;

                        System.out.println("Dato: (DDMMYY int format)");
                        incorrectInput = true;
                        while (incorrectInput) {
                            if (input.hasNextInt()) {
                                userChoice = input.nextInt();
                                incorrectInput = false;
                                input.nextLine();
                            } else {
                                System.out.println("Proev igen, input var ikke et heltal");
                                input.nextLine();
                            }
                        }
                        int date = userChoice;
                        SwimResult trainResult = new SwimResult(swimTime, date, o18.get(memChoice), swimDisciplines.get(disChoice));
                        o18TrainList.add(trainResult);
                        break;
                    }
                case 5: //Indtastning af stævnedata
                    System.out.println("Er det en u18 eller senior svoemmmer?");
                    System.out.println("1. u18");
                    System.out.println("2. Senior");
                    incorrectInput = true;
                    while (incorrectInput) {
                        if (input.hasNextInt()) {
                            userChoice = input.nextInt();
                            if (userChoice < 1 || userChoice > 2) {
                                System.out.println("Proev igen. Dit heltal skal vaere 1 eller 2");
                                input.nextLine();
                            } else {
                                incorrectInput = false;
                            }
                        } else {
                            System.out.println("Proev igen, input var ikke et heltal");
                            input.nextLine();
                        }
                    }
                    choice2 = userChoice;
                    if (choice2 == 1) {
                        if (u18.size() == 0) {
                            System.out.println("Der er ingen medlemmer paa u18 holdet");
                            break;
                        }
                        System.out.println("Vaelg et medlem:");
                        for (int i = 0; i < u18.size(); i++) {
                            System.out.println(i+1+". "+u18.get(i).getName());
                        }
                        incorrectInput = true;
                        while (incorrectInput) {
                            if (input.hasNextInt()) {
                                userChoice = input.nextInt();
                                if (userChoice < 1 || userChoice > u18.size()) {
                                    System.out.println("Proev igen. Dit heltal skal vaere mellem 1 til " + u18.size());
                                    input.nextLine();
                                } else {
                                    incorrectInput = false;
                                }
                            } else {
                                System.out.println("Proev igen, input var ikke et heltal");
                                input.nextLine();
                            }
                        }
                        memChoice = userChoice-1;

                        System.out.println("Vaelg en disciplin:");
                        for (int i = 0; i < swimDisciplines.size(); i++) {
                            System.out.println(i + 1 + ". " + swimDisciplines.get(i).getDistance() + "m " + swimDisciplines.get(i).getDisName());
                        }
                        incorrectInput = true;
                        while (incorrectInput) {
                            if (input.hasNextInt()) {
                                userChoice = input.nextInt();
                                if (userChoice < 1 || userChoice > swimDisciplines.size()) {
                                    System.out.println("Proev igen. Dit heltal skal vaere mellem 1 til " + swimDisciplines.size());
                                    input.nextLine();
                                } else {
                                    incorrectInput = false;
                                }
                            } else {
                                System.out.println("Proev igen, input var ikke et heltal");
                                input.nextLine();
                            }
                        }
                        int disChoice = userChoice - 1;

                        System.out.println("Indtast tid: (Double format)");
                        incorrectInput = true;
                        double userChoiceDouble = -1.0;
                        while (incorrectInput) {
                            if (input.hasNextDouble()) {
                                userChoiceDouble = input.nextDouble();
                                if (userChoiceDouble < 0.0) {
                                    System.out.println("Svoemmetiden kan ikke vaere negativ.");
                                    input.nextLine();
                                } else {
                                    incorrectInput = false;
                                }
                            } else {
                                System.out.println("Proev igen, input var ikke en double");
                                input.nextLine();
                            }
                        }
                        Double swimTime = userChoiceDouble;

                        System.out.println("Konkurrencenavn:");
                        stringInput = input.next();

                        System.out.println("Hvilken placering fik svoemmeren?");
                        incorrectInput = true;
                        while (incorrectInput) {
                            if (input.hasNextInt()) {
                                userChoice = input.nextInt();
                                if (userChoice < 1) {
                                    System.out.println("Proev igen. Tallet skal vaere et positivt heltal");
                                    input.nextLine();
                                } else {
                                    incorrectInput = false;
                                }
                            } else {
                                System.out.println("Proev igen, input var ikke et heltal");
                                input.nextLine();
                            }
                        }
                        int placement = userChoice;

                        SwimResult compResult = new SwimResult(swimTime, stringInput, placement, u18.get(memChoice), swimDisciplines.get(disChoice));
                        u18CompList.add(compResult);
                        break;
                    } else {
                        if (o18.size() == 0) {
                            System.out.println("Der er ingen medlemmer paa senior holdet");
                            break;
                        }
                        System.out.println("Vaelg et medlem:");
                        for (int i = 0; i < o18.size(); i++) {
                            System.out.println(i + 1 + ". " + o18.get(i).getName());
                        }
                        incorrectInput = true;
                        while (incorrectInput) {
                            if (input.hasNextInt()) {
                                userChoice = input.nextInt();
                                if (userChoice < 1 || userChoice > o18.size()) {
                                    System.out.println("Proev igen. Dit heltal skal vaere mellem 1 til " + o18.size());
                                    input.nextLine();
                                } else {
                                    incorrectInput = false;
                                }
                            } else {
                                System.out.println("Proev igen, input var ikke et heltal");
                                input.nextLine();
                            }
                        }
                        memChoice = userChoice-1;

                        System.out.println("Vaelg en disciplin:");
                        for (int i = 0; i < swimDisciplines.size(); i++) {
                            System.out.println(i + 1 + ". " + swimDisciplines.get(i).getDistance() + " " + swimDisciplines.get(i).getDisName());
                        }
                        incorrectInput = true;
                        while (incorrectInput) {
                            if (input.hasNextInt()) {
                                userChoice = input.nextInt();
                                if (userChoice < 1 || userChoice > swimDisciplines.size()) {
                                    System.out.println("Proev igen. Dit heltal skal vaere mellem 1 til " + swimDisciplines.size());
                                    input.nextLine();
                                } else {
                                    incorrectInput = false;
                                }
                            } else {
                                System.out.println("Proev igen, input var ikke et heltal");
                                input.nextLine();
                            }
                        }
                        int disChoice = userChoice - 1;

                        System.out.println("Indtast tid: (Double format)");
                        incorrectInput = true;
                        double userChoiceDouble = -1.0;
                        while (incorrectInput) {
                            if (input.hasNextDouble()) {
                                userChoiceDouble = input.nextDouble();
                                if (userChoiceDouble < 0.0) {
                                    System.out.println("Svoemmetiden kan ikke vaere negativ.");
                                    input.nextLine();
                                } else {
                                    incorrectInput = false;
                                }
                            } else {
                                System.out.println("Proev igen, input var ikke en double");
                                input.nextLine();
                            }
                        }
                        Double swimTime = userChoiceDouble;


                        System.out.println("Konkurrencenavn:");
                        stringInput = input.next();

                        System.out.println("Hvilken placering fik svoemmeren?");
                        incorrectInput = true;
                        while (incorrectInput) {
                            if (input.hasNextInt()) {
                                userChoice = input.nextInt();
                                if (userChoice < 1) {
                                    System.out.println("Proev igen. Tallet skal vaere et positivt heltal");
                                    input.nextLine();
                                } else {
                                    incorrectInput = false;
                                }
                            } else {
                                System.out.println("Proev igen, input var ikke et heltal");
                                input.nextLine();
                            }
                        }
                        int placement = userChoice;

                        SwimResult compResult = new SwimResult(swimTime, stringInput, placement, o18.get(memChoice), swimDisciplines.get(disChoice));
                        o18CompList.add(compResult);
                        break;
                    }
                case 6: //Visning af top 5 svømmere pr disciplin
                    System.out.println("u18 eller senior resultater:");
                    System.out.println("1. Top 5 u18");
                    System.out.println("2. Top 5 senior");

                    incorrectInput = true;
                    while (incorrectInput) {
                        if (input.hasNextInt()) {
                            userChoice = input.nextInt();
                            if (userChoice < 1 || userChoice > 2) {
                                System.out.println("Proev igen. Dit heltal skal vaere 1 eller 2");
                                input.nextLine();
                            } else {
                                incorrectInput = false;
                            }
                        } else {
                            System.out.println("Proev igen, input var ikke et heltal");
                            input.nextLine();
                        }
                    }
                    choice2 = userChoice;
                    if (choice2 == 1) {
                        System.out.println("Vaelg en disciplin:");
                        for (int i = 0; i < swimDisciplines.size(); i++) {
                            System.out.println(i + 1 + ". " + swimDisciplines.get(i).getDistance() + " " + swimDisciplines.get(i).getDisName());
                        }
                        incorrectInput = true;
                        while (incorrectInput) {
                            if (input.hasNextInt()) {
                                userChoice = input.nextInt();
                                if (userChoice < 1 || userChoice > swimDisciplines.size()) {
                                    System.out.println("Proev igen. Dit heltal skal vaere mellem 1 til " + swimDisciplines.size());
                                    input.nextLine();
                                } else {
                                    incorrectInput = false;
                                }
                            } else {
                                System.out.println("Proev igen, input var ikke et heltal");
                                input.nextLine();
                            }
                        }
                        int disChoice = userChoice - 1;

                        ArrayList<SwimResult> u18Best = new ArrayList<>(u18CompList);
                        u18Best.addAll(u18TrainList);
                        Collections.sort(u18Best, Comparator.comparingDouble(SwimResult::getTime)); //Sorterer resultater baseret på bedste tid
                        u18Best.removeIf(swimResult -> swimResult.getDiscipline() != swimDisciplines.get(disChoice)); //Frasorterer resultater fra de andre discipliner

                        HashSet<Object> u18NoDup = new HashSet<>(); // Bruges til at fjerne medlemmer der optræder på listen flere gange.
                        u18Best.removeIf(swimResult->!u18NoDup.add(swimResult.getMember()));

                        if (u18Best.size() < 5) {
                            for (int i = 0; i < u18Best.size(); i++) {
                                System.out.println(i + 1 + ". " + u18Best.get(i).getMember().toString() + " "+u18Best.get(i).getTime() + " Sekunder.");
                            }
                        } else {
                            for (int i = 0; i < 5; i++) {
                                System.out.println(i + 1 + ". " + u18Best.get(i).getMember().toString() + " " + u18Best.get(i).getTime() + " Sekunder.");
                            }
                        }
                        break;
                    } else {
                        System.out.println("Vaelg disciplin:");
                        for (int i = 0; i < swimDisciplines.size(); i++) {
                            System.out.println(i + 1 + ". " + swimDisciplines.get(i).getDistance() + " " + swimDisciplines.get(i).getDisName());
                        }
                        incorrectInput = true;
                        while (incorrectInput) {
                            if (input.hasNextInt()) {
                                userChoice = input.nextInt();
                                if (userChoice < 1 || userChoice > swimDisciplines.size()) {
                                    System.out.println("Proev igen. Dit heltal skal vaere mellem 1 til " + swimDisciplines.size());
                                    input.nextLine();
                                } else {
                                    incorrectInput = false;
                                }
                            } else {
                                System.out.println("Proev igen, input var ikke et heltal");
                                input.nextLine();
                            }
                        }
                        int disChoice = userChoice - 1;

                        ArrayList<SwimResult> o18Best = new ArrayList<>(o18CompList);
                        o18Best.addAll(o18TrainList);
                        Collections.sort(o18Best, Comparator.comparingDouble(SwimResult::getTime)); //Sorterer resultater baseret på bedste tid
                        o18Best.removeIf(swimResult -> swimResult.getDiscipline() != swimDisciplines.get(disChoice)); //Frasorterer resultater fra de andre discipliner

                        HashSet<Object> o18NoDup = new HashSet<>(); // Bruges til at fjerne medlemmer der optræder på listen flere gange.
                        o18Best.removeIf(swimResult->!o18NoDup.add(swimResult.getMember()));

                        if (o18Best.size() < 5) {
                            for (int i = 0; i < o18Best.size(); i++) {
                                System.out.println(i + 1 + ". " + o18Best.get(i).getMember().toString() + " "+o18Best.get(i).getTime() + " Sekunder.");
                            }
                        } else {
                            for (int i = 0; i < 5; i++) {
                                System.out.println(i + 1 + ". " + o18Best.get(i).getMember().toString() + " " + o18Best.get(i).getTime() + " Sekunder.");
                            }
                        }
                        break;
                    }
                case 0:
                    sentinel = false;
                    break;

                default:
                    System.out.println("Forkert input, proev igen.");
                    break;






            }



        }



    }
}