package CLASSWORK27;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        run();
    }
    static void run() {
        Scanner sc = new Scanner(System.in);
        Movies moviesOriginal  = FileService.readFile();

        Movies movies = moviesOriginal;

        for (Movie m:
                movies.getMovies()) {
            System.out.println(m);
        }
        action(movies);
        repeat(movies);
    }

    static void repeat(Movies movies){
        Scanner sc= new Scanner(System.in);
        int answer = 0;
        while(true){
            System.out.println("Do you want to repeat? 1 - YES and any other number - NO");
            answer = sc.nextInt();
            if(answer == 1){
                action(movies);
                continue;
            }else{
                System.out.println("Program is stopped");
                break;
            }
        }
    }

        static void action(Movies movies){
        Scanner sc = new Scanner(System.in);
            int command = printMenu();
            switch (command){
                case 1:
                    for (Movie m:
                         movies.getMovies()) {
                        System.out.println(m);
                    }
                    break;
                case 2:
                    searchByName(movies);
                    break;
                case 3:
                    int sort = 0;
                    sort = printSort();
                    switch (sort){
                        case 1:
                            movies.getMovies().sort(Comparator.comparing(Movie::getYear));
                            for(Movie m : movies.getMovies()){
                                System.out.println(m);
                            }
                            System.out.println("And reversed:");
                            movies.getMovies().sort(Comparator.comparing(Movie::getYear).reversed());
                            for(Movie m : movies.getMovies()){
                                System.out.println(m);
                            }
                            break;
                        case 2:
                            movies.getMovies().sort(Comparator.comparing(Movie::getName));
                            for(Movie m : movies.getMovies()){
                                System.out.println(m);
                            }
                            System.out.println("And reversed:");
                            movies.getMovies().sort(Comparator.comparing(Movie::getName).reversed());
                            for(Movie m : movies.getMovies()){
                                System.out.println(m);
                            }
                            break;
                        case 3:
                            movies.getMovies().sort(Movie::compareTo);
                            for(Movie m : movies.getMovies()){
                                System.out.println(m);
                            }
                            System.out.println("And reversed:");
                            Collections.reverse(movies.getMovies());
                            for(Movie m : movies.getMovies()){
                                System.out.println(m);
                            }
                            break;
                    }
                    break;
                case 4:
                    int com = printOtherCommands();
                    switch (com){
                        case 1:
                            showMovies(1,movies);
                            break;
                        case 2:
                            showMovies(2,movies);
                            break;
                        case 3:
                            showMovies(3,movies);
                            break;
                        case 4:
                            printListOfMovies(movies,1);
                            break;
                        case 5:
                            printListOfMovies(movies,2);
                            break;

                    }

            }
        }
        static int printSort(){
            Scanner sc = new Scanner(System.in);
            String s = "";
            int sort = 0;
            while(true){
                try {
                    System.out.println("1 - sort by year");
                    System.out.println("2 - sort by name");
                    System.out.println("3 - sort by director");
                    System.out.print("Choose by what do you want to sort movies:");
                    s = sc.nextLine();
                    sort = isCapableInt(s);
                    isCapableCommand(sort,2);
                    return sort;
                }catch (NumberFormatException | InputMismatchException e){
                    System.out.println(e.getMessage());
                    continue;
                }

            }

        }
        static int printMenu() {
            Scanner sc = new Scanner(System.in);
            String c = "";
            int command = 0;
            while (true) {
                try {
                    System.out.println("1 - to show all the movies");
                    System.out.println("2 - to search movie by its' name");
                    System.out.println("3 - to sort movies");
                    System.out.println("4 - to search movie by any field and some lists");
                    System.out.print("Choose the action:");
                    c = sc.nextLine();
                    command = isCapableInt(c);
                    isCapableCommand(command,1);
                    return command;
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            }
        }


        static void printListOfMovies(Movies movies,int num){
        if(num ==1){
            Scanner sc = new Scanner(System.in);
            String a = "";
            System.out.print("Enter fullName of actor:");
            a = sc.nextLine();
            System.out.println(String.format("Movies with this actor %s",a));
            for (Movie m:movies.getMovies()) {
                for (Cast c:m.getCast()) {
                    if(c.getFullName().equals(a)){
                        System.out.println(String.format("Name of movie: %s and role of this actor: %s",m.getName(),c.getRole()));
                        System.out.println( );
                    }
                }
            }
        }else{
            for (Movie m:movies.getMovies()) {
                for (Cast c:m.getCast()) {

                }
            }
        }
    }
        static int printOtherCommands() {
            Scanner sc = new Scanner(System.in);
            String c = "";
            int com = 0;
            while(true) {
                try {
                    System.out.println("1 - to show movies with exact actor who was filming");
                    System.out.println("2 - to show movies those were direct by exact director");
                    System.out.println("3 - to show movies those were released in exact year");
                    System.out.println("4 - to show list of movies and role of exact actor");
                    System.out.println("5 - to show whole list of actors, their roles and names of these movies");
                    System.out.print("Choose action:");
                    c = sc.nextLine();
                    com = isCapableInt(c);
                    isCapableCommand(com,3);
                    return com;
                }catch (NumberFormatException | InputMismatchException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        static void showMovies(int num,Movies movies){
        Scanner sc = new Scanner(System.in);
            String a = "";
            switch (num){
                case 1:
                    System.out.print("Enter fullName of actor:");
                    a = sc.nextLine();
                    System.out.println(String.format("Movies with this actor %s",a));
                    for (Movie m:movies.getMovies()) {
                        for (Cast c:m.getCast()) {
                            if(c.getFullName().equals(a)){
                                System.out.println("Name of movie: " + m.getName());
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter fullName of director:");
                    a = sc.nextLine();
                    System.out.println(String.format("Movies those were direct due to %s",a));
                    for (Movie m:movies.getMovies()) {
                            if(m.getDirector().getFullName().equals(a)){
                                System.out.println("Name of movie: " + m.getName());
                        }
                    }
                    break;
                case 3:
                    int year = 0;
                    while(true){
                    try{
                        System.out.print("Enter a year of movie's release");
                        a = sc.nextLine();
                        year = isCapableInt(a);
                        System.out.println(String.format("Movies those were released in %d",year));
                        for (Movie m:movies.getMovies()) {
                            if(m.getYear() == year){
                                System.out.println("Name of movie: " + m.getName());
                            }
                        }
                        break;
                    }catch (NumberFormatException e){
                        System.out.println(e.getMessage());
                    }

            }
            }
        }
        static String searchByName(Movies movies){
        Scanner sc = new Scanner(System.in);
        String movie = "";
            System.out.print("Enter name of movie:");
            String name = sc.nextLine();
            for (Movie m : movies.getMovies()) {
                if(name.equals(m.getName())){
                    System.out.println(m);
                }else{
                }
            }
            return movie;
        }
        static void isCapableCommand(int num,int type)throws InputMismatchException {
        if(type == 1){
        if(num < 0 || num > 4){
            throw new InputMismatchException("Choose the correct action!!!");
        }
        }else if(type == 2){
            if(num < 0 || num > 3){
                throw new InputMismatchException("Choose the correct action!!!");
            }
        }else {
            if(num < 0 || num > 5){
                throw new InputMismatchException("Choose the correct action!!!");
            }
        }
        }
        static int isCapableInt(String c)throws NumberFormatException{
        try{
        int command = Integer.parseInt(c);
        return command;
    }catch (NumberFormatException e){
            throw new NumberFormatException("It should be Integer!!!");
        }
    }
}

