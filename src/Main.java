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
        String stringInput;
        int intInput;
        int intInput2;
        int intInput3;
        int intInput4;
        double doubleInput;
        boolean boolInput;
        boolean boolInput2;
        boolean boolInput3;
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
                    int userChoice;
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
                    int choice2 = input.nextInt();
                    if (choice2 == 1) {
                        System.out.println("Medlemsnavn:");
                        stringInput = input.next();
                        System.out.println("Medlems alder:");
                        intInput = input.nextInt();
                        System.out.println("Medlemstype (Aktiv/Passiv)");
                        System.out.println("true = Aktiv");
                        System.out.println("false = Passiv");
                        boolInput = input.nextBoolean();
                        Member memb = new Member(stringInput, intInput, boolInput);
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
                        intInput = input.nextInt();
                        System.out.println("Medlemstype (Aktiv/Passiv)");
                        System.out.println("true = Aktiv");
                        System.out.println("false = Passiv");
                        boolInput = input.nextBoolean();
                        System.out.println("Vil medlemmet deltage i crawl?");
                        System.out.println("true = Ja");
                        System.out.println("false = Nej");
                        boolInput2 = input.nextBoolean();
                        System.out.println("Vil medlemmet deltage i backstroke?");
                        System.out.println("true = Ja");
                        System.out.println("false = Nej");
                        boolInput3 = input.nextBoolean();
                        Member memb = new Member(stringInput, intInput, boolInput, boolInput2, boolInput3);
                        memList.add(memb);
                    }
                    break;
                case 2:
                    System.out.println("Vaelg et medlem:");
                    for (int i = 0; i < memList.size(); i++) {
                        System.out.println(i+1+". "+memList.get(i).toString());
                    }
                    intInput = input.nextInt()-1;
                    System.out.println("Vaelg den data du vil redigere:");
                    System.out.println("1. Navn");
                    System.out.println("2. Alder");
                    System.out.println("3. Aktivitetsstatus (passiv/aktiv)");
                    System.out.println("4. Motionist eller konkurrencesvoemmer");
                    System.out.println("5. Kontingent");
                    System.out.println("6. Svoemmedisciplin");

                    choice2 = input.nextInt();
                    switch (choice2) {
                        case 1:
                            System.out.println("Indtast det nye navn:");
                            stringInput = input.next();
                            memList.get(intInput).setName(stringInput);
                            break;
                        case 2:
                            System.out.println("Indtast en ny alder:");
                            intInput2 = input.nextInt();
                            memList.get(intInput).setAge(intInput2);
                            break;
                        case 3:
                            System.out.println("Indtast medlemmets status");
                            System.out.println("true = aktivt medlem");
                            System.out.println("false = passivt medlem");
                            boolInput = input.nextBoolean();
                            memList.get(intInput).setActive(boolInput);
                            break;
                        case 4:
                            System.out.println("Er medlemmet motionist eller konkurrencesvoemmer?");
                            System.out.println("true = Konkurrencesvoemmer.");
                            System.out.println("false = Motionist.");
                            boolInput = input.nextBoolean();
                            memList.get(intInput).setCompetitive(boolInput);
                            break;
                        case 5:
                            System.out.println("Hvilken data vil du aendre paa:");
                            System.out.println("1. Betalingsbeloeb.");
                            System.out.println("2. Betalingsstatus.");
                            intInput2 = input.nextInt();
                            if (intInput2 == 1) {
                                System.out.println("Indtast det nye kontigent beloeb:");
                                intInput3 = input.nextInt();
                                memList.get(intInput).setSubFee(intInput3);
                            } else if (intInput2 == 2) {
                                System.out.println("Indtast betalingsstatus:");
                                System.out.println("true = Betalt.");
                                System.out.println("false = Ikke betalt.");
                                boolInput = input.nextBoolean();
                                memList.get(intInput).setSubPaid(boolInput);
                            } else {
                                System.out.println("Forkert input.");
                            }
                            break;
                        case 6:
                            System.out.println("1. Crawl.");
                            System.out.println("2. Backstroke.");
                            intInput2 = input.nextInt();
                            if (intInput2 == 1) {
                                System.out.println("Vaelg aktivitetsstatus:");
                                System.out.println("true = aktiv");
                                System.out.println("false = ikke aktiv");
                                boolInput = input.nextBoolean();
                                memList.get(intInput).setCrawl(boolInput);
                            } else if (intInput2 == 2) {
                                System.out.println("Vaelg aktivitetsstatus:");
                                System.out.println("true = aktiv");
                                System.out.println("false = ikke aktiv");
                                boolInput = input.nextBoolean();
                                memList.get(intInput).setBackstroke(boolInput);
                            } else {
                                System.out.println("Forkert input.");
                            }
                            break;
                    }



                case 3:
                    for (int i = 0; i > memList.size(); i++) {
                        if (memList.get(i).isSubPaid() == false) {
                            System.out.println("Navn: "+memList.get(i).getName());
                            System.out.println("Beloeb i restance: "+memList.get(i).getSubFee());
                            System.out.println(" ");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Er det en u18 eller senior svoemmmer?");
                    System.out.println("1. u18");
                    System.out.println("2. Senior");
                    intInput = input.nextInt();
                    if (intInput == 1) {
                        System.out.println("Vaelg et medlem:");
                        for (int i = 0; i > u18.size(); i++) {
                            System.out.println(i+1+". "+u18.get(i).getName());
                        }
                        intInput2 = input.nextInt()-1;

                        System.out.println("Vaelg en disciplin:");
                        for (int i = 0; i > swimDisciplines.size(); i++) {
                            System.out.println(i+1+" "+swimDisciplines.get(i).getDistance()+" "+swimDisciplines.get(i).getDisName());
                        }
                        intInput3 = input.nextInt()-1;
                        System.out.println("Indtast tid: (Double format)");
                        doubleInput = input.nextDouble();
                        System.out.println("Dato: (DDMMYY int format)");
                        intInput4 = input.nextInt();
                        SwimResult trainResult = new SwimResult(doubleInput, intInput4, u18.get(intInput2), swimDisciplines.get(intInput3));
                        u18TrainList.add(trainResult);
                        break;
                    } else if (intInput == 2) {
                        System.out.println("Vaelg et medlem:");
                        for (int i = 0; i > o18.size(); i++) {
                            System.out.println(i+1+". "+o18.get(i).getName());
                        }
                        intInput2 = input.nextInt()-1;
                        System.out.println("Vaelg en disciplin:");
                        for (int i = 0; i > swimDisciplines.size(); i++) {
                            System.out.println(i+1+". "+swimDisciplines.get(i).getDistance()+" "+swimDisciplines.get(i).getDisName());
                        }
                        intInput3 = input.nextInt()-1;
                        System.out.println("Indtast tid: (Double format)");
                        doubleInput = input.nextDouble();
                        System.out.println("Dato: (DDMMYY int format)");
                        intInput4 = input.nextInt();
                        SwimResult trainResult = new SwimResult(doubleInput, intInput4, u18.get(intInput2), swimDisciplines.get(intInput3));
                        o18TrainList.add(trainResult);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    System.out.println("Er det en u18 eller senior svoemmmer?");
                    System.out.println("1. u18");
                    System.out.println("2. Senior");
                    intInput = input.nextInt();
                    if (intInput == 1) {
                        System.out.println("Vaelg et medlem:");
                        for (int i = 0; i > u18.size(); i++) {
                            System.out.println(i+1+". "+u18.get(i).getName());
                        }
                        intInput2 = input.nextInt()-1;

                        System.out.println("Vaelg en disciplin:");
                        for (int i = 0; i > swimDisciplines.size(); i++) {
                            System.out.println(i+1+" "+swimDisciplines.get(i).getDistance()+" "+swimDisciplines.get(i).getDisName());
                        }
                        intInput3 = input.nextInt()-1;

                        System.out.println("Indtast tid: (Double format)");
                        doubleInput = input.nextDouble();

                        System.out.println("Konkurrencenavn:");
                        stringInput = input.next();

                        System.out.println("Hvilken placering fik svoemmeren?");
                        intInput4 = input.nextInt();

                        SwimResult compResult = new SwimResult(doubleInput, stringInput, intInput4, u18.get(intInput2), swimDisciplines.get(intInput3));
                        u18CompList.add(compResult);
                        break;
                    } else if (intInput == 2) {
                        System.out.println("Vaelg et medlem:");
                        for (int i = 0; i > o18.size(); i++) {
                            System.out.println(i+1+". "+o18.get(i).getName());
                        }
                        intInput2 = input.nextInt()-1;
                        System.out.println("Vaelg en disciplin:");
                        for (int i = 0; i > swimDisciplines.size(); i++) {
                            System.out.println(i+1+". "+swimDisciplines.get(i).getDistance()+" "+swimDisciplines.get(i).getDisName());
                        }
                        intInput3 = input.nextInt()-1;
                        System.out.println("Indtast tid: (Double format)");
                        doubleInput = input.nextDouble();

                        System.out.println("Konkurrencenavn:");
                        stringInput = input.next();

                        System.out.println("Hvilken placering fik svoemmeren?");
                        intInput4 = input.nextInt();

                        SwimResult compResult = new SwimResult(doubleInput, stringInput, intInput4, o18.get(intInput2), swimDisciplines.get(intInput3));
                        o18CompList.add(compResult);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    System.out.println("Senior eller u18 resultater:");
                    System.out.println("1. Top 5 u18");
                    System.out.println("2. Top 5 senior");
                    choice2 = input.nextInt();
                    if (choice2 == 1) {
                        System.out.println("Vaelg disciplin:");
                        for (int i = 0; i < swimDisciplines.size(); i++) {
                            System.out.println(i+1+". "+swimDisciplines.get(i).getDistance()+"m "+swimDisciplines.get(i).getDisName());
                        }
                        intInput = input.nextInt()-1;
                        ArrayList<SwimResult> u18Best = new ArrayList<>(u18CompList);
                        u18Best.addAll(u18TrainList);
                        Collections.sort(u18Best, Comparator.comparingDouble(SwimResult::getTime));
                        int finalIntInput = intInput;
                        u18Best.removeIf(swimResult -> swimResult.getDiscipline() != swimDisciplines.get(finalIntInput));

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
                    } else if (choice2 == 2) {
                        System.out.println("Vaelg disciplin:");
                        for (int i = 0; i < swimDisciplines.size(); i++) {
                            System.out.println(i+1+". "+swimDisciplines.get(i).getDistance()+"m "+swimDisciplines.get(i).getDisName());
                        }
                        intInput = input.nextInt()-1;
                        ArrayList<SwimResult> o18Best = new ArrayList<>(o18CompList);
                        o18Best.addAll(o18TrainList);
                        Collections.sort(o18Best, Comparator.comparingDouble(SwimResult::getTime));
                        int finalIntInput = intInput;
                        o18Best.removeIf(swimResult -> swimResult.getDiscipline() != swimDisciplines.get(finalIntInput));

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