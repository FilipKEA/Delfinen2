import java.lang.reflect.Array;
import java.util.*;

import static java.util.stream.Collectors.collectingAndThen;

public class Main {
    public static void main(String[] args) {
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
        int intInput;
        int intInput2;
        int intInput3;
        int intInput4;
        double doubleInput;
        Scanner input = new Scanner(System.in);

        // TEST
        Member mem1 = new Member("Med1", 16, true, true, true);
        Member mem2 = new Member("Med2", 16, true, true, true);
        Member mem3 = new Member("Med3", 16, true, true, true);
        Member mem4 = new Member("Med4", 16, true, true, true);
        Member mem5 = new Member("Med5", 16, true, true, true);
        Member mem6 = new Member("Med6", 16, true, true, true);
        Member mem7 = new Member("Med7", 16, true, true, true);
        Member mem8 = new Member("Med8", 16, true, true, true);
        Member mem9 = new Member("Med9", 16, true, true, true);
        Member mem10 = new Member("Med10", 16, true, true, true);
        SwimResult res1 = new SwimResult(11.1, "Test", 1, mem1, crawl200m);
        SwimResult res2 = new SwimResult(11.2, "Test", 2, mem1, crawl200m);
        SwimResult res3 = new SwimResult(11.3, "Test", 3, mem2, crawl200m);
        SwimResult res4 = new SwimResult(11.4, "Test", 4, mem3, crawl200m);
        SwimResult res5 = new SwimResult(11.5, "Test", 5, mem4, crawl200m);
        SwimResult res6 = new SwimResult(11.6, "Test", 6, mem5, crawl200m);
        SwimResult res7 = new SwimResult(11.7, "Test", 6, mem6, crawl200m);
        SwimResult res8 = new SwimResult(11.8, "Test", 6, mem7, crawl200m);
        SwimResult res9 = new SwimResult(11.9, "Test", 6, mem8, crawl200m);
        u18CompList.add(res1);
        u18CompList.add(res2);
        u18CompList.add(res3);
        u18CompList.add(res4);
        u18CompList.add(res5);
        u18CompList.add(res6);
        u18CompList.add(res7);
        u18CompList.add(res8);
        u18CompList.add(res9);

        memList.add(mem1);
        memList.add(mem2);
        memList.add(mem3);
        memList.add(mem4);

        // Test slut



        while (sentinel) {
            System.out.println("Valgmuligheder:");
            System.out.println("1. Opret nyt medlem.");
            System.out.println("2. Rediger medlemsinformation.");
            System.out.println("3. Vis restance.");
            System.out.println("4. Indtast traeningsdata.");
            System.out.println("5. Indtast staevnedata.");
            System.out.println("6. Vis top 5 resultater.");
            System.out.println("0. Exit");
            while (!input.hasNextInt()) {
                System.out.println("Forkert input, proev igen:");
                input.nextLine();
            }
            int choice = input.nextInt();
            switch (choice) {
                case 1:
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

                        System.out.println("Medlemstype (Aktiv/Passiv)");
                        System.out.println("1 = Aktiv");
                        System.out.println("2 = Passiv");
                        incorrectInput = true;
                        while (incorrectInput) {
                            if (input.hasNextInt()) {
                                userChoice = input.nextInt();
                                if (userChoice < 1 || userChoice > 2) {
                                    System.out.println("Proev igen. Dit heltal skal minimum vaere 1 eller 2");
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
                        if (memb.getAge() < 18 && memb.isCompetitive()) {
                            u18.add(memb);
                        } else if (memb.getAge() > 17 && memb.isCompetitive()) {
                            o18.add(memb);
                        } else {
                            break;
                        }
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

                        System.out.println("Medlemstype (Aktiv/Passiv)");
                        System.out.println("1 = Aktiv");
                        System.out.println("2 = Passiv");
                        incorrectInput = true;
                        while (incorrectInput) {
                            if (input.hasNextInt()) {
                                userChoice = input.nextInt();
                                if (userChoice < 1 || userChoice > 2) {
                                    System.out.println("Proev igen. Dit heltal skal minimum vaere 1 eller 2");
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
                                    System.out.println("Proev igen. Dit heltal skal minimum vaere 1 eller 2");
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
                                    System.out.println("Proev igen. Dit heltal skal minimum vaere 1 eller 2");
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
                    }
                    break;
                case 2:
                    System.out.println("Vaelg et medlem:");
                    for (int i = 0; i < memList.size(); i++) {
                        System.out.println(i+1+". "+memList.get(i).getName());
                    }
                    incorrectInput = true;
                    while (incorrectInput) {
                        if (input.hasNextInt()) {
                            userChoice = input.nextInt();
                            if (userChoice < 1 || userChoice > memList.size()) {
                                System.out.println("Proev igen. Dit heltal skal minimum vaere 1 eller 2");
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
                    System.out.println("Vaelg den data du vil redigere:");
                    System.out.println("1. Navn");
                    System.out.println("2. Alder");
                    System.out.println("3. Aktivitetsstatus (passiv/aktiv)");
                    System.out.println("4. Motionist eller konkurrencesvoemmer");
                    System.out.println("5. Kontingent");
                    System.out.println("6. Svoemmedisciplin");
                    incorrectInput = true;
                    while (incorrectInput) {
                        if (input.hasNextInt()) {
                            userChoice = input.nextInt();
                            if (userChoice < 1 || userChoice > 6) {
                                System.out.println("Proev igen. Dit heltal skal mellem 1-6");
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
                    switch (choice2) {
                        case 1:
                            System.out.println("Indtast det nye navn:");
                            stringInput = input.next();
                            memList.get(memChoice).setName(stringInput);
                            break;
                        case 2:
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
                        case 3:
                            System.out.println("Indtast medlemmets status");
                            System.out.println("1 = aktivt medlem");
                            System.out.println("2 = passivt medlem");
                            incorrectInput = true;
                            while (incorrectInput) {
                                if (input.hasNextInt()) {
                                    userChoice = input.nextInt();
                                    if (userChoice < 1 || userChoice > 2) {
                                        System.out.println("Proev igen. Dit heltal skal minimum vaere 1 eller 2");
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
                        case 4:
                            System.out.println("Er medlemmet motionist eller konkurrencesvoemmer?");
                            System.out.println("1 = konkurrencesvoemmer");
                            System.out.println("2 = motionist");
                            incorrectInput = true;
                            while (incorrectInput) {
                                if (input.hasNextInt()) {
                                    userChoice = input.nextInt();
                                    if (userChoice < 1 || userChoice > 2) {
                                        System.out.println("Proev igen. Dit heltal skal minimum vaere 1 eller 2");
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
                        case 5:
                            System.out.println("Hvilken data vil du aendre paa:");
                            System.out.println("1. Betalingsbeloeb.");
                            System.out.println("2. Betalingsstatus.");
                            incorrectInput = true;
                            while (incorrectInput) {
                                if (input.hasNextInt()) {
                                    userChoice = input.nextInt();
                                    if (userChoice < 1 || userChoice > 2) {
                                        System.out.println("Proev igen. Dit heltal skal minimum vaere 1 eller 2");
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
                        case 6:
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
                    }



                case 3:
                    for (int i = 0; i < memList.size(); i++) {
                        if (!memList.get(i).isSubPaid()) {
                            System.out.println("Navn: "+ memList.get(i).getName() + ". Beloeb i restance: "+ memList.get(i).getSubFee());
                            System.out.println(" ");
                        }
                    }
                    break;
                case 4:
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
                        SwimResult trainResult = new SwimResult(swimTime, date, u18.get(memChoice), swimDisciplines.get(disChoice));
                        u18TrainList.add(trainResult);
                        break;
                    } else {
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
                case 5:
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
                                System.out.println("Proev igen, input var ikke et heltal");
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
                                System.out.println("Proev igen, input var ikke et heltal");
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
                case 6:
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
                        Collections.sort(u18Best, Comparator.comparingDouble(SwimResult::getTime));
                        u18Best.removeIf(swimResult -> swimResult.getDiscipline() != swimDisciplines.get(disChoice));

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
                            System.out.println(i+1+". "+swimDisciplines.get(i).getDistance()+"m "+swimDisciplines.get(i).getDisName());
                        }
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

                        ArrayList<SwimResult> o18Best = new ArrayList<>(o18CompList);
                        o18Best.addAll(o18TrainList);
                        Collections.sort(o18Best, Comparator.comparingDouble(SwimResult::getTime));
                        o18Best.removeIf(swimResult -> swimResult.getDiscipline() != swimDisciplines.get(disChoice));

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
                    break;






            }



        }



    }
}